
package capadatos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Elias San Martin
 */
public class Conexion {
    private static  String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static  String URL = "jdbc:mysql://localhost:3306/evaluacion?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static  String USER = "root";
    private static  String PASS = "admin";
    private static Driver driver = null;

    public static synchronized Connection getConnection()
        throws SQLException {
        if (driver == null) {
            try {
                Class jdbcDriverClass = Class.forName(DRIVER);
                driver = (Driver) jdbcDriverClass.newInstance();
                //publica la nueva instancia de controlador al administrador de controladores
                DriverManager.registerDriver(driver);
            } catch (Exception e) {
                System.out.println("Error al cargar el driver jdbc");
                e.printStackTrace();

            }
        }
        
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void close(PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}

