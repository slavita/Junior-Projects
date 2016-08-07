import java.sql.*;

public class MySQLExample_8 {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/sys?user=root&password=root";

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL)) {
            //conn.setAutoCommit(false);

            Statement statement = conn.createStatement();
            statement.execute("DROP TABLE IF EXISTS tmp;");
            statement.execute("CREATE TABLE tmp (id INT, name VARCHAR(64));");
            statement.execute("INSERT INTO tmp (id, name) VALUES (1, 'Mike')");
            statement.execute("INSERT INTO tmp (id, name) VALUES (2, 'Sara')");
            statement.execute("INSERT INTO tmp (id, name) VALUES (3, 'Anna')");

           // conn.rollback();

            /** Содержит все строки, удовлетворяющие условиям в SQL-выражении
             *ResultSet содержит т.н. курсор, который указывает на текущую
             * строку данных. Каждый раз, когда выполняется метод next,
             * курсор перемещается на одну строку вниз. Изначально курсор
             * спозиционирован перед первой строкой, и первый вызов next
             * премещает его на первую строку (она становится текущей).
             * С каждым успешным вызовом next курсор перемещается вниз на
             * одну строку, начиная с самой верхней в ResultSet.
             */
            ResultSet rs = statement.executeQuery("SELECT id, name FROM tmp");
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.printf("%d, %s\n", id, name);
            }

            statement.execute("DROP TABLE tmp;");
        }
    }
}
