/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.db;

import ict.bean.QuestionBean;
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
public class QuestionDB {
    private String dburl;
    private String dbUser;
    private String dbPassword;
    dbManager dbm;

    public QuestionDB( String dburl, String dbUser, String dbPassword){
        this.dburl=dburl;
        this.dbUser=dbUser;
        this.dbPassword=dbPassword;
        dbm = new dbManager(dburl, dbUser, dbPassword);
    }
    
    public Connection getConnection() throws SQLException, IOException{
        System.setProperty("jdbc.drivers","com.mysql.jdbc.Driver");
        return DriverManager.getConnection(dburl,dbUser,dbPassword);
    }
    
    public ArrayList<QuestionBean> getQuestionDB(int id) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        ArrayList<QuestionBean> al = new ArrayList();
        QuestionBean cb = null;
        try {
            cnnt = getConnection();
            String preQueryStatement ="SELECT Q.* FROM question Q, quiz_question QQ where Q.QuesID = QQ.questionID AND QQ.QuizID='"+id+"' ;";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();

            while (rs.next()) {
                cb = new QuestionBean();
                cb.setQuesID(rs.getInt((1)));
                cb.setContent(rs.getString((2)));
                cb.setAnswer(rs.getString((3)));
                cb.setOptionD(rs.getString((4)));
                cb.setOptionC(rs.getString((5)));
                cb.setOptionB(rs.getString((6)));
                cb.setOptionA(rs.getString((7)));
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
    
    public ArrayList<QuestionBean> queryUnAssignQ(int id) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
         ArrayList<QuestionBean> al = new ArrayList();
        QuestionBean cb = null;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT Q.* FROM question Q WHERE QuesID NOT IN(SELECT Q.QuesID FROM question Q, quiz_question QQ where Q.QuesID = QQ.questionID AND QQ.quizID=? )";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, id);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
          
             while (rs.next()) {
                cb = new QuestionBean();
                cb.setQuesID(rs.getInt((1)));
                cb.setContent(rs.getString((2)));
                cb.setAnswer(rs.getString((3)));
                cb.setOptionD(rs.getString((4)));
                cb.setOptionC(rs.getString((5)));
                cb.setOptionB(rs.getString((6)));
                cb.setOptionA(rs.getString((7)));
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
    
    public ArrayList<QuestionBean> queryQuizAssignQ(int id) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
         ArrayList<QuestionBean> al = new ArrayList();
        QuestionBean cb = null;
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT * FROM question where quizID=?";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, id);
            
            ResultSet rs = null;
            rs = pStmnt.executeQuery();
          
             while (rs.next()) {
                cb = new QuestionBean();
                cb.setQuesID(rs.getInt((1)));
                cb.setContent(rs.getString((2)));
                cb.setAnswer(rs.getString((3)));
                cb.setOptionD(rs.getString((4)));
                cb.setOptionC(rs.getString((5)));
                cb.setOptionB(rs.getString((6)));
                cb.setOptionA(rs.getString((7)));
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
    
    public ArrayList<quiz> queryQuizDB() {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        quiz cb = null;
        ArrayList<quiz> al=new ArrayList();
        try {
            cnnt = getConnection();
            String preQueryStatement = "SELECT * FROM quiz ;";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            ResultSet rs = null;
            rs = pStmnt.executeQuery();

            while (rs.next()) {
                cb = new quiz();
                cb.setQuizID(rs.getInt((1)));
                cb.setStartTime(rs.getString((2)));
                cb.setEndTime(rs.getString((3)));
                cb.setAttemptAmount(rs.getInt((4)));
                cb.setModuleId(rs.getString((5)));
                cb.setRequestTime(rs.getInt((6)));
                cb.setQuizName(rs.getString((7)));
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
            String preQueryStatement = "SELECT * FROM quiz where QuizID=?;";
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
    
    public boolean InsertQuesToQuiz(int quizNo, int []quesID) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        int rowCount=0;
        try {
            cnnt = getConnection();
            for(int i=0; i<quesID.length;i++){
                String preQueryStatement = "insert into quiz_question values (?,?)";
                pStmnt = cnnt.prepareStatement(preQueryStatement);
                pStmnt.setInt(1, quesID[i]);
                pStmnt.setInt(2, quizNo);
                int num=pStmnt.executeUpdate();
                
                if(num>=1)
                    rowCount++;
            }
            if(rowCount==quesID.length)
                isSuccess=true;
                
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
    
    public boolean removeQuiz(int qID) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        try {
            if(removeQuizQuestion(qID))
                cnnt = getConnection();
                String preQueryStatement = "DELETE FROM `quiz` where quizID=?";
                pStmnt = cnnt.prepareStatement(preQueryStatement);
                pStmnt.setInt(1, qID);

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
    
    public boolean removeQuizQuestion(int qID) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        try {
            cnnt = getConnection();
            String preQueryStatement = "DELETE FROM `quiz_question` where quizID=?";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, qID);

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
    
    
    public boolean removeQuizQuestion(int qID,int quesID) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        try {
            cnnt = getConnection();
            String preQueryStatement = "DELETE FROM `quiz_question` where quizID=? AND questionID=?";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, qID);
            pStmnt.setInt(2, quesID);

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

    //String name,String st, String eT,String qN, String rT
    public boolean createQuiz(String name,int qN, int rT) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        try {
            cnnt = getConnection();
            //INSERT INTO `quiz` (`QuizID`, `StartTime`, `Endtime`, `AttemptAmount`, `ModuleId`, `requestTime`, `quizName`) VALUES (NULL, NULL, NULL, '2', NULL, '2', 'z');
            String preQueryStatement = "insert into quiz (QuizID,StartTime,Endtime,AttemptAmount,ModuleId, requestTime,quizName) values (NULL, NULL, NULL,?,Null,?,?)";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, rT);
            pStmnt.setInt(2, qN);
            pStmnt.setString(3, name);
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
    
    public boolean createQuestion(String name,String oA,String oB,String oC,String oD,String Answer) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        try {
            cnnt = getConnection();
  
            String preQueryStatement = "insert into question (Content,OptionA,OptionB,OptionC,OptionD, Answer) values (?,?,?,?,?,?)";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setString(1, name);
            pStmnt.setString(2, oA);
            pStmnt.setString(3, oB);
            pStmnt.setString(4, oC);
            pStmnt.setString(5, oD);
            pStmnt.setString(6, Answer);
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
    public boolean removeQuestion(int quesID) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        try {
            if(removeQuestionQuiz(quesID)){
                cnnt = getConnection();
                String preQueryStatement = "DELETE FROM `question` where QuesID=?";
                pStmnt = cnnt.prepareStatement(preQueryStatement);
                pStmnt.setInt(1, quesID);

                int rowCount=pStmnt.executeUpdate();

                if(rowCount>=1){
                    isSuccess=true;
                }
                pStmnt.close();
                cnnt.close();
            }
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
    
    public boolean removeQuestionQuiz(int quesID) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        try {
            if(checkQuestionQuiz(quesID)){
                cnnt = getConnection();
                String preQueryStatement = "DELETE FROM `quiz_question` where questionID=?";
                pStmnt = cnnt.prepareStatement(preQueryStatement);
                pStmnt.setInt(1, quesID);

                int rowCount=pStmnt.executeUpdate();

                if(rowCount>=1){
                    isSuccess=true;
                }
                pStmnt.close();
                cnnt.close();
            }
            else
                return true;
        
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
    
    public boolean checkQuestionQuiz(int quesID) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        try {
            cnnt = getConnection();
            String preQueryStatement = "Select * FROM `quiz_question` where questionID=?";
            pStmnt = cnnt.prepareStatement(preQueryStatement);
            pStmnt.setInt(1, quesID);

            ResultSet rs=pStmnt.executeQuery();

            if(rs.first()){
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
    
    public boolean AddQuizFromSection(int sID,int qID) {
        Connection cnnt = null;
        PreparedStatement pStmnt = null;
        boolean isSuccess=false;
        try {

                cnnt = getConnection();
                String preQueryStatement = "UPDATE  `section` SET  QuizID=? where secID=?";
                pStmnt = cnnt.prepareStatement(preQueryStatement);
                pStmnt.setInt(1, qID);
                pStmnt.setInt(2, sID);

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
