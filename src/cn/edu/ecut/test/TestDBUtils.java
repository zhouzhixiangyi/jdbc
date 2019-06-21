package cn.edu.ecut.test;

import cn.edu.ecut.JDBCTools.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.SQLException;

public class TestDBUtils {

    /**
     * 删除用户
     */
    @Test
    public void  testDeleteCustomerByID(){
        try {
            //创建核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "delete customers where  where id = ?";
            Object []params = {6};
            int rows = qr.update(sql , params);
            if(rows > 0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改用户
     */
    @Test
    public void  testUpdateCustomerByID(){
        try {
            //创建核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "update customers set username = ?  where id = ?";
            Object []params = {"hi" , 6};
            int rows = qr.update(sql , params);
            if(rows > 0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加用户
     */
    @Test
    public void  testAddCustomer(){
        try {
            //创建核心类QueryRunner
            QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
            String sql = "insert into customers(username , email) values(?,?)";
            Object []params = {"mei" , "mei@qq.com"};
            int rows = qr.update(sql , params);
            if(rows > 0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
