import conexion.Conexion;
import datos.BomberDAO;
import dominio.Bomber;
import java.sql.Connection;
import java.sql.SQLException;

public class TestBomberDAO {
    public static void main(String[] args) throws SQLException {

        BomberDAO bomberDAO = new BomberDAO();
        Connection conexion = Conexion.getConnection();
        try{
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }

            Bomber nuevoBomber = new Bomber("Antonio", "Calle Nª23", 2, 3, 2);
            bomberDAO.insertar(nuevoBomber);
            conexion.commit();

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Fallo en la operacion de inserción. Se ejecuta rollback");
            try{
                conexion.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }
        }


    }
}