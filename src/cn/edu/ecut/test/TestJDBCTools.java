package cn.edu.ecut.test;

import cn.edu.ecut.JDBCTools.JDBCTools;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBCTools {
    @Test
    public void testByID(){
        Connection conn = null;
        PreparedStatement ps = null ;
        ResultSet rs = null ;
        try {
            conn = JDBCTools.getConnection();
            String sql = "SELECT  username , email FROM customers WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,1);
            rs = ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCTools.releaseDB(conn , ps , rs);
        }
    }
}
