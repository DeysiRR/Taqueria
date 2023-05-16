package taqueria;

import Conexion.Conexion;
import Controlador.Ctrl_Inventario;
import Modelo.MInventario;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

/**
 *
 * @author 1
 */
public class GestionarProducto extends javax.swing.JInternalFrame {

    private int id_Productos;

    public GestionarProducto() {
        initComponents();
        this.setSize(new Dimension(600, 400));
        this.setTitle("Gestionar Productos");
        this.TablaProdcutos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGP = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtGDescp = new javax.swing.JTextField();
        txtGCantidad = new javax.swing.JTextField();
        txtGProveedor = new javax.swing.JTextField();
        txtGProductoNombre = new javax.swing.JTextField();
        buttonEliminarP = new javax.swing.JButton();
        buttonActualizarP = new javax.swing.JButton();

        setBackground(new java.awt.Color(211, 207, 195));
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Gestion de productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 0, -1, -1));

        tablaGP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tablaGP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripcion", "Cantidad", "Proveedor"
            }
        ));
        jScrollPane1.setViewportView(tablaGP);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 535, 144));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Descripcion");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Proveedor");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Cantidad");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));
        getContentPane().add(txtGDescp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 330, -1));
        getContentPane().add(txtGCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 330, -1));
        getContentPane().add(txtGProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 330, -1));
        getContentPane().add(txtGProductoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 330, -1));

        buttonEliminarP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonEliminarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/EliminarP.png"))); // NOI18N
        buttonEliminarP.setText("Eliminar");
        buttonEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEliminarPActionPerformed(evt);
            }
        });
        getContentPane().add(buttonEliminarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 120, -1));

        buttonActualizarP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonActualizarP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/configuraciones.png"))); // NOI18N
        buttonActualizarP.setText("Actualizar");
        buttonActualizarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActualizarPActionPerformed(evt);
            }
        });
        getContentPane().add(buttonActualizarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEliminarPActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este producto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
    
    if (confirmacion == JOptionPane.YES_OPTION) {
        Ctrl_Inventario control = new Ctrl_Inventario();
        if (control.eliminarProducto(id_Productos)) {
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");
            txtGProductoNombre.setText("");
            txtGDescp.setText("");
            txtGCantidad.setText("");
            txtGProveedor.setText("");
            this.TablaProdcutos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al eliminar producto");
        }
    }
    }//GEN-LAST:event_buttonEliminarPActionPerformed

    private void buttonActualizarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActualizarPActionPerformed
        // Verificar que todos los campos estén llenos
        if (txtGProductoNombre.getText().isEmpty() || txtGDescp.getText().isEmpty() || txtGCantidad.getText().isEmpty() || txtGProveedor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son requeridos");
            return;
        }

        // Crear objeto de tipo MInventario con los datos actualizados
        MInventario objeto = new MInventario();
        objeto.setNombre(txtGProductoNombre.getText());
        objeto.setDescripcion(txtGDescp.getText());
        try {
            objeto.setCantidad(Integer.parseInt(txtGCantidad.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero");
            return;
        }
        objeto.setProovedor(txtGProveedor.getText());

        // Actualizar el producto en la base de datos
        Ctrl_Inventario control = new Ctrl_Inventario();
        if (control.actualizarInventario(objeto, id_Productos)) {
            JOptionPane.showMessageDialog(null, "Producto actualizado exitosamente");
            txtGProductoNombre.setText("");
            txtGDescp.setText("");
            txtGCantidad.setText("");
            txtGProveedor.setText("");
            this.TablaProdcutos();
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar producto");
        }
    }//GEN-LAST:event_buttonActualizarPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonActualizarP;
    private javax.swing.JButton buttonEliminarP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaGP;
    private javax.swing.JTextField txtGCantidad;
    private javax.swing.JTextField txtGDescp;
    private javax.swing.JTextField txtGProductoNombre;
    private javax.swing.JTextField txtGProveedor;
    // End of variables declaration//GEN-END:variables
// Metodo para mostrar todas los datos del producto en la tabla
    private void TablaProdcutos() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select id_producto,nombre,descripcion,cantidad,proovedor from inventario  ";
        Statement st;

        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            GestionarProducto.tablaGP = new JTable(model);
            GestionarProducto.jScrollPane1.setViewportView(GestionarProducto.tablaGP);

            model.addColumn("Id_Categoria");
            model.addColumn("Nombre");
            model.addColumn("Descripcion");
            model.addColumn("Cantidad");
            model.addColumn("Proovedor");

            while (rs.next()) {
                Object fila[] = new Object[5];
                for (int i = 0; i < 5; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla de productos");
        }
        tablaGP.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tablaGP.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    id_Productos = (int) model.getValueAt(fila_point, columna_point);
                    TransferirDatosInventario(id_Productos);

                }
            }
        });

    }

    private void TransferirDatosInventario(int id_Producto) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("SELECT nombre, descripcion, cantidad, proovedor FROM inventario WHERE id_producto = ?");
            pst.setInt(1, id_Producto);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtGProductoNombre.setText(rs.getString("nombre"));
                txtGDescp.setText(rs.getString("descripcion"));
                txtGCantidad.setText(rs.getString("cantidad"));
                txtGProveedor.setText(rs.getString("proovedor"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar producto: " + e.getMessage());
        }
    }

}
