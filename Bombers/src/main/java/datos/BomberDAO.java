package datos;

import java.util.*;

import conexion.Conexion;
import dominio.Bomber;
import java.sql.*;

import static conexion.Conexion.close;
/*
* Se definen las sententencias de acceso a la base de datos
*/
public class BomberDAO {
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT CodBomber, Nom, Adreca, CodParc, CodCarrec, Categoria_nomina  CodEquip FROM bomber";
    private static final String SQL_INSERT = "INSERT INTO bomber (Nom, Adreca, CodParc, CodCarrec, CodEquip, Categoria_nomina) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE bomber SET Nom=?, Adreca=?, CodParc=?, CodCarrec=?, CodEquip=?, Categoria_nomina WHERE CodBomber=?";
    private static final String SQL_DELETE = "DELETE FROM bomber WHERE CodBomber=?";
    public BomberDAO(){ };

    public BomberDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    /*
    * El metodo lanzará la consulta select a la base de datos, devolverá un ArrayList de Bomberos
    */
    public List<Bomber> seleccionar() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bomber bomber = null;
        List<Bomber> bombers = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ?
            this.conexionTransaccional :Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int CodBomber = rs.getInt("CodBomber");
                String Nom = rs.getString("Nom");
                String Adreca = rs.getString("Adreca");
                int CodParc = rs.getInt("CodParc");
                int CodCarrec = rs.getInt("CodCarrec");
                int CodEquip = rs.getInt("CodEquip");
                int Categoria_nomina = rs.getInt("Categoria_nomina");

                bomber = new Bomber(CodBomber, Nom, Adreca, CodParc, CodCarrec, CodEquip, Categoria_nomina);
                bombers.add(bomber);
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
        return bombers;
        }
/*
* El método realizará una consulta INSERT a la base de datos.
* Se pasa por parámetro un objeto Bomber con el que se realizará la consulta
*/
    public int insert(Bomber bomber) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, bomber.getNom());
            stmt.setString(2, bomber.getAdreca());
            stmt.setInt(3, bomber.getCodParc());
            stmt.setInt(4, bomber.getCodCarrec());
            stmt.setInt(5, bomber.getCodEquip());
            stmt.setInt(6, bomber.getCatnomina());
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
* Se pasa por parámetro un objeto Bomber con el CodBomber correspondiente,
* y poder identificar la fila en la que se encuentra en la base de datos
*/
    public int update(Bomber bomber) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, bomber.getNom());
            stmt.setString(2, bomber.getAdreca());
            stmt.setInt(3, bomber.getCodParc());
            stmt.setInt(4, bomber.getCodCarrec());
            stmt.setInt(5, bomber.getCodEquip());
            stmt.setInt(6, bomber.getCodBomber());
            stmt.setInt(7, bomber.getCatnomina());
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
* Solo será necesario pasar el CocBomber por parámetro
*/
    public int delete(Bomber bomber) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try {
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, bomber.getCodBomber());
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
}
