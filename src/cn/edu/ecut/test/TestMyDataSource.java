package cn.edu.ecut.test;

import cn.edu.ecut.datasource.MyDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMyDataSource {
    @Test
    public void testAddCustomer() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        MyDataSource myDataSource = new MyDataSource();
        try {
            conn = myDataSource.getConnection();
            String sql = "INSERT INTO customers(username, email) VALUES (? , ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "zhong");
            ps.setString(2, "zh@qq.com");
            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("添加成功!");
            } else {
                System.out.println("添加失败!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            myDataSource.backConnection(conn);
        }

    }
}
