package com.test.dao;

import com.test.dao.exception.DaoSystemException;
import com.test.dao.exception.NoSuchEntityException;
import com.test.entity.Product;

import java.util.List;


public interface ProductDao {
    Product selectById(int id) throws DaoSystemException, NoSuchEntityException;

    List<Product> selectAll() throws DaoSystemException;
}
