package datos;

import conexion.Conexion;
import dominio.Nomina;
import java.util.*;
import java.sql.*;

import static conexion.Conexion.close;

public class NominaDAO {
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT CodBomber, Categoria_nomina, FechaIni, FechaFin, Liquid_final FROM nomina_bombero";
    private static final String SQL_INSERT = "INSERT INTO nomina_bombero (CodBomber, Categoria_nomina, FechaIni, FechaFin, Liquid_final) VALUES (?,?,?,?, (Select (Sou_base+Complements)-Percentatge_retencio/100 FROM categoria WHERE categoria.Categoria_nomina=?))";
    private static final String SQL_UPDATE = "UPDATE nomina_bombero SET Categoria_nomina=?, FechaIni=?, FechaFin=?, Liquid_final=? WHERE CodBomber=?";

    public NominaDAO() {
    }

    ;

    public NominaDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Nomina> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Nomina nomina = null;
        List<Nomina> nominas = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codBomber = rs.getInt("CodBomber");
                int categoriaNomina = rs.getInt("Categoria_nomina");
                String fechaini = rs.getString("FechaIni");
                String fechafin = rs.getString("FechaFin");
                double liquidFinal = rs.getDouble("Liquid_final");

                nomina = new Nomina(codBomber, categoriaNomina, fechaini, fechafin, liquidFinal);
                nominas.add(nomina);
            }
        } finally {
            try {
                close(rs);
                close(stmt);
                if (this.conexionTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return nominas;
    }

    public int insert(Nomina nomina) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try{
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, nomina.getCodBomber());
            stmt.setInt(2, nomina.getCategoriaNomina());
            stmt.setString(3, nomina.getFechaini());
            stmt.setString(4, nomina.getFechafin());
            stmt.setInt(5, nomina.getCategoriaNomina());
            result = stmt.executeUpdate();
        }finally{
            try{
                close(stmt);
                if (this.conexionTransaccional == null){
                    Conexion.close(conn);
                }
            }catch (SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return result;
    }

    public int update(Nomina nomina) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int result = 0;
        try{
            conn = this.conexionTransaccional != null ?
                    this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, nomina.getCategoriaNomina());
            stmt.setString(2, nomina.getFechaini());
            stmt.setString(3, nomina.getFechafin());
            stmt.setDouble(4, nomina.getLiquidFinal());
            stmt.setInt(5, nomina.getCodBomber());
            result = stmt.executeUpdate();
        }finally {
            try{
                close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion.close(conn);
                }
            }catch(SQLException e){
                e.printStackTrace(System.out);
            }
        }
        return result;
    }


}