import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class MySQLExample_5 {
    public static void main(String[] args) throws IOException {
        /** JDBC 4.0 Драйвер должен включать файл
         * META-INF/services/java.sql.Driver.
         * Этот файл содержит имя реализации драйверов JDBC java.sql.Driver.
         * Например, чтобы загрузить my.sql.Driver класс,
         * META-INF/services/java.sql.Driver должен содержать запись:
         * @my.sql.Driver
         */
        // ClassLoader loader = Thread.currentThread().getContextClassLoader();
        ClassLoader loader1 = MySQLExample_5.class.getClassLoader();
        Enumeration<URL> drivers = loader1.getResources("META-INF/services/" + "java.sql.Driver");
        while (drivers.hasMoreElements()) {
            System.out.println(drivers.nextElement());
        }
    }
}
