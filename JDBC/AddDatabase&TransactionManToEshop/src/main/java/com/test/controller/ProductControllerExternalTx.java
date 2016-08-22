package com.test.controller;

import com.test.dao.ProductDao;
import com.test.dao.exception.DaoSystemException;
import com.test.dao.exception.NoSuchEntityException;
import com.test.dao.impl.tx.TransactionManager;
import com.test.entity.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class ProductControllerExternalTx extends HttpServlet {
    public static final String PARAM_ID = "id";
    public static final String ATTRIBUTE_MODEL_TO_VIEW = "product";
    public static final String PAGE_OK = "product.jsp";
    public static final String PAGE_ERROR = "error.jsp";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("appContext.xml");
        TransactionManager txManager = (TransactionManager) context.getBean("txManager");
        final ProductDao productDao = (ProductDao) context.getBean("productDao");
        String idStr = req.getParameter(PARAM_ID);
        if(idStr != null){
            try {
                final Integer id = Integer.valueOf(idStr);


                Product model = txManager.doInTransaction(new Callable<Product>() {
                    @Override
                    public Product call() throws Exception {
                        return productDao.selectById(id);
                    }
                });
                req.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);
                //OK
                req.getRequestDispatcher(PAGE_OK).forward(req, resp);
                return;
            } catch (Exception e){
                // NOP
            }
        }

        resp.sendRedirect(PAGE_ERROR);
    }
}
