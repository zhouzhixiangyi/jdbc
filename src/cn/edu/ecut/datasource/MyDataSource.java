package cn.edu.ecut.datasource;

import cn.edu.ecut.JDBCTools.JDBCTools;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {
    private static LinkedList<Connection> pool = new LinkedList<>();

    static {
        for (int i = 0; i < 5; i++) {
            Connection conn = JDBCTools.getConnection();
            pool.add(conn);
        }
    }

    public void backConnection(Connection conn) {
        pool.add(conn);
    }


    @Override
    public Connection getConnection() throws SQLException {
        if (pool.size() == 0) {
            for (int i = 0; i < 5; i++) {
                Connection conn = JDBCTools.getConnection();
                pool.add(conn);
            }
        }
        Connection conn = pool.remove(0);
        return conn;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
