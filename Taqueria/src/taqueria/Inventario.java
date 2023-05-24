package taqueria;

import Controlador.Ctrl_Inventario;
import Modelo.MInventario;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class Inventario extends javax.swing.JInternalFrame {

    public Inventario() {
        initComponents();
        this.setSize(new Dimension(420, 300));
        this.setTitle("Ingresar Producto");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDescP = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtProveedor = new javax.swing.JTextField();
        txtNombreP2 = new javax.swing.JTextField();
        buttonGuardarP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtDescP, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 210, -1));
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 210, -1));
        getContentPane().add(txtProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 210, -1));
        getContentPane().add(txtNombreP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 210, -1));

        buttonGuardarP.setText("Guardar");
        buttonGuardarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarPActionPerformed(evt);
            }
        });
        getContentPane().add(buttonGuardarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, -1, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Ingresar Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Cantidad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Proveedor");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Descripcion");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jPanel1.setBackground(new java.awt.Color(211, 207, 195));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonGuardarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarPActionPerformed

        MInventario inventario = new MInventario();
        Ctrl_Inventario controlInventario = new Ctrl_Inventario();

// Validar si se ingresan espacios vacíos
        if (txtDescP.getText().isEmpty() || txtCantidad.getText().isEmpty() || txtNombreP2.getText().isEmpty() || txtProveedor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
        } else {
            // Validar límites de caracteres para el nombre (máximo 50 caracteres)
            if (txtNombreP2.getText().length() > 50) {
                JOptionPane.showMessageDialog(null, "El nombre excede el límite de caracteres permitidos (50)");
            } // Validar límites de caracteres para la descripción (máximo 100 caracteres)
            else if (txtDescP.getText().length() > 100) {
                JOptionPane.showMessageDialog(null, "La descripción excede el límite de caracteres permitidos (100)");
            } // Validar límites de cantidad (no puede ser negativa)
            else if (Integer.parseInt(txtCantidad.getText().trim()) < 0) {
                JOptionPane.showMessageDialog(null, "La cantidad no puede ser negativa");
            } // Validar límites de caracteres para el proveedor (máximo 50 caracteres)
            else if (txtProveedor.getText().length() > 50) {
                JOptionPane.showMessageDialog(null, "El proveedor excede el límite de caracteres permitidos (50)");
            } else {
                // Validar si el producto ya existe en la base de datos
                String nombre = txtNombreP2.getText().trim();
                String descripcion = txtDescP.getText().trim();
                int cantidad = Integer.parseInt(txtCantidad.getText().trim());
                String proveedor = txtProveedor.getText().trim();
                if (controlInventario.existeProducto(nombre, descripcion, cantidad, proveedor)) {
                    JOptionPane.showMessageDialog(null, "Producto existente en la base de datos");
                } else {
                    inventario.setNombre(nombre);
                    inventario.setDescripcion(descripcion);
                    inventario.setCantidad(cantidad);
                    inventario.setProovedor(proveedor);

                    if (controlInventario.guardar(inventario)) {
                        JOptionPane.showMessageDialog(null, "Producto guardado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar");
                    }
                }
            }
        }

        txtNombreP2.setText("");
        txtDescP.setText("");
        txtCantidad.setText("");
        txtProveedor.setText("");

    }//GEN-LAST:event_buttonGuardarPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGuardarP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescP;
    private javax.swing.JTextField txtNombreP2;
    private javax.swing.JTextField txtProveedor;
    // End of variables declaration//GEN-END:variables

}
