import conexion.Conexion;
import datos.BomberDAO;
import dominio.Bomber;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestBomberDAO {
    public static void main(String[] args) throws SQLException {

        BomberDAO bomberDAO = new BomberDAO();
        Connection conexion = Conexion.getConnection();
        try{
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            Bomber nuevoBomber = new Bomber("Juan", "C/d67", 2, 3, 2, 1);
            bomberDAO.insert(nuevoBomber);

            //BORRAR
           // Bomber bomberBorrar = new Bomber(4);
            //bomberDAO.delete(bomberBorrar);

            //UPDATE
            //Bomber bomberModificar = new Bomber(6, "Pepe", "C/5235", 2, 4, 1);
            //bomberDAO.update(bomberModificar);

            conexion.commit();

            List<Bomber> bombers = bomberDAO.seleccionar();
            bombers.forEach(bomber ->{
                System.out.println("bomber = " + bomber);
            });
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
