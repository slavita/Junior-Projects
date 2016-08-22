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

import static com.test.controller.ProductAddToBucketController.PRODUCT_IN_BUCKET;
import static java.util.Collections.unmodifiableMap;

public class ProductRemoveFromBucketController extends HttpServlet {

    static final String PARAM_ID = "id";
    static final String PAGE_ERROR = "productAll.do";


    private ProductDao productDao = new ProductDaoJdbcImpl();


        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String idStr = request.getParameter(PARAM_ID);
            if (idStr != null) {
                try {
                    Integer id = Integer.valueOf(idStr);
                    Product product = productDao.selectById(id);

                    HttpSession session = request.getSession(true);
                    Map<Product, Integer> oldBucket = (Map<Product, Integer>) session.getAttribute(PRODUCT_IN_BUCKET);
                    if (oldBucket == null) {
                        return;
                    } else {
                        Map<Product, Integer> newBucket = new LinkedHashMap<>(oldBucket);
                        if (newBucket.containsKey(product) &&  newBucket.get(product) > 1 ) {
                            newBucket.put(product, newBucket.get(product) - 1);
                        } else if(newBucket.containsKey(product) &&  newBucket.get(product) == 1){
                            newBucket.remove(product);
                        }

                        session.setAttribute(PRODUCT_IN_BUCKET, unmodifiableMap(newBucket));
                    }

                    String newLocation = "product.do?id=" + id;
                    response.sendRedirect(newLocation);
                    return;
                } catch (DaoSystemException | NoSuchEntityException | NumberFormatException a) {

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                response.sendRedirect(PAGE_ERROR);

            }
        }
    }

