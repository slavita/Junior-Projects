package com.test.controller;


import com.test.dao.ProductDao;
import com.test.dao.exception.DaoSystemException;
import com.test.dao.exception.NoSuchEntityException;
import com.test.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.test.controller.ProductController.*;
import static org.mockito.Mockito.*;

public class ProductControllerTest {
    private ProductController controller;

    @Before
    public void setUp() {
        this.controller = new ProductController();
    }

    @Test
    public void test_no_param() throws ServletException, IOException {
        // init
        HttpServletRequest request = mock(HttpServletRequest.class);    /** создаём заменитель HttpServletRequest */
        when(request.getParameter(PARAM_ID)).thenReturn(null);          /** если запрос без атрибутов(id) */
        HttpServletResponse response = mock(HttpServletResponse.class); /** создаём заменитель HttpServletResponse */

        // use
        controller.doGet(request, response);

        // check
        verify(request).getParameter(PARAM_ID);     /** проверяем вызывался ли getParameter */
        verify(response).sendRedirect(PAGE_ERROR);  /** проверяем вызывался ли sendRedirect */
        verifyNoMoreInteractions(request, response);/** проверяем что больше никаких вызовов не было */

    }

    @Test
    public void test_bad_param() throws ServletException, IOException {
        // init
        HttpServletRequest request = mock(HttpServletRequest.class);
        // product.do?id=abc
        when(request.getParameter(PARAM_ID)).thenReturn("abc");
        HttpServletResponse response = mock(HttpServletResponse.class);

        // use
        controller.doGet(request, response);

        // check
        verify(request).getParameter(PARAM_ID);
        verify(response).sendRedirect(PAGE_ERROR);
        verifyNoMoreInteractions(request, response);

    }

    @Test
    public void test_no_in_dao() throws ServletException, IOException, DaoSystemException, NoSuchEntityException {
        // init
        HttpServletRequest request = mock(HttpServletRequest.class);        /** создаём заменитель HttpServletRequest */
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);       /** создаём заменитель RequestDispatcher */
        HttpServletResponse response = mock(HttpServletResponse.class);     /** создаём заменитель HttpServletResponse */
        ProductDao dao = mock(ProductDao.class);                            /** создаём заменитель ProductDao */
        Product product = new Product(123, "Paper");                        /** создаём экземпляр  Product */

        when(request.getParameter(PARAM_ID)).thenReturn("123");             /** когда будет вызван getParameter вернуть "123" */
        when(dao.selectById(anyInt())).thenReturn(product);                 /** когда будет вызван selectById с любым int вернуть product */
        when(request.getRequestDispatcher(PAGE_OK)).thenReturn(dispatcher); /** когда будет вызван getRequestDispatcher вернуть dispatcher */
        controller.productDao = dao;

        // use
        controller.doGet(request, response);

        // check
        verify(request).getParameter(PARAM_ID);
        verify(dao).selectById(123);
        verify(request).setAttribute(ATTRIBUTE_MODEL_TO_VIEW, product);
        verify(request).getRequestDispatcher(PAGE_OK);
        verify(dispatcher).forward(request, response);
        verifyNoMoreInteractions(request, response, dispatcher, dao);

    }

    @Test
    public void test_dao_crashed() throws ServletException, IOException, DaoSystemException, NoSuchEntityException {
        // init
        HttpServletRequest request = mock(HttpServletRequest.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        ProductDao dao = mock(ProductDao.class);

        when(request.getParameter(PARAM_ID)).thenReturn("123");
        when(dao.selectById(anyInt())).thenThrow(new DaoSystemException(""));
        controller.productDao = dao;

        // use
        controller.doGet(request, response);

        // check
        verify(request).getParameter(PARAM_ID);
        verify(dao).selectById(123);
        verify(response).sendRedirect(PAGE_ERROR);
        verifyNoMoreInteractions(request, response, dispatcher, dao);

    }
}
