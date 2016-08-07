import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Объект Statement используется для выполнения SQL-запросов к БД.
 *  Существует три типа объектов Statement. Все три служат как бы
 *  конейнерами для выполнения SQL-выражений через данное соединение:
 *  Statement, PreparedStatement, наследующий от Statement, и
 *  CallableStatement, наследующий от PreparedStatement. Они
 *  специализируются на различных типах запросов: Statement
 *  используется для выполненияпростых SQL-запросов без параметров;
 *  PreparedStatement используется для выполнения прекомпилированных
 *  SQL-запросов или без входных (IN) параметров; CallableStatement
 *  используется для вызовов хранимых процедур.
 */
import java.sql.Statement;

public class MySQLExample_7 {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/sys?user=root&password=root";

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            Statement statement = conn.createStatement();
            /**
             * @execute используется, когда операторы SQL возвращают более одного набора данных
             * @executeQuery -  необходим для запросов, результатом которых является
             * один единственный набор значений, таких как запросов SELECT.
             * @executeUpdate - используется для выполнения операторов INSERT, UPDATE
             * или DELETE, а также для операторов DDL (Data Definition Language -
             * язык определения данных), например, CREATE TABLE и DROP TABLE.
             */
            statement.execute("DROP TABLE IF EXISTS tmp;");
            statement.execute("CREATE TABLE tmp (id INT, name VARCHAR(64));");
            statement.execute("DROP TABLE tmp;");
        }
    }
}
