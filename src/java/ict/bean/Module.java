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
public class Module {
    private String moduleID;
    private String title;
    private String teacherName;
    
    public Module(){ 
    }
    public void setModuleID(String moduleID){
        this.moduleID=moduleID;
    }
    
    public void setTitle(String title){
        this.title=title;
    }
    
    public void setTeacherName(String teacherName){
        this.teacherName=teacherName;
    }
    
    public String getModuleID(){
        return this.moduleID;
    };
    
    public String getTitle(){
        return this.title;
    };
    
    public String getTeacherName(){
        return this.teacherName;
    };
}
