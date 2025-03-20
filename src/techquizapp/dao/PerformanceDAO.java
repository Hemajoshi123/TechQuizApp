
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.Performance;
import techquizapp.pojo.StudentScore;

public class PerformanceDAO {
    public static void addPerformance(Performance performance) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into performance values(?,?,?,?,?,?,?)");
        ps.setString(1, performance.getUserId());
        ps.setString(2, performance.getExamId());
        ps.setInt(3, performance.getRight());
        ps.setInt(4, performance.getWrong());
        ps.setInt(5,performance.getUnattempted());
        ps.setDouble(6,performance.getPer());
        ps.setString(7, performance.getLanguage());
        ps.executeUpdate();
    }
    public static ArrayList<Performance> getAllData() throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        Statement st= conn.createStatement();
        ArrayList <Performance> performanceList = new ArrayList<>();
        ResultSet rs = st.executeQuery("Select * from performance");
        while(rs.next())
        {
            String userid=rs.getString(1);
            String examid=rs.getString(2);
            int right=rs.getInt(3);
            int wrong=rs.getInt(4);
            int unattempted=rs.getInt(5);
            double per=rs.getDouble(6);
            String lang=rs.getString(7);
            Performance p = new Performance(examid,lang,userid,right,wrong,unattempted,per);
            performanceList.add(p);
        }
        return performanceList;
    }
    public static ArrayList <String> getAllStudentId() throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        Statement st= conn.createStatement();
        ArrayList <String> studentIdList = new ArrayList<>();
        ResultSet rs = st.executeQuery("Select distinct userid from performance");
        while(rs.next())
        {
            String id=rs.getString(1);
            studentIdList.add(id);
        }
        return studentIdList;
    }
    public static ArrayList <String> getAllExamId(String studentId) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement("Select examid from performance where userid=?");
        ArrayList <String> examIdList = new ArrayList<>();
        ps.setString(1,studentId);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            String id=rs.getString(1);
            examIdList.add(id);
        }
        return examIdList;
    }
    public static StudentScore getScore(String studentId, String examId) throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps= conn.prepareStatement("Select language,per from performance where userid=? and examid=? ");
        ps.setString(1,studentId);
        ps.setString(2,examId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        StudentScore obj = new StudentScore();
        obj.setLanguage(rs.getString(1));
        obj.setPer(rs.getDouble(2));
        return obj;
    }
}
