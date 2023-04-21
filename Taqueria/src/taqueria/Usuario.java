/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taqueria;

/**
 *
 * @author diego
 */
public class Usuario {
    private String usuario;
    private String password;
    private boolean isAdmin;
    private String userType;
    
    public Usuario(){
        this.isAdmin = true;
        this.userType = "";
    }
    
    public String getUsuario(){
        return usuario;
    }
    
    public String getPassword(){
        return password;
    }
    
    public boolean getIsAdmin(){
        return isAdmin;
    }
    
    public String getUserType(){
        return userType;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setIsAdmin(boolean b){
        this.isAdmin = b;
    }
    
    public void setUserType(String s){
        this.userType = s;
    }
}
