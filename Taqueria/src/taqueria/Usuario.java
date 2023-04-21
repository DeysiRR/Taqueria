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
    private char[] password;
    private String userType; //admin, cajero, empleado
    private boolean userLoggedIn;
    private boolean passwordLoggedIn;
    
    public Usuario(String usuario, char[] password, int userType){
        this.usuario = usuario;
        this.password = password;
        if(userType == 1){
            this.userType = "admin";
        }
        if(userType == 2){
            this.userType = "cajero";
        }
        if(userType == 3){
            this.userType = "empleado";
        }
        userLoggedIn = false;
        passwordLoggedIn = false;
    }
    
    public Usuario(){
        this.usuario = "";
        this.password = null;
        this.userType = "";
        userLoggedIn = false;
        passwordLoggedIn = false;
    };
    
    public String getUsuario(){
        return usuario;
    }
    
    public char[] getPassword(){
        return password;
    }
    
    public String getUserType(){
        return userType;
    }
    
    public boolean getUserLoggedIn(){
        return userLoggedIn;
    }
    
    public boolean getPasswordLoggedIn(){
        return passwordLoggedIn;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public void setPassword(char[] password){
        this.password = password;
    }
    
    public void setUserType(String s){
        this.userType = s;
    }
    
    public void setUserLoggedIn(boolean b){
        userLoggedIn = b;
    }
    
    public void setPasswordLoggedIn(boolean b){
        passwordLoggedIn = b;
    }
}
