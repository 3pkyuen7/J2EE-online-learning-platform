/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import ict.bean.Module;
import ict.bean.UserInfo;
import ict.dbManager.dbManager;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ljp85
 */
public class UserDB {
    private String dburl;
    private String dbUser;
    private String dbPassword;
    dbManager dbm;

    public UserDB( String dburl, String dbUser, String dbPassword){
        this.dburl=dburl;
        this.dbUser=dbUser;
        this.dbPassword=dbPassword;
        dbm = new dbManager(dburl, dbUser, dbPassword);
    }
    
    public boolean isValidUser(String user, String pwd) {
        boolean isValid = false;
        String sql = "SELECT * FROM user WHERE userID=? and password=?";

        try {
            ResultSet rs = dbm.sendQueryPQS(sql, user, pwd);
            System.out.println(rs.toString());
            if (rs.next()) {
                isValid = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isValid;
    }
    
    public Connection getConnection() throws SQLException, IOException{
        System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
        return DriverManager.getConnection(dburl,dbUser,dbPassword);
    }
    
    public UserInfo checkUserRole(String user, String pwd) {
        
        Connection cnnct=null;
        PreparedStatement pStmnt=null;
        //String role="";
        UserInfo uf=null;
        try{
            cnnct=getConnection();
            String preQueryStatement="SELECT * FROM user WHERE userID=? and password=?";
            pStmnt=cnnct.prepareStatement(preQueryStatement);
            pStmnt.setString(1, user);
            pStmnt.setString(2, pwd);
            ResultSet rs=null;
            rs=pStmnt.executeQuery(); 
            if(rs.next()){
                uf=new UserInfo();
                uf.setUsername(rs.getString("userID")); 
                uf.setPassword(rs.getString("password")); 
                uf.setRole(rs.getString("role")); 
            }
           // role=rs.getString("role");
            pStmnt.close();
            cnnct.close();
        }catch(SQLException ex){
            while(ex!=null){
                ex.printStackTrace();
                ex=ex.getNextException();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return uf;

    }
    

    
    public boolean addUserInfo(String id, String user, String pwd) {
        String sql = "INSERT INTO USERINFO VALUES (?,?,?);";
        try {
            return dbm.sendUpdatePQS(sql, id, user, pwd) > 0;
        } catch(SQLException e){
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public boolean delUserInfo(String id) {
        String sql = "DELETE FROM USERINFO WHERE ID = ?";
        try {
            return dbm.sendUpdatePQS(sql, id) > 0;
        } catch(SQLException e) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public boolean delUByID(String id) {
        Connection connection = null;
        PreparedStatement pStatement = null;
        UserInfo cb = null;
        boolean isSuccess = false;
        try {
            connection = getConnection();
            String preQueryStatement = "delete from user where userID = ? ";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1,id);
            int row = pStatement.executeUpdate();
            if(row >= 1){
                isSuccess = true;
            }
            pStatement.close();
            connection.close();
        } catch (SQLException ex) {
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    public boolean delTByID(String id) {
        Connection connection = null;
        PreparedStatement pStatement = null;
        UserInfo cb = null;
        boolean isSuccess = false;
        try {
            connection = getConnection();
            String preQueryStatement = "delete from teacher where teacherID = ? ";
            pStatement = connection.prepareStatement(preQueryStatement);
            pStatement.setString(1,id);
            int row = pStatement.executeUpdate();
            if(row >= 1){
                isSuccess = true;
            }
            pStatement.close();
            connection.close();
        } catch (SQLException ex) {
            while(ex != null){
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return isSuccess;
    }
    
    /*public boolean editRecord( UserInfo cb) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess = false;
        try {
            cnnt = getConnection();
            String preQueryStatement = "UPDATE CUSTOMER SET NAME=?, TEL =?, AGE=? WHERE CUSTID=?";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setString(1, cb.getName());
            pStmnt.setString(2, cb.getTel());
            pStmnt.setInt(3, cb.getAge());
            pStmnt.setString(4, cb.getCustomerID());

            int rowCount = pStmnt.executeUpdate();
            if (rowCount >= 1) {
                isSuccess = true;
            }
            if (isSuccess == true) {
                out.println("CustID :"+cb.getCustomerID() + " is updated");
            }
            pStmnt.close();
            cnnt.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }*/
    
    public ArrayList<UserInfo> queryCust() {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        ArrayList<UserInfo> al = new ArrayList();
        UserInfo cb = null;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT * FROM USER";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                cb = new UserInfo();
                cb.setUserId(rs.getString((1)));
                cb.setRole(rs.getString((2)));
                cb.setPassword(rs.getString((3)));
                al.add(cb);
            }
            pStmnt.close();
            cnnt.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return al;
    }
    
    public ArrayList<UserInfo> queryStudent() {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        ArrayList<UserInfo> al = new ArrayList();
        UserInfo cb = null;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT S.*, U.Password FROM student S, user U WHERE S.userID = U.userID";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                cb = new UserInfo();
                cb.setUserId(rs.getString((4)));
                cb.setRoleId(rs.getString((1)));
                cb.setUsername(rs.getString((2)));
                cb.setGroupId(rs.getInt(3));
                cb.setPassword(rs.getString((5)));
                al.add(cb);
            }
            pStmnt.close();
            cnnt.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return al;
    }
    
    public UserInfo queryStudByID(String id) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        UserInfo cb = null;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT S.*, U.Password FROM student S, user U WHERE S.studID = U.userID and S.stuID = ?";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();

            if (rs.next()) {
                cb = new UserInfo();
                cb.setUserId(rs.getString((4)));
                cb.setRoleId(rs.getString((1)));
                cb.setUsername(rs.getString((2)));
                cb.setGroupId(rs.getInt((3)));
                cb.setPassword(rs.getString((5)));
            }
            pStmnt.close();
            cnnt.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return cb;
    }
    
    public ArrayList<UserInfo> queryTeacher() {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        ArrayList<UserInfo> al = new ArrayList();
        UserInfo cb = null;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT T.*, U.Password FROM teacher T, user U WHERE T.userID = U.userID";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                cb = new UserInfo();
                cb.setUserId(rs.getString((3)));
                cb.setRoleId(rs.getString((1)));
                cb.setUsername(rs.getString((2)));
                cb.setGroupId(0);
                cb.setPassword(rs.getString((4)));
                al.add(cb);
            }
            pStmnt.close();
            cnnt.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return al;
    }
    
    public ArrayList<Module> queryModule() {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        ArrayList<Module> al = new ArrayList();
        Module cb = null;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT * FROM Module";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                cb = new Module();
                cb.setModuleID(rs.getString((1)));
                cb.setTitle(rs.getString((2)));
                cb.setTeacherName(rs.getString((3)));
                al.add(cb);
            }
            pStmnt.close();
            cnnt.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return al;
    }
    
    public ArrayList<Module> queryModule(String id) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        ArrayList<Module> al = new ArrayList();
        Module cb = null;
        int group=getGroupID(id);
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT * FROM Module where groupid=?";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, group);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            while (rs.next()) {
                cb = new Module();
                cb.setModuleID(rs.getString((1)));
                cb.setTitle(rs.getString((2)));
                cb.setTeacherName(rs.getString((3)));
                al.add(cb);
            }
            pStmnt.close();
            cnnt.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return al;
    }
    
    public int getGroupID(String id) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        ArrayList<Module> al = new ArrayList();
        Module cb = null;
        int group=0;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT GroupiD FROM student where userID=?";
            
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
            if(rs.first())
                group=rs.getInt(1);

            
            pStmnt.close();
            cnnt.close();
        } catch (SQLException ex) {
            while (ex != null) {
                ex.printStackTrace();
                ex = ex.getNextException();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return group;
    }
    
    
}
