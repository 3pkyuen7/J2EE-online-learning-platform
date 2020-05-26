/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

/**
 *
 * @author ljp85
 */
public class quiz {
    private int QuizID;
    private String StartTime;
    private String EndTime;
    private int AttemptAmount;
    private String ModuleId;
    private int requestTime;
    private String quizName;

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }
    
    public quiz(){ 
    }
    
    public void setQuizID(int QuizID){
        this.QuizID=QuizID;
    }
    
    public void setStartTime(String StartTime){
        this.StartTime=StartTime;
    }
    
    public void setEndTime(String EndTime){
        this.EndTime=EndTime;
    }
    
    public void setAttemptAmount(int AttemptAmount){
        this.AttemptAmount=AttemptAmount;
    }
    
    public void setModuleId(String ModuleId){
        this.ModuleId=ModuleId;
    }
    
    public void setRequestTime(int requestTime){
        this.requestTime=requestTime;
    }
    

    
    public int getQuizID(){
        return this.QuizID;
    };
    
    public String getStartTime(){
        return this.StartTime;
    };
    
    public String getEndTime(){
        return this.EndTime;
    };
    
    public int getAttemptAmount(){
        return this.AttemptAmount;
    };
    
    public String getModuleId(){
        return this.ModuleId;
    };
    
    public int getRequestTime(){
        return this.requestTime;
    };
}
