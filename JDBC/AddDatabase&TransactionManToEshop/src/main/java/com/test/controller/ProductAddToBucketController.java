package com.test.controller;

import com.test.dao.ProductDao;
import com.test.dao.exception.DaoSystemException;
import com.test.dao.exception.NoSuchEntityException;
import com.test.dao.impl.ProductDaoJdbcImpl;
import com.test.dao.impl.ProductDaoMock;
import com.test.entity.Product;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Collections.singletonMap;
import static java.util.Collections.unmodifiableMap;

public class ProductAddToBucketController extends HttpServlet{
    static final String PARAM_ID = "id";
    static final String PAGE_ERROR = "productAll.do";
    public static final String PRODUCT_IN_BUCKET = "productsInBucket";

    private ProductDao productDao = new ProductDaoJdbcImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idStr = request.getParameter(PARAM_ID);
        if(idStr != null){
            try {
                Integer id = Integer.valueOf(idStr);
                Product product = productDao.selectById(id);

                HttpSession session = request.getSession(true);
                Map<Product, Integer> oldBucket = (Map<Product, Integer>) session.getAttribute(PRODUCT_IN_BUCKET);
                if(oldBucket == null){
                    session.setAttribute(PRODUCT_IN_BUCKET, singletonMap(product, 1));
                } else {
                    Map<Product, Integer> newBucket = new LinkedHashMap<>(oldBucket);
                    if(!oldBucket.containsKey(product)){
                        newBucket.put(product, 1);
                    } else {
                        newBucket.put(product, newBucket.get(product) + 1);
                    }
                    session.setAttribute(PRODUCT_IN_BUCKET, unmodifiableMap(newBucket));
                }

                String newLocation = "product.do?id=" + id;
                response.sendRedirect(newLocation);
                return;
            } catch (DaoSystemException |NoSuchEntityException | NumberFormatException a ) {

            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect(PAGE_ERROR);

        }
    }
}
