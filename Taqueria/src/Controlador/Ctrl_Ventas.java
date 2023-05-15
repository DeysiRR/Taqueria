/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.Empleado;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author diego
 */
public class Ctrl_Ventas {
    private java.sql.Date fechaActual;
    private JTextField precioUnitarioTextField;
    
    public Ctrl_Ventas(){
        precioUnitarioTextField = null;
        fechaActual = null;
    }
    
    public boolean guardar(Venta venta){
        boolean respuesta = false;
        
        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        int total_venta = getPrecio(venta.getItemID());
        total_venta *= venta.getCantidad();
        String sql = "insert into ventas(item_id, cantidad, total_venta, fecha) values(" + venta.getItemID() + "," + venta.getCantidad() + "," + total_venta + ",'" + getFechaActual() + "');";
        Statement st;
        try{
            st = cn.createStatement();
            st.executeUpdate(sql);
            respuesta = true;
            
        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
        return respuesta; 
    }
    
    public int getPrecio(int item_id){
        int precio = 0;
        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        String sql = "select precio_unit from menu_catalogo where item_id = " + item_id + ";";
        Statement st;
        ResultSet rs;
        try{
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String aux = rs.getString(1);
                precio = Integer.parseInt(aux);
            }
        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
        return precio;
    }
    
    public boolean getPrecioUnitario(String nombre){
        boolean respuesta = false;
        
        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        String sql = "select precio_unit from menu_catalogo where nombre = '" + nombre + "';";
        Statement st;
        ResultSet rs;
        try{
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                precioUnitarioTextField.setText(rs.getString(1));
            }
            respuesta = true;
        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
        return respuesta; 
    }
    
    public java.sql.Date getFechaActual(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
        String date_str = formatter.format(date);
        try {
            date = formatter.parse(date_str);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        java.sql.Date dateDB = new java.sql.Date(date.getTime());
        fechaActual = dateDB;
        
        System.out.print("Current date: "+date_str);
        return fechaActual;
    }
    
    public int getItemID(String nombre){
        int itemID = 0;
        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        String sql = "select item_id from menu_catalogo where nombre = '" + nombre + "';";
        Statement st;
        ResultSet rs;
        try{
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String aux = rs.getString(1);
                itemID = Integer.parseInt(aux);
            }
        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
        return itemID;
    }
    
    public int getIDEmpleado(Empleado empleado){
        int id_empleado = 0;
        Connection cn = Conexion.conectar();
        //String sql = "select usuario,password from usuarios where usuario= '"+ objeto.getUsuario() + "' and password = '"+ objeto.getPassword()+ "'";
        String sql = "select id_empleado from empleados where nombre_empleado = '" + empleado.getNombreEmpleado() + "' and apellido_empleado = '"+ empleado.getApellidoEmpleado() +"';";
        Statement st;
        ResultSet rs;
        try{
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                String aux = rs.getString(1);
    
                id_empleado = Integer.parseInt(aux);
            }
        }catch(SQLException e){
            System.out.println("Error al conectarse al sistema..." + e);
            JOptionPane.showMessageDialog(null, "Error al conectarse al sistema...");
        }
        return id_empleado;
    }
    
    public void setPrecioUnitarioTextField(JTextField precioUnitarioTextField){
        this.precioUnitarioTextField = precioUnitarioTextField;
    }
}
