package pruebasnb.bombers;

import java.util.*;
import dominio.Bomber;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BomberDAO {

    private static final String SQL_SELECT = "SELECT CodBomber, Nom, Adreca, CodParc, CodCarrec, CodEquip";
    private static final String SQL_INSERT = "INSERT INTO CodBomber (CodBomber, Nom, Adreca, CodParc, CodCarrec, CodEquip) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE bomber SET CodBomber=?, Nom=?, Adreca=?, CodParc=?, CodCarrec=?, CodEquip=? WHERE CodBomber=?";
    private static final String SQL_DELETE = "DELETE FROM bomber WHERE CodBomber=?";

    public List<Bomber> seleccionar() throws SQLException {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bomber bomber = null;
        List<Bomber> bombers = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int CodBomber = rs.getInt("CodBomber");
                String Nom = rs.getString("Nom");
                String Adreca = rs.getString("Adreca");
                int CodParc = rs.getInt("CodParc");
                int CodCarrec = rs.getInt("CodCarrec");
                int CodEquip = rs.getInt("CodEquip");

                bomber = new Bomber(CodBomber, Nom, Adreca, CodParc, CodCarrec, CodEquip);
                bombers.add(bomber);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return bombers;
    }
}
