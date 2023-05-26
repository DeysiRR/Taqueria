package Controlador;

import Conexion.Conexion;
import Modelo.Usuario;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;



    public class Ctrl_Usuario {
    // Método para iniciar sesión
    public boolean LoginTaqueria(Usuario objeto) {
        boolean respuesta = false;

        Connection cn = Conexion.conectar;
        String sql = "SELECT usuario, password FROM empleados WHERE BINARY usuario = ? AND BINARY password = ?";
        PreparedStatement stmt;
        main
        try {
            stmt = (PreparedStatement) cn.prepareStatement(sql);
            stmt.setString(1, objeto.getUsuario());
            stmt.setString(2, objeto.getPassword());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al iniciar sesión: " + e);
            JOptionPane.showMessageDialog(null, "Error al iniciar sesión");
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e);
            }
        }
        return respuesta;
    }
    
    public boolean obtenerPuesto(Usuario objeto){
        boolean respuesta = false;

        Connection cn = Conexion.conectar();
        String sql = "select puesto_empleado from empleados inner join catalogo_puestos"
                + " on catalogo_puestos.id_puesto = empleados.id_puesto where usuario = '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'"; 
        Statement st;

        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                objeto.setPuestoEmpleado(rs.getString(1));
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el puesto del usuario." + e);
            JOptionPane.showMessageDialog(null, "Error al obtener el puesto del usuario.");
        }
        return respuesta;
    }
}

