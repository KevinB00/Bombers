package datos;
import java.util.*;

import conexion.Conexion;
import dominio.Equip;
import java.sql.*;

import static conexion.Conexion.close;
/*
 * Se definen las sententencias de acceso a la base de datos
 */
public class EquipDAO {
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT CodEquip, Nom FROM equip";
    private static final String SQL_INSERT = "INSERT INTO equip (CodEquip, Nom) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE equip SET Nom=? WHERE CodEquip =?";
    private static final String SQL_DELETE = "DELETE FROM equip WHERE CodEquip =?";

    public EquipDAO(){}
    public EquipDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    /*
     * El metodo lanzará la consulta select a la base de datos, devolverá un ArrayList de Equip
     */
    public List<Equip> seleccionar() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Equip equip = null;
        List<Equip> equips = new ArrayList<>();
        try {
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional :Conexion.getConnection();
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
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return equips;
    }
    /*
     * El método realizará una consulta INSERT a la base de datos.
     * Se pasa por parámetro un objeto Equip con el que se realizará la consulta
     */
    public int insert(Equip equip) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, equip.getCodEquip());
            stmt.setString(2, equip.getNom());
            result = stmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace(System.out);
        }finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }
        return result;
    }
    /*
     * Se realiza la consulta UPDATE a la base de datos.
     * Se pasa por parámetro un objeto Equip con el CodEquip correspondiente,
     * y poder identificar la fila en la que se encuentra en la base de datos
     */
    public int update(Equip equip) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, equip.getNom());
            stmt.setInt(2, equip.getCodEquip());
            result = stmt.executeUpdate();
        }catch (SQLException e) {
        e.printStackTrace(System.out);
        }finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        }
        return result;
    }
    /*
     * El metodo realizará la consulta DELETE a la base de datos
     * Solo será necesario pasar el CocEquip por parámetro
     */
    public int delete(Equip equip) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, equip.getCodEquip());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
            return result;


    }
}