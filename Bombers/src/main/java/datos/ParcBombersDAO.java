package datos;

import java.util.*;

import conexion.Conexion;
import dominio.ParcBombers;
import java.sql.*;

import static conexion.Conexion.close;
/*
 * Se definen las sententencias de acceso a la base de datos
 */
public class ParcBombersDAO {
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT CodParc, Adreca, Categoria FROM parc_bombers";
    private static final String SQL_INSERT = "INSERT INTO parc_bombers (Adreca, Categoria) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE parc_bombers SET Adreca=?, Categoria=? WHERE CodParc=?";
    private static final String SQL_DELETE = "DELETE FROM parc_bombers WHERE CodParc = ?";

    public ParcBombersDAO(){}

    public ParcBombersDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    /*
     * El metodo lanzará la consulta select a la base de datos, devolverá un ArrayList de ParcBombers
     */
    public List<ParcBombers> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ParcBombers parcBombers = null;
        List<ParcBombers> parcsBombers = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional :Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int CodParc = rs.getInt("CodParc");
                String Adreca = rs.getString("Adreca");
                int Categoria = rs.getInt("Categoria");

                parcBombers = new ParcBombers(CodParc, Adreca, Categoria);
                parcsBombers.add(parcBombers);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
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
        return parcsBombers;
    }
    /*
     * El método realizará una consulta INSERT a la base de datos.
     * Se pasa por parámetro un objeto ParcBombers con el que se realizará la consulta
     */
    public int insert(ParcBombers parcBombers) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, parcBombers.getAdreca());
            stmt.setInt(2, parcBombers.getCategoria());
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
    /*
     * Se realiza la consulta UPDATE a la base de datos.
     * Se pasa por parámetro un objeto ParcBombers con el CodParcBombers correspondiente,
     * y poder identificar la fila en la que se encuentra en la base de datos
     */
    public int update(ParcBombers parcBombers) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, parcBombers.getAdreca());
            stmt.setInt(2, parcBombers.getCategoria());
            stmt.setInt(3, parcBombers.getCodParc());
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
    /*
     * El metodo realizará la consulta DELETE a la base de datos
     * Solo será necesario pasar el CodParcBombers por parámetro
     */
    public int delete(ParcBombers parcBombers) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, parcBombers.getCodParc());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
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


}