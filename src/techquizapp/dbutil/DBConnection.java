package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
 
public class DBConnection
{
    private static Connection conn;
    static
    {
         try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//ROSHANPRO:1521/xe","onlineexam","student");
            JOptionPane.showMessageDialog(null,"Connected successfully to the DB!");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Cannot connect to the DB!");
            ex.printStackTrace();
            System.exit(1);
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
            conn.close();
            JOptionPane.showMessageDialog(null,"Disconnected with DB successfully!");
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error in closing DB connection!");
            ex.printStackTrace();
        }
    }
}
