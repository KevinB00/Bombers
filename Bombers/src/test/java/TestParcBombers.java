import conexion.Conexion;
import datos.ParcBombersDAO;
import dominio.ParcBombers;

import java.sql.Connection;
import java.sql.SQLException;

public class TestParcBombers {
    public static void main(String[] args) throws SQLException {
        ParcBombersDAO parcBombersDAO = new ParcBombersDAO();
        Connection conexion = Conexion.getConnection();
        try{
            if(conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            ParcBombers nuevoParcBombers = new ParcBombers("Nº34235", 2);
            parcBombersDAO.insert(nuevoParcBombers);
            conexion.commit();
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
