package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //conexion local
    public static Connection conectar(){
        try{//falta verificar la contrasena de la bd
            Connection cn=DriverManager.getConnection("jdbc:mysql://localhost//Taqueria_La_Glorieta", "root","");
            return cn;
        }catch(SQLException e){
            System.out.println("Error en la conexion local " + e);
        }
        return null;
    }
}
