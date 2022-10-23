import conexion.Conexion;
import datos.EquipDAO;
import dominio.Equip;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestEquipDAO {
    public static void main(String[] args) throws SQLException {
        EquipDAO equipDAO = new EquipDAO();
        Connection conexion = Conexion.getConnection();
        try {
            if (conexion.getAutoCommit()) {
            conexion.setAutoCommit(false);
            }
            Equip nuevoEquip = new Equip("equipo4");
            equipDAO.insert(nuevoEquip);
/*
           //BORRAR
            Equip equipBorrar = new Equip(3);
            equipDAO.delete(equipBorrar);

            //UPDATE
            Equip equipModificar = new Equip(2, "equip1");
            equipDAO.update(equipModificar);
          */
            conexion.commit();
            List<Equip> equipList = equipDAO.seleccionar();
            equipList.forEach(equip -> {
                System.out.println("equip = " + equip);
            });
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
