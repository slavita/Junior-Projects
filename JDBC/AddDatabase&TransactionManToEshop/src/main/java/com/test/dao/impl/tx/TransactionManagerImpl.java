package com.test.dao.impl.tx;


import com.test.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TransactionManagerImpl extends BaseDataSource implements TransactionManager{
    public static final String JDBC_URL
            = "jdbc:mysql://127.0.0.1:3306/eshop?user=root&password=root";
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();

    @Override
    public <T> T doInTransaction(Callable<T> unitOfWork) throws Exception {
        Connection conn = DriverManager.getConnection(JDBC_URL);
        conn.setAutoCommit(false);
        connectionHolder.set(conn);
        try {
            T result = unitOfWork.call();
            conn.commit();
            return result;
        } catch (Exception e) {
            conn.rollback();
            throw e;
        } finally {
            JdbcUtils.closeQuietly(conn);
            connectionHolder.remove();
        }
    }

    public Connection getConnection() {
        return connectionHolder.get();
    }
}

/**
class MyTreadLocal<T> {
    private Map<Thread, T> holder = new ConcurrentHashMap<>();
    public T get() {
        return holder.get(Thread.currentThread());
    }
    public void set(T elem) {
        holder.put(Thread.currentThread(), elem);
    }
}

class Test {
    public static void main(String[] args) throws InterruptedException {
        final MyTreadLocal<String> local = new MyTreadLocal<>();
        System.out.println(local.get());
        local.set("Hello");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T2: " + local.get());
                local.set("Good!");
                System.out.println("T2: " + local.get());
            }
        });
        t.start();
        t.join();
        System.out.println(local.get());
    }
}
*/