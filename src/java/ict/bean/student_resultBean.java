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
public class student_resultBean {
    private int ResultID;
    private int Result;
    private int AttemptTime;
    private int QuizId;
    private int StuID;

    public student_resultBean() {
    }

    public int getResultID() {
        return ResultID;
    }

    public void setResultID(int ResultID) {
        this.ResultID = ResultID;
    }

    public int getResult() {
        return Result;
    }

    public void setResult(int Result) {
        this.Result = Result;
    }

    public int getAttemptTime() {
        return AttemptTime;
    }

    public void setAttemptTime(int AttemptTime) {
        this.AttemptTime = AttemptTime;
    }

    public int getQuizId() {
        return QuizId;
    }

    public void setQuizId(int QuizId) {
        this.QuizId = QuizId;
    }

    public int getStuID() {
        return StuID;
    }

    public void setStuID(int StuID) {
        this.StuID = StuID;
    }
    
    
}
