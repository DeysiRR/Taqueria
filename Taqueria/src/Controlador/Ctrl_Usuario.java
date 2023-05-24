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

        Connection cn = Conexion.conectar();
        String sql = "SELECT usuario, password FROM empleados WHERE BINARY usuario = ? AND BINARY password = ?";
        PreparedStatement stmt;
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
}

