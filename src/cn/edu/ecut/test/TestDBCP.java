package cn.edu.ecut.test;

import cn.edu.ecut.JDBCTools.DBCPUtils;
import cn.edu.ecut.JDBCTools.JDBCTools;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDBCP {
    @Test
    public void testUpdateByID(){
        Connection conn = null ;
        PreparedStatement ps = null ;

        try {
            conn = DBCPUtils.getConnection();
            String sql = "UPDATE customers SET email = ? WHERE id = ? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1 , "zh@qq.com");
            ps.setInt(2 , 3 );
            int i = ps.executeUpdate();
            if(i>0){
                System.out.println("修改成功！");

            }else {
                System.out.println("修改失败!");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCTools.releaseDB(conn , ps ,null );
        }
    }
}
