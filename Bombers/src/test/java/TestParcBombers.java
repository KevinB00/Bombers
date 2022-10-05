import conexion.Conexion;
import datos.ParcBombersDAO;
import dominio.ParcBombers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestParcBombers {
    public static void main(String[] args) throws SQLException {
        ParcBombersDAO parcBombersDAO = new ParcBombersDAO();
        Connection conexion = Conexion.getConnection();
        try{
            if(conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            //ParcBombers nuevoParcBombers = new ParcBombers("Nº335", 2);
            //parcBombersDAO.insert(nuevoParcBombers);

            //BORRAR
            ParcBombers borrarParcBombers = new ParcBombers(3);
            parcBombersDAO.delete(borrarParcBombers);

            //UPDATE
            ParcBombers updateParcBombers = new ParcBombers(2, "C/4522", 1);
            parcBombersDAO.update(updateParcBombers);
            conexion.commit();

            List<ParcBombers> parcBombers = parcBombersDAO.seleccionar();
            parcBombers.forEach(parcBomber -> {
            System.out.println("parcBombers = " + parcBomber);
            });
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Fallo en la operacion de inserción. Se ejecuta rollback");
            try{
                conexion.rollback();
            }catch(SQLException e1){
                e1.printStackTrace();
            }
        }

    }


}
