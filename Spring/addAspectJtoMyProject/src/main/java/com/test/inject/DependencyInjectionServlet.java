package com.test.inject;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.lang.reflect.Field;
import java.util.List;

public class DependencyInjectionServlet extends HttpServlet {
    private static final String APP_CTX_PATH = "contextConfigLocation";

    @Override
    public final void init() throws ServletException {
        /**  Возвраает String содержащий значение именованного параметра инициализации */
        String appCtxPath = this.getServletContext().getInitParameter(APP_CTX_PATH);
        System.out.println("load" + APP_CTX_PATH + " -> " + appCtxPath);

        if (appCtxPath == null) {
            System.err.println("I need init param " + APP_CTX_PATH);
            throw new ServletException(APP_CTX_PATH + " init param == null");
        }

        try {
            /**
             * ApplicationContext в Spring это тип BeanFactory.
             * BeanFactory дает возможность доступа к JavaBeans которые
             * иницилизированы, связанные и управляемые Spring контейнером.
             * Хотя есть и другие BeanFactory классы в Spring,
             * ApplicationContext класс намного чаще используется, так как
             * он снабжает нас несколькими ценными особенностями – включение
             * поддержки для интернационализации, загрузка ресурсов,
             * интеграция с внешними иерархиями конекстов и много чего еще.
             */

            /**
             * Конструктор ClassPathXmlApplicationContext берет в
             * качестве аргумента файл описания контекста.
             */
            ApplicationContext appCtx = new ClassPathXmlApplicationContext(appCtxPath);
            List<Field> allFields = FieldReflector.collectUpTo(this.getClass(),DependencyInjectionServlet.this.getClass());
            List<Field> injectFields = FieldReflector.filterInject(allFields);

            for (Field field : injectFields) {

                /** Взламывает private поля */
                field.setAccessible(true);
                Inject annotation = field.getAnnotation(Inject.class);
                System.out.println("I find method marked by @Inject: " + field);
                String beanName = annotation.value();
                System.out.println("I must instantiate and inject '" + beanName +"'");
                Object bean = appCtx.getBean(beanName);
                System.out.println("Instantiate - OK: '" + beanName + "'");
                if (bean == null){
                    throw new ServletException("There isn't bean with name '" + beanName + "'");
                }
                /** Устанавливаем в поле которое нашли экземпяр bean */
                field.set(this, bean);
            }
        } catch (Exception e) {
            throw new ServletException("Can't inject from " + APP_CTX_PATH, e);
        }
    }
}
