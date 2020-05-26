/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.dbManager;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.CachedRowSet;
/**
 *
 * @author ljp85
 */
public class dbManager {
    public Connection getConnection() throws SQLException {

        try {
            System.setProperty("jdbc.drivers", "com.mysql.jdbc.Driver");
            return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (SQLException e) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e2) {
                Logger.getLogger(dbManager.class.getName()).log(Level.SEVERE, null, e2);
            }

        }

        return DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }
    String dbUrl;
    String dbUser;
    String dbPassword;

    public dbManager(String dbUrl, String dbUser, String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public boolean sendPQS(String sql, String... args) throws SQLException {
        return sendPreQueryStatement(sql, args);
    }

    public ResultSet sendQueryPQS(String sql, String... args) throws SQLException {
        return sendQueryPreQueryStatement(sql, args);
    }

    public int sendUpdatePQS(String sql, String... args) throws SQLException {
        return sendUpdatePreQueryStatement(sql, args);
    }

    public boolean sendPreQueryStatement(String sql, String... args) throws SQLException {
        boolean isSuccess;
        try (Connection conn = getConnection(); PreparedStatement ps = setPreparedStatement(conn, sql, args)) {
            isSuccess = ps.execute();
        }
        return isSuccess;
    }

    public ResultSet sendQueryPreQueryStatement(String sql, String... args) throws SQLException {
        CachedRowSet rowset;
        try (Connection conn = getConnection()) {
            PreparedStatement ps;
            ps = setPreparedStatement(conn, sql, args);
            ResultSet rs = ps.executeQuery();
            rowset = new CachedRowSetImpl();
            rowset.populate(rs);
            ps.close();
        }
        return rowset;
    }

    public int sendUpdatePreQueryStatement(String sql, String... args) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = setPreparedStatement(conn, sql, args);
        int rownum = ps.executeUpdate();
        ps.close();
        conn.close();
        return rownum;
    }

    private PreparedStatement setPreparedStatement(Connection conn, String sql, String... args) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setString(i + 1, args[i]);
        }
        return ps;
    }
}
