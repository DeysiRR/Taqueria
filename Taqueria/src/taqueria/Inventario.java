
package taqueria;

import java.awt.Dimension;

public class Inventario extends javax.swing.JInternalFrame {

    public Inventario() {
        initComponents();
        this.setSize(new Dimension(400,200));
        this.setTitle("Ingresar Producto");
        
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCantidadP = new javax.swing.JTextField();
        txtNombreP = new javax.swing.JTextField();
        buttonGuardarP = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(211, 207, 195));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(211, 207, 195));
        jLabel1.setText("Ingresar Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel2.setForeground(new java.awt.Color(211, 207, 195));
        jLabel2.setText("Cantidad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));
        getContentPane().add(txtCantidadP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 210, -1));
        getContentPane().add(txtNombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 210, -1));

        buttonGuardarP.setText("Guardar");
        getContentPane().add(buttonGuardarP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonGuardarP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtCantidadP;
    private javax.swing.JTextField txtNombreP;
    // End of variables declaration//GEN-END:variables
}
