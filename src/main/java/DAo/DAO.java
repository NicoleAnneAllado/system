package DAo;

import Dbconnection.DB;
import SystemUI.HomepageModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAO {

    public static void save(HomepageModel hm) {
        String sql = "INSERT INTO item_inventory (item_name, stock, capital, retail) VALUES (?, ?, ?, ?)";

        try (Connection conn = DB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, hm.getItem_name());
            stmt.setInt(2, hm.getStock());
            stmt.setInt(3, hm.getCapital());
            stmt.setInt(4, hm.getRetail());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Product Added Successfully");

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
        }
    }

    public static List<HomepageModel> getAll() {
        List<HomepageModel> list = new ArrayList<>();
        String sql = "SELECT item_name, stock, capital, retail FROM item_inventory";

        try (Connection conn = DB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                HomepageModel hm = new HomepageModel();
                hm.setItem_name(rs.getString("item_name"));
                hm.setStock(rs.getInt("stock"));
                hm.setCapital(rs.getInt("capital"));
                hm.setRetail(rs.getInt("retail"));
                list.add(hm);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
        }
        return list;
    }
}