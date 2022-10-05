package conexion;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
* La clase Conexion establecera conexion con la base d edatos descrita en el parámetro JDBC_URL
* JDBC_USER se describe el usuario con el que se conectará con la base de datos
* JDBC_PASSWORD se introduce la contraseña con la que establecer conexion
*/
public class Conexion {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/bomberseac4?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PASSWORD = "serpis";

    /*
    * Método que obtendrá la conexion
    */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    /*
    * Con estos métodos conseguiremos los métodos que se han abierto, para ello se utiliza close
    */
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement stmt) throws SQLException {
        stmt.close();
    }

    public static void close(Connection conn) throws SQLException {
        conn.close();
    }
}