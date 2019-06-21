package cn.edu.ecut.test;

import cn.edu.ecut.JDBCTools.C3P0Utils;
import cn.edu.ecut.domain.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class TestDBUtils2 {

    /**
     * 查询用户的总个数
     */
    @Test
    public void testQueryCountCustomer(){
        try {
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "select count(*) from customers";
            long count = (long)qr.query(sql , new ScalarHandler());
            System.out.println(count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 通过用户id 查询用户
     */
    @Test
    public void testQueryCustomerByID(){
        try {
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "select id , username , email from customers where id = ?";
            Object [] params = {"6"};
            Customer c = qr.query(sql , new BeanHandler<>(Customer.class) , params);
            System.out.println(c.getUsername() + ":" + c.getEmail());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 查询所有
     */
    @Test
    public void testQueryAll(){
        try {
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "select id , username , email from customers";
            List<Customer> list =  qr.query(sql, new BeanListHandler<>(Customer.class));
            for (Customer c:
                 list) {
                System.out.println(c.getUsername() + ":" + c.getEmail());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询所有
     */
    @Test
    public void testQueryAll1(){
        try {
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "select id , username , email from customers";
            List<Map<String, Object>> list = qr.query(sql, new MapListHandler());
            for (Map<String , Object> map:
                 list) {
                System.out.println(map);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 查询所有
     */
    @Test
    public void testQueryAll2(){
        try {
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "select id , username , email from customers";
            List<Object> username = qr.query(sql, new ColumnListHandler("username"));
            for (Object o:
                 username) {
                System.out.println(o);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
