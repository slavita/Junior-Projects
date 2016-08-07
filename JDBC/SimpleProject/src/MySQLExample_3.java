import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

public class MySQLExample_3 {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/sys?user=root&password=root";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        /**
         * Когда класс Driver загружается, он должен создать вой экземпляр
         * и зарегистрировать его в DriverManager. Это означает, что
         * пользователь может загрузить и зарегистрировать драйвер таким способом
         */
        Class.forName(SuperDbDriver_1.class.getName());


        Enumeration<Driver> iter = DriverManager.getDrivers();
        while (iter.hasMoreElements()) {
            Driver driver = iter.nextElement();
            System.out.println("driver = " + driver);
        }

        try (java.sql.Connection conn = DriverManager.getConnection(JDBC_URL,  new Properties())) {
            System.out.println("conn = " + conn);
        }

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:SUPER_DB",  new Properties())) {
            System.out.println("conn = " + conn);
        }
    }
}
