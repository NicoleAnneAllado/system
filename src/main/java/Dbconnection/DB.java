package Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DB {
        
     private static Connection conn;
     private static Connection createConnection(){
try {
    String url = "jdbc:mysql://localhost:3307/available_stock";
    Class.forName("com.mysql.jdbc.Driver"); // the driver of the database
    conn = DriverManager.getConnection(url, "root", "12345");
} catch (ClassNotFoundException | SQLException ex) {
    Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
    System.err.println(ex);
    JOptionPane.showMessageDialog(null, "Database Error!", "Error", JOptionPane.ERROR_MESSAGE);
    return null;
}
         return conn;
     }
 public static Connection getConnection() {
    try {
        if (conn == null || conn.isClosed()) {
            conn = createConnection();
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
    }
    return conn;
}
 }

