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
public class QuestionBean {
    private int QuesID;
    private String Content;
    private String answer;
    private int QuizID;
    private String OptionD;
    private String OptionC;
    private String OptionB;
    private String OptionA;

    public String getOptionD() {
        return OptionD;
    }

    public void setOptionD(String OptionD) {
        this.OptionD = OptionD;
    }

    public String getOptionC() {
        return OptionC;
    }

    public void setOptionC(String OptionC) {
        this.OptionC = OptionC;
    }

    public String getOptionB() {
        return OptionB;
    }

    public void setOptionB(String OptionB) {
        this.OptionB = OptionB;
    }

    public String getOptionA() {
        return OptionA;
    }

    public void setOptionA(String OptionA) {
        this.OptionA = OptionA;
    }

    public QuestionBean() {
    }

    public int getQuesID() {
        return QuesID;
    }

    public void setQuesID(int QuesID) {
        this.QuesID = QuesID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getQuizID() {
        return QuizID;
    }

    public void setQuizID(int QuizID) {
        this.QuizID = QuizID;
    }
}
