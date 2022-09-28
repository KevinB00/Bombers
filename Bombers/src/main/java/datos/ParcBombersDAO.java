package datos;

import java.util.*;

import conexion.Conexion;
import dominio.ParcBombers;
import java.sql.*;

import static conexion.Conexion.close;
public class ParcBombersDAO {
    private static final String SQL_SELECT = "SELECT CodParc, Adreca, Categoria FROM parc_bombers";
    private static final String SQL_INSERT = "INSERT INTO parc_bombers (Adreca, Categoria) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE parc_bombers Adreca=?, Categoria=? WHERE CodParc=?";
    private static final String SQL_DELETE = "DELETE FROM parc_bombers WHERE CodParc = ?";

    public List<ParcBombers> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ParcBombers parcBombers = null;
        List<ParcBombers> parcsBombers = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
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
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return parcsBombers;
    }

    public int insert(ParcBombers parcBombers) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, parcBombers.getAdreca());
            stmt.setInt(2, parcBombers.getCategoria());
            result = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
            try {
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return result;
    }

    public int update(ParcBombers parcBombers) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, parcBombers.getAdreca());
            stmt.setInt(2, parcBombers.getCategoria());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
            try {
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return result;
    }

    public int delete(ParcBombers parcBombers) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, parcBombers.getAdreca());
            stmt.setInt(2, parcBombers.getCategoria());
            result = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
            try {
                close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return result;
    }


}