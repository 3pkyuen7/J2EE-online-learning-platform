/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import ict.bean.Module;
import ict.bean.QuestionBean;
import ict.bean.Section;
import ict.bean.quiz;
import ict.dbManager.dbManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author ljp85
 */
public class SectionDB {
    private String dburl;
    private String dbUser;
    private String dbPassword;
    dbManager dbm;

    public SectionDB( String dburl, String dbUser, String dbPassword){
        this.dburl=dburl;
        this.dbUser=dbUser;
        this.dbPassword=dbPassword;
        dbm = new dbManager(dburl, dbUser, dbPassword);
    }
    
    public Connection getConnection() throws SQLException, IOException{
        System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
        return DriverManager.getConnection(dburl,dbUser,dbPassword);
    }
    
    public ArrayList<Section> querySectionByID(String id) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        ArrayList<Section> al = new ArrayList();
        Section cb = null;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT * FROM section where ModuleId = ?";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setString(1, id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();

            while (rs.next()) {
                cb = new Section();
                cb.setSecID(rs.getInt((1)));
                cb.setTitle(rs.getString((2)));
                cb.setModuleId(rs.getString((3)));
                cb.setContent(rs.getString((4)));
                cb.setQuizID(rs.getInt((5)));
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
    
    public ArrayList<Section> querySectionByID() {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        ArrayList<Section> al = new ArrayList();
        Section cb = null;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT * FROM section ;";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();

            while (rs.next()) {
                cb = new Section();
                cb.setSecID(rs.getInt((1)));
                cb.setTitle(rs.getString((2)));
                cb.setContent(rs.getString((3)));
                cb.setModuleId(rs.getString((4)));
                cb.setQuizID(rs.getInt((5)));
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
    
    public quiz getQuizDB(int id) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        quiz cb = null;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT * FROM quiz where QuizID=? ;";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();

            if (rs.next()) {
                cb = new quiz();
                cb.setQuizID(rs.getInt((1)));
                cb.setStartTime(rs.getString((2)));
                cb.setEndTime(rs.getString((3)));
                cb.setAttemptAmount(rs.getInt((4)));
                cb.setModuleId(rs.getString((5)));
                cb.setRequestTime(rs.getInt((6)));
                cb.setQuizName(rs.getString((7)));
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
    
    
    
    public boolean quizResult(int result, int quizID, String stuID) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        try {
            cnnt = getConnection();
            String preQueryStatement = "insert into student_result  (Result, QuizId, StudentstuID) values (?,?,?)";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, result);
            pStmnt.setInt(2, quizID);
            pStmnt.setString(3, stuID);
            int rowCount=pStmnt.executeUpdate();

            if(rowCount>=1){
                isSuccess=true;
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
        return isSuccess;
    }
    
   public ArrayList<Module> searchModule(String keyword,String searchBy) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        ArrayList<Module> al = new ArrayList();
        Module cb = null;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT * FROM `module` WHERE `"+searchBy+"` LIKE '%"+keyword+"%'";
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
   
    
   public boolean checkDoneQuiz(int qId, String sId) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean checked=false;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT count(*) FROM student_result WHERE QuizId=? and StudentstuID=? ";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, qId);
            pStmnt.setString(2, sId);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
          
            if(rs.next()){
                if(rs.getInt(1)!=0)
                 checked = true;
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
        return checked;
    }
   
   public int getMark(int qId, String sId) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        int mark=0;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT Result FROM student_result WHERE QuizId=? and StudentstuID=? ";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, qId);
            pStmnt.setString(2, sId);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
          
            if(rs.next()){
                mark=(rs.getInt(1));
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
        return mark;
    }
   
   public ArrayList<QuestionBean> queryUnAssignQ() {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
         ArrayList<QuestionBean> al = new ArrayList();
        QuestionBean cb = null;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT * FROM question WHERE QuizId IS NULL";
            pStmnt = cnnt.prepareStatement(preQueryStatement);

            ResultSet rs = null;
            rs = pStmnt.executeQuery();
          
             while (rs.next()) {
                cb = new QuestionBean();
                cb.setQuesID(rs.getInt((1)));
                cb.setContent(rs.getString((2)));
                cb.setAnswer(rs.getString((3)));
                cb.setQuizID(rs.getInt((4)));
                cb.setOptionD(rs.getString((5)));
                cb.setOptionC(rs.getString((6)));
                cb.setOptionB(rs.getString((7)));
                cb.setOptionA(rs.getString((8)));
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
   
   public boolean createSection(String mID,String title,String content) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        try {
            cnnt = getConnection();
  
            String preQueryStatement = "insert into section (`ModuleId`,`Title`,`content`) values (?,?,?)";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setString(1, mID);
            pStmnt.setString(2, title);
            pStmnt.setString(3, content);
;
            int rowCount=pStmnt.executeUpdate();

            if(rowCount>=1){
                isSuccess=true;
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
        return isSuccess;
    }
    
   public boolean removeSection(int sID) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        try {

                cnnt = getConnection();
                String preQueryStatement = "DELETE FROM `section` where secID=?";
                pStmnt = cnnt.prepareStatement(preQueryStatement);
                pStmnt.setInt(1, sID);

                int rowCount=pStmnt.executeUpdate();

                if(rowCount>=1){
                    isSuccess=true;
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
        return isSuccess;
    }
    

    public boolean removeQuizFromSection(int sID) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        try {

                cnnt = getConnection();
                String preQueryStatement = "UPDATE  `section` SET  QuizID=null where secID=?";
                pStmnt = cnnt.prepareStatement(preQueryStatement);
                pStmnt.setInt(1, sID);

                int rowCount=pStmnt.executeUpdate();

                if(rowCount>=1){
                    isSuccess=true;
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
        return isSuccess;
    }
}
