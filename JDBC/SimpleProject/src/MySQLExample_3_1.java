import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;


public class MySQLExample_3_1 {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/sys?user=root&password=root";

    public static void main(String[] args) throws SQLException {
        /** Регистрирует данный драйвер в DriverManager. */
        DriverManager.registerDriver(new SuperDbDriver());

        Enumeration<Driver> iter = DriverManager.getDrivers();
        while (iter.hasMoreElements()) {
            Driver driver = iter.nextElement();
            System.err.println("driver = " + driver);
        }

        try (java.sql.Connection conn = DriverManager.getConnection(JDBC_URL,  new Properties())) {
            System.out.println("conn = " + conn);
        }

        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:SUPER_DB",  new Properties())) {
            System.out.println("conn = " + conn);
        }
    }
}
