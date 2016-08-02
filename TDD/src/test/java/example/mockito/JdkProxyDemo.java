package example.mockito;


import org.mockito.cglib.proxy.InvocationHandler;
import org.mockito.cglib.proxy.Proxy;

import java.lang.reflect.Method;
import java.util.List;

public class JdkProxyDemo {
    public static void main(String[] args) {
        List<String> list = (List<String>) Proxy.newProxyInstance(null, new Class[]{List.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                switch (method.getName()) {
                    case "add":
                        return true;
                    case "get":
                        return "Hello from proxy";
                    case "size":
                        return -42;
                    case "iterator":
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        });
        System.out.println(list.add("A"));
        System.out.println(list.get(-1));
        System.out.println(list.size());
        System.out.println(list.iterator());
    }
}
