
import java.sql.SQLException;
import java.util.Properties;

public class MySQLExample_2 {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/sys?user=root&password=root";

    public static void main(String[] args) throws SQLException {
        com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();

        /** acceptsURL() - может ли данный драйвер, открыть соединение с данным URL. */
        System.out.println(driver.acceptsURL("jdbc:SUPER_DB"));
        System.out.println(driver.acceptsURL(JDBC_URL));

        try (java.sql.Connection conn = driver.connect(JDBC_URL,  new Properties())) {
            System.out.println("conn = " + conn);
        }

    }
}
