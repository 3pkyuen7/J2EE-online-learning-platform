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
public class Section {
    private int secID;
    private String Title;
    private String content;
    private String ModuleId;
    private int QuizID;
    
    public Section(){ 
    }
    
    public void setSecID(int secID){
        this.secID=secID;
    }
    
    public void setTitle(String Title){
        this.Title=Title;
    }
    
    public void setContent(String content){
        this.content=content;
    }
    
    public void setModuleId(String ModuleId){
        this.ModuleId=ModuleId;
    }
    
    public void setQuizID(int QuizID){
        this.QuizID=QuizID;
    }
    

    
    public int getSecID(){
        return this.secID;
    }
    
    public String getTitle(){
        return this.Title;
    }
    
    public String getContent(){
        return this.content;
    }
    
    public String getModuleId(){
        return this.ModuleId;
    }
    
    public int getQuizID(){
        return this.QuizID;
    }
    

}
