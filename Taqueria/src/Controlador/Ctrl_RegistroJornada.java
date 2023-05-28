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

    public boolean entrada(RegistroJornada objeto) throws SQLException {
        boolean respuesta = false;
        Connection con = Conexion.conectar();
        
        // Verificar si el id_empleado existe
        String consultaVerificacion = "SELECT COUNT(*) FROM empleados WHERE usuario = ?";
        int count = 0;
        try (PreparedStatement stmtVerificacion = con.prepareStatement(consultaVerificacion)) {
            stmtVerificacion.setString(1, objeto.getUsuario());
            ResultSet rs = stmtVerificacion.executeQuery();
            rs.next();
            count = rs.getInt(1);
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
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
        
        
        String consulta = "INSERT INTO registro_jornada (id_empleado, fecha, hora_entrada) VALUES (?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(consulta);
        System.out.println(objeto.getId_empleado());
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
        return respuesta;
    }

    public boolean salida(RegistroJornada objeto) {
        boolean respuesta = false;
        Connection con = Conexion.conectar();

        try {
            // Verificar si ya se registró la salida para el registro de jornada
            String consultaVerificacion = "SELECT hora_salida FROM registro_jornada WHERE id_registro = ?";
            PreparedStatement stmtVerificacion = con.prepareStatement(consultaVerificacion);
            stmtVerificacion.setInt(1, objeto.getId_registro());
            ResultSet rs = stmtVerificacion.executeQuery();

            if (rs.next() && rs.getTime("hora_salida") != null) {
                // Si ya existe un valor en la columna hora_salida, significa que la salida ya ha sido registrada
                JOptionPane.showMessageDialog(null, "La salida ya ha sido registrada anteriormente");
                rs.close();
                stmtVerificacion.close();
                return false;
            }

            rs.close();
            stmtVerificacion.close();

            // Actualizar el registro de jornada con la hora de salida
            String consulta = "UPDATE registro_jornada SET hora_salida = ? WHERE id_registro = ?";
            PreparedStatement stmt = con.prepareStatement(consulta);

            stmt.setTime(1, objeto.getHora_salida());
            stmt.setInt(2, objeto.getId_registro());

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(null, "Error al registrar la salida");
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }

        return respuesta;
    }

    public int getIDEmpleado(RegistroJornada empleado){
        int id = 0;
        Connection con = Conexion.conectar();
        String sql = "SELECT id_empleado FROM empleados WHERE usuario = '" + empleado.getUsuario() + "';";
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String resultado = rs.getString(1);
                id = Integer.parseInt(resultado);
            }
        }catch(SQLException e){
            e.getStackTrace();
        }
        return id;
    }
    
}
