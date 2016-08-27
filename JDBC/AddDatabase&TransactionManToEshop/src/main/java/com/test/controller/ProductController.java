package com.test.controller;

import com.test.dao.ProductDao;
import com.test.dao.exception.DaoSystemException;
import com.test.dao.exception.NoSuchEntityException;
import com.test.dao.impl.ProductDaoJdbcExternalTxImpl;
import com.test.entity.Product;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ProductController extends HttpServlet {
    public static final String PARAM_ID = "id";
    public static final String ATTRIBUTE_MODEL_TO_VIEW = "product";
    public static final String PAGE_OK = "product.jsp";
    public static final String PAGE_ERROR = "error.jsp";

//    @Autowired
//    private ProductDao productDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("appContext.xml");
        ProductDao productDao = (ProductDao) context.getBean("productDao");
        String idStr = req.getParameter(PARAM_ID);
        if(idStr != null){
            try {
                Integer id = Integer.valueOf(idStr);
                Product model = productDao.selectById(id);
                req.setAttribute(ATTRIBUTE_MODEL_TO_VIEW, model);
                //OK
                req.getRequestDispatcher(PAGE_OK).forward(req, resp);
                return;
            } catch (NumberFormatException | NoSuchEntityException | DaoSystemException  | NullPointerException e){
                // NOP
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        resp.sendRedirect(PAGE_ERROR);
    }
}
