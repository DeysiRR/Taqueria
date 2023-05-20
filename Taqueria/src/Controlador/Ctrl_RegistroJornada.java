/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import Modelo.RegistroJornada;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 1
 */
public class Ctrl_RegistroJornada {

    public boolean entrada(RegistroJornada objeto) {
        boolean respuesta = false;
        Connection con = Conexion.conectar();

        try {
            // Verificar si el id_empleado existe
            String consultaVerificacion = "SELECT COUNT(*) FROM empleados WHERE id_empleado = ?";
            PreparedStatement stmtVerificacion = con.prepareStatement(consultaVerificacion);
            stmtVerificacion.setInt(1, objeto.getId_empleado());
            ResultSet rs = stmtVerificacion.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            rs.close();
            stmtVerificacion.close();

            if (count == 0) {
                JOptionPane.showMessageDialog(null, "El id_empleado no existe");
                return false;
            }

            // Verificar si ya existe un registro de entrada para el empleado en la fecha actual
            String consultaExistencia = "SELECT COUNT(*) FROM registro_jornada WHERE id_empleado = ? AND fecha = ?";
            PreparedStatement stmtExistencia = con.prepareStatement(consultaExistencia);
            stmtExistencia.setInt(1, objeto.getId_empleado());
            stmtExistencia.setDate(2, java.sql.Date.valueOf(objeto.getFecha()));
            ResultSet rsExistencia = stmtExistencia.executeQuery();
            rsExistencia.next();
            int countExistencia = rsExistencia.getInt(1);
            rsExistencia.close();
            stmtExistencia.close();

            if (countExistencia > 0) {
                JOptionPane.showMessageDialog(null, "Ya se ha registrado una entrada para este empleado en la fecha actual");
                return false;
            }

            // Insertar el registro de entrada
            String consulta = "INSERT INTO registro_jornada (id_empleado, fecha, hora_entrada) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(consulta);
            stmt.setInt(1, objeto.getId_empleado());
            stmt.setDate(2, java.sql.Date.valueOf(objeto.getFecha()));
            stmt.setTime(3, objeto.getHora_entrada());

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                respuesta = true;
                System.out.println("Entrada no registrada ");
            } else {
                System.out.println("Error al registrar la entrada");
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }

        return respuesta;
    }

    //metodo para registrar salida
    public boolean salida(RegistroJornada objeto) {
        boolean respuesta = false;
        Connection con = Conexion.conectar();

        try {
            String consulta = "UPDATE registro_jornada SET hora_salida = ? WHERE id_registro = ?";
            PreparedStatement stmt = con.prepareStatement(consulta);

            stmt.setTime(1, objeto.getHora_salida());
            stmt.setInt(2, objeto.getId_registro());

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                respuesta = true;
                System.out.println("salida no registrada ");
            } else {
                System.out.println("Error al registrar la salida");
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }

        return respuesta;
    }

}
