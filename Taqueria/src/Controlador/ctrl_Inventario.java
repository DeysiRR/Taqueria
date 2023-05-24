package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import Modelo.MInventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ctrl_Inventario {

    //metodo para registar producto
    public boolean guardar(MInventario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into inventario(nombre, descripcion, cantidad, proovedor) values (?,?,?,?)");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getCantidad());
            consulta.setString(4, objeto.getProovedor());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar el producto: " + e);
        }
        return respuesta;
    }

    //consultar si ya se ha registrado el producto
    public boolean existeProducto(String nombre, String descripcion, int cantidad, String proveedor) {
    boolean respuesta = false;
    String sql = "SELECT nombre, descripcion, cantidad, proveedor FROM inventario WHERE nombre = ? AND descripcion = ? AND cantidad = ? AND proveedor = ?";
    try {
        Connection cn = Conexion.conectar();
        PreparedStatement consulta = cn.prepareStatement(sql);
        consulta.setString(1, nombre);
        consulta.setString(2, descripcion);
        consulta.setInt(3, cantidad);
        consulta.setString(4, proveedor);
        ResultSet rs = consulta.executeQuery();
        if (rs.next()) {
            respuesta = true;
        }
        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al consultar el producto: " + e);
    }
    return respuesta;
}

//metodo para actualizar el invdntario

    public boolean actualizarInventario(MInventario objeto, int id_producto) {
        boolean respuesta = false;
        Connection con = Conexion.conectar();
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE inventario SET nombre = ?, descripcion = ?, cantidad = ?, proovedor = ? WHERE id_producto = ?");
            pst.setString(1, objeto.getNombre());
            pst.setString(2, objeto.getDescripcion());
            pst.setInt(3, objeto.getCantidad());
            pst.setString(4, objeto.getProovedor());
            pst.setInt(5, id_producto);

            if (pst.executeUpdate() > 0) {
                respuesta = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar el producto: " + e);
        }
        return respuesta;
    }

    //metodo para eliminar un producto del inventario
    public boolean eliminarProducto(int id_producto) {
        boolean respuesta = false;
        Connection con = Conexion.conectar();
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM inventario WHERE id_producto = ?");
            pst.setInt(1, id_producto);

            if (pst.executeUpdate() > 0) {
                respuesta = true;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e);
        }
        return respuesta;
    }

}
