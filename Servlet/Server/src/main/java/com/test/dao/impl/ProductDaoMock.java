package com.test.dao.impl;

import com.test.dao.ProductDao;
import com.test.dao.exception.DaoSystemException;
import com.test.dao.exception.NoSuchEntityException;
import com.test.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class ProductDaoMock implements ProductDao {

    private final Map<Integer, Product> memory = new ConcurrentHashMap<>();

    public ProductDaoMock() {
        this.memory.put(1, new Product(1, "Апельсин"));
        this.memory.put(2, new Product(2, "Сыр"));
        this.memory.put(3, new Product(3, "Яблоко"));
    }

    @Override
    public Product selectById(int id) throws DaoSystemException, NoSuchEntityException{
        if(!memory.containsKey(id)){
            throw new NoSuchEntityException("No product for id = " + id);
        }

        return memory.get(id);
    }

    @Override
    public List<Product> selectAll() throws DaoSystemException {
        return new ArrayList<>(memory.values());
    }
}
