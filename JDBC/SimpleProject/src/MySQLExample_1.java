import com.mysql.jdbc.JDBC4Connection;

import java.sql.SQLException;
import java.util.Properties;

public class MySQLExample_1 {
    /**
     * Строка подключения для MySQL
     * @jdbc:mysql - Это название протокола соединения
     * @127.0.0.1:3306 - хост и порт подключения
     * @sys - имя базы данных, которая уже существует в MySQL
     * @user - имя пользователя и @password - пароль
     */
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/sys?user=root&password=root";


    public static void main(String[] args) throws SQLException {
        /** Интерфейс, который должен реализовать каждый класс драйвера */
        com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();

        /** connect() - попытаться сделать соединение с базой данных к данному URL.
        /** @Properties персистентный набор свойств, расширяет Hashtable. */
        com.mysql.jdbc.JDBC4Connection connection =
                (JDBC4Connection) driver.connect(JDBC_URL, new Properties());

        try {
            // use conn here
        } finally {
            connection.close();
        }
    }
}
