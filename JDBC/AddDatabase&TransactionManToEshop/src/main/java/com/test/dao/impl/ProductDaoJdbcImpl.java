package com.test.dao.impl;

import com.test.dao.ProductDao;
import com.test.dao.exception.DaoSystemException;
import com.test.dao.exception.NoSuchEntityException;
import com.test.entity.Product;
import com.test.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.mysql.jdbc.Driver;

public class ProductDaoJdbcImpl implements ProductDao {
    public static final String JDBC_URL
            = "jdbc:mysql://127.0.0.1:3306/eshop?user=root&password=root";

    public static final String SELECT_ALL_SQL = "SELECT id, name FROM products";
    public static final String SELECT_BY_ID_SQL = "SELECT id, name FROM products WHERE id=1";


    @Override
    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Driver driver = new Driver();
            conn = driver.connect(JDBC_URL, new Properties());
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SELECT_BY_ID_SQL);

            if (!rs.next()) {
                throw new NoSuchEntityException("No product for id");
            }
            Product result = new Product(rs.getInt("id"), rs.getString("name"));
            conn.commit();
            return result;
        } catch (SQLException e) {
            JdbcUtils.rollbackQuietly(conn);
            throw new DaoSystemException("Some exception", e);
        } finally {
            JdbcUtils.closeQuietly(rs, stmt, conn);
        }
    }

    @Override
    public List<Product> selectAll() throws DaoSystemException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<>();
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            conn = driver.connect(JDBC_URL, new Properties());
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(SELECT_ALL_SQL);
            rs = stmt.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name")));
            }
            conn.commit();
            return products;
        } catch (SQLException e) {
            JdbcUtils.rollbackQuietly(conn);
            throw new DaoSystemException("Some exception", e);
        } finally {
            JdbcUtils.closeQuietly(rs, stmt, conn);
        }
    }
}
