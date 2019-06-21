package cn.edu.ecut.test;

import cn.edu.ecut.JDBCTools.C3P0Utils;
import cn.edu.ecut.JDBCTools.JDBCTools;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestC3P0 {
    @Test
    public void testAddCustomer1() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = C3P0Utils.getConnection();
            String sql = "INSERT INTO customers(username, email) VALUES (? , ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "zhong2");
            ps.setString(2, "zh2@qq.com");
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("添加成功!");
            } else {
                System.out.println("添加失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(conn, ps, null);
        }
    }


    @Test
    public void testAddCustomer() {
        Connection conn = null;
        PreparedStatement ps = null;
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            conn = dataSource.getConnection();
            String sql = "INSERT INTO customers(username, email) VALUES (? , ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "zhong1");
            ps.setString(2, "zh1@qq.com");
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("添加成功!");
            } else {
                System.out.println("添加失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCTools.releaseDB(conn, ps, null);
        }
    }
}
