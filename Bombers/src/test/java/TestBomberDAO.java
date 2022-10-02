import conexion.Conexion;
import datos.BomberDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class TestBomberDAO {
    public static void main(String[] args) throws SQLException {

        BomberDAO bomberDAO = new BomberDAO();
        Connection conexion = Conexion.getConnection();


    }
}
