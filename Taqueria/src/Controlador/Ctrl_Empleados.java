/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class Ctrl_Empleados {
    private JComboBox comboBoxEmpleados;
    public Ctrl_Empleados(JComboBox comboBoxEmpleados){
        this.comboBoxEmpleados = comboBoxEmpleados;
    }

    public Ctrl_Empleados() {}
    
    public void getEmpleadosComboBox(){
        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        String sql = "select concat(nombre_empleado,' ', apellido_empleado) from empleados;"; 
        Statement st;
        ResultSet rs;
        try{
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                comboBoxEmpleados.addItem(rs.getString(1));
            }
        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
    }
    
    public void setComboBoxEmpleados(JComboBox comboBoxEmpleados){
        this.comboBoxEmpleados = comboBoxEmpleados;
    }
}
