
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.User;

public class UserDAO
{
    public static boolean validateUser(User user)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement("Select * from users where userid=? and password=? and usertype=?");
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
        ResultSet rs= ps.executeQuery();
        return rs.next();
    }
    public static boolean addUser(User user) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into users values(?,?,?)");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        ResultSet rs = ps.executeQuery();
        return rs.next();
    }
    public static boolean deleteUser(User user) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from users where userid=? and password=? and usertype=?");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        int ans = ps.executeUpdate();
        return ans == 1;
    }
    public static boolean changePassword(User user, String newpassword) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update users set password=? where userid=? and password=? and usertype=?");
        ps.setString(1, newpassword);
        ps.setString(2, user.getUserId());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getUserType());
        int ans = ps.executeUpdate();
        return ans == 1;
    }
}
