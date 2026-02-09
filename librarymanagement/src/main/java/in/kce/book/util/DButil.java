package in.kce.book.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
    public static Connection getDBConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            return DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "system",
                "roshni"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
