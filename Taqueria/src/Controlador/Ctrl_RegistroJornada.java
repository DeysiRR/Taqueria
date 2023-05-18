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

/**
 *
 * @author 1
 */
public class Ctrl_RegistroJornada {

    //metodo para registar entrada
    public boolean entrada(RegistroJornada objeto) {
        boolean respuesta = false;
        Connection con = Conexion.conectar();

        try {
            String consulta = "INSERT INTO registro_jornada (id_empleado, fecha, hora_entrada) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(consulta);

            stmt.setInt(1, objeto.getId_empleado());
            stmt.setDate(2, java.sql.Date.valueOf(objeto.getFecha()));
            stmt.setTime(3, objeto.getHora_entrada());

            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                respuesta = true;
                System.out.println("Entrada registrada correctamente");
            } else {
                System.out.println("Error al registrar la entrada");
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
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
                System.out.println("Salida registrada correctamente");
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
