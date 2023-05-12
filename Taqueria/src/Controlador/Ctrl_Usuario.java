
package Controlador;

import Conexion.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;

public class Ctrl_Usuario {
    //metodo para iniciar sesion
    public boolean LoginTaqueria (Usuario objeto){
        boolean respuesta = false;
        
        Connection cn= Conexion.conectar();
        String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        Statement st;
        try{
            st = cn.createStatement();
             ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                respuesta=true;

            }
        }catch(SQLException e){
            System.out.println("Error al iniciar sesion" + e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion");
        }
        return respuesta; 
    }
}
