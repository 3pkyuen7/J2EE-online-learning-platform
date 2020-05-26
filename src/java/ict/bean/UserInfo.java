/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;

import java.io.Serializable;

/**
 *
 * @author ljp85
 */
public class UserInfo implements Serializable {
    private String username;
    private String password;
    private String role;
    private String userId;
    private String roleId;
    private int groupId;
    
    public UserInfo(){ 
    }
    
    public void setUserId(String userId){
        this.userId=userId;
    }
    
    public void setRoleId(String roleId){
        this.roleId=roleId;
    }
    
    public void setGroupId(int groupId){
        this.groupId=groupId;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public void setRole(String role){
        this.role=role;
    }
    
    public String getUsername(){
        return this.username;
    };
    
    public String getUserId(){
        return this.userId;
    };
    
    public String getRoleId(){
        return this.roleId;
    };
    
    public int getGroupId(){
        return this.groupId;
    };
    
    public String getPassword(){
        return this.password;
    };
    
    public String getRole(){
        return this.role;
    };
    

    
}
