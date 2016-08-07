import java.sql.*;

public class MySQLExample_9 {
    public static final String JDBC_URL =
            "jdbc:mysql://127.0.0.1:3306/sys?user=root&password=root";

    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(JDBC_URL);
        try {
            conn.setAutoCommit(false);
            Statement statement = conn.createStatement();
            statement.execute("INSERT INTO tmp (id, name) VALUES (1, 'Mike')");
            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                conn.rollback();
            }
            throw e;
        }
    }
}
