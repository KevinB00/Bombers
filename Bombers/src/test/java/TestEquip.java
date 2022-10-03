import conexion.Conexion;
import datos.EquipDAO;
import dominio.Equip;

import java.sql.Connection;
import java.sql.SQLException;

public class TestEquip {
    public static void main(String[] args) throws SQLException {
        EquipDAO equipDAO = new EquipDAO();
        Connection conexion = Conexion.getConnection();
        try {
            if (conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
            }
            Equip nuevoEquip = new Equip( 0, "equipo2");
            equipDAO.insert(nuevoEquip);
            conexion.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fallo en la operacion de inserción. Se ejecuta rollback");
            try{
        conexion.rollback();
    }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


}
