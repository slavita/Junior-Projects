import java.sql.SQLException;

public class SuperDbDriver_1 extends SuperDbDriver {
    static {
        try {
            java.sql.DriverManager.registerDriver(new SuperDbDriver_1());
        } catch (SQLException E) {
            throw new RuntimeException("Can't register driver");
        }
    }
}
