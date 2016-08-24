package com.test.dao.impl;

import com.test.dao.ProductDao;
import com.test.dao.exception.DaoSystemException;
import com.test.dao.exception.NoSuchEntityException;
import com.test.entity.Product;
import com.test.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class ProductDaoJdbcExternalTxImpl implements ProductDao {
    public static final String SELECT_ALL_SQL = "SELECT id, name FROM products";
    public static final String SELECT_BY_ID_SQL = "SELECT id, name FROM products WHERE id=?";

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException, SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Connection conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SELECT_BY_ID_SQL);
            stmt.setInt(1, id);
            if (!rs.next()) {
                throw new NoSuchEntityException("No product for id");
            }
            return new Product(rs.getInt("id"), rs.getString("name"));
        } catch (SQLException e) {
            throw new DaoSystemException("Some exception", e);
        } finally {
            JdbcUtils.closeQuietly(rs, stmt);
        }
    }

    @Override
    public List<Product> selectAll() throws DaoSystemException {
        Statement stmt = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<>();
        try {
            Connection conn = dataSource.getConnection();
            stmt = conn.prepareStatement(SELECT_ALL_SQL);
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name")));
            }
            return products;
        } catch (SQLException e) {
            throw new DaoSystemException("Some exception", e);
        } finally {
            JdbcUtils.closeQuietly(rs, stmt);
        }
    }
}
