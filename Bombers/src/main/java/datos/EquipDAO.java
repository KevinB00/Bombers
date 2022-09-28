package datos;
import java.util.*;

import conexion.Conexion;
import dominio.Equip;
import java.sql.*;

import static conexion.Conexion.close;
public class EquipDAO {

    private static final String SQL_SELECT = "SELECT CodEquip, Nom FROM equip";
    private static final String SQL_INSERT = "INSERT INTO equip (CodEquip, Nom) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE equip SET Nom=? WHERE CodEquip =?";
    private static final String SQL_DELETE = "DELETE FROM equip WHERE CodEquip =?";

    public List<Equip> seleccionar() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Equip equip = null;
        List<Equip> equips = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int CodEquip = rs.getInt("CodEquip");
                String Nom = rs.getString("Nom");

                equip = new Equip(CodEquip, Nom);
                equips.add(equip);
            }
        }catch (SQLException e) {
            e.printStackTrace(System.out);
            }finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return equips;
    }


    public int insert(Equip equip) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, equip.getCodEquip());
            stmt.setString(2, equip.getNom());
            result = stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }try {
                Conexion.close(stmt);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return result;
    }

    public int update(Equip equip) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, equip.getNom());
            stmt.setInt(2, equip.getCodEquip());
            result = stmt.executeUpdate();
        }catch (SQLException e) {
        e.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(conn);
        }catch (SQLException e){
                e.printStackTrace(System.out);
            }try{
                Conexion.close(stmt);
            }catch (SQLException e) {
            e.printStackTrace(System.out);
            }
        }
        return result;
    }

    public int delete(Equip equip) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, equip.getCodEquip());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
            try {
                Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
            return result;


    }
}