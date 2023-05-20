/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package taqueria;

import Controlador.Ctrl_Usuario;
import Modelo.Usuario;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class OpcionesMenu extends javax.swing.JFrame {

    public static JDesktopPane jDesktopPane_menu;
    private Usuario usuarioLoggedIn;

    public OpcionesMenu() {
        initComponents();
        this.setSize(new Dimension(1200, 700));
        // this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("TAQUERIA LA GLORIETA");
        this.setLayout(null);
        jDesktopPane_menu = new JDesktopPane();
        this.setLayout(null);
        jDesktopPane_menu = new JDesktopPane();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.jDesktopPane_menu.setBounds(0, 0, ancho, (alto - 110));
        this.add(jDesktopPane_menu);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JMenuBar();
        menuInv = new javax.swing.JMenu();
        menuIProducto = new javax.swing.JMenuItem();
        menuMProducto = new javax.swing.JMenuItem();
        menuVentas = new javax.swing.JMenu();
        menuRVenta = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuSueldos = new javax.swing.JMenu();
        menuSueldo = new javax.swing.JMenuItem();
        menuJornada = new javax.swing.JMenu();
        menuREntrada = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
        menuRUsuario = new javax.swing.JMenuItem();
        menuMUsuario = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();
        menuCerrarSesiion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(64, 33, 20));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(211, 207, 195));
        menu.setForeground(new java.awt.Color(108, 76, 60));

        menuInv.setBackground(new java.awt.Color(108, 76, 60));
        menuInv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/inventario.png"))); // NOI18N
        menuInv.setText("INVENTARIO");
        menuInv.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        menuInv.setMinimumSize(new java.awt.Dimension(180, 80));
        menuInv.setPreferredSize(new java.awt.Dimension(210, 50));

        menuIProducto.setBackground(new java.awt.Color(211, 207, 195));
        menuIProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo-producto.png"))); // NOI18N
        menuIProducto.setText("Ingresar producto");
        menuIProducto.setPreferredSize(new java.awt.Dimension(210, 50));
        menuIProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIProductoActionPerformed(evt);
            }
        });
        menuInv.add(menuIProducto);

        menuMProducto.setBackground(new java.awt.Color(211, 207, 195));
        menuMProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        menuMProducto.setText("Gestionar producto");
        menuMProducto.setPreferredSize(new java.awt.Dimension(210, 50));
        menuMProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMProductoActionPerformed(evt);
            }
        });
        menuInv.add(menuMProducto);

        menu.add(menuInv);

        menuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ventas.png"))); // NOI18N
        menuVentas.setText("VENTAS");
        menuVentas.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        menuVentas.setMinimumSize(new java.awt.Dimension(180, 80));
        menuVentas.setPreferredSize(new java.awt.Dimension(210, 80));

        menuRVenta.setBackground(new java.awt.Color(211, 207, 195));
        menuRVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/nuevo.png"))); // NOI18N
        menuRVenta.setText("Registrar artículo al menú");
        menuRVenta.setPreferredSize(new java.awt.Dimension(210, 50));
        menuRVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRVentaActionPerformed(evt);
            }
        });
        menuVentas.add(menuRVenta);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Modificar.png"))); // NOI18N
        jMenuItem1.setText("Gestionar artículo del menú");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuVentas.add(jMenuItem1);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/anadir.png"))); // NOI18N
        jMenuItem5.setText("Ventas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuVentas.add(jMenuItem5);

        menu.add(menuVentas);

        menuSueldos.setBackground(new java.awt.Color(108, 76, 60));
        menuSueldos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Sueldo.png"))); // NOI18N
        menuSueldos.setText("MANEJO DE SUELDOS");
        menuSueldos.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        menuSueldos.setMinimumSize(new java.awt.Dimension(180, 80));
        menuSueldos.setPreferredSize(new java.awt.Dimension(210, 80));

        menuSueldo.setBackground(new java.awt.Color(211, 207, 195));
        menuSueldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/sueldo.png"))); // NOI18N
        menuSueldo.setText("Sueldo");
        menuSueldo.setPreferredSize(new java.awt.Dimension(210, 50));
        menuSueldos.add(menuSueldo);

        menu.add(menuSueldos);

        menuJornada.setBackground(new java.awt.Color(108, 76, 60));
        menuJornada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Jornada.png"))); // NOI18N
        menuJornada.setText("REGISTRO DE JORNADA");
        menuJornada.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        menuJornada.setMinimumSize(new java.awt.Dimension(180, 80));
        menuJornada.setPreferredSize(new java.awt.Dimension(210, 80));

        menuREntrada.setBackground(new java.awt.Color(211, 207, 195));
        menuREntrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Entrada.png"))); // NOI18N
        menuREntrada.setText("Registrar jornada");
        menuREntrada.setPreferredSize(new java.awt.Dimension(210, 50));
        menuREntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuREntradaActionPerformed(evt);
            }
        });
        menuJornada.add(menuREntrada);

        menu.add(menuJornada);

        menuUsuario.setBackground(new java.awt.Color(211, 207, 195));
        menuUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/clientes.png"))); // NOI18N
        menuUsuario.setText("USUARIOS");
        menuUsuario.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        menuUsuario.setMinimumSize(new java.awt.Dimension(180, 80));
        menuUsuario.setPreferredSize(new java.awt.Dimension(210, 50));

        menuRUsuario.setBackground(new java.awt.Color(211, 207, 195));
        menuRUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cliente.png"))); // NOI18N
        menuRUsuario.setText("Registrar usuario");
        menuRUsuario.setPreferredSize(new java.awt.Dimension(210, 50));
        menuRUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(menuRUsuario);

        menuMUsuario.setBackground(new java.awt.Color(211, 207, 195));
        menuMUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Modificar.png"))); // NOI18N
        menuMUsuario.setText("Modificar usuario");
        menuMUsuario.setPreferredSize(new java.awt.Dimension(210, 50));
        menuMUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(menuMUsuario);

        menu.add(menuUsuario);

        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Salir.png"))); // NOI18N
        menuSalir.setText("SALIR");
        menuSalir.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        menuSalir.setMinimumSize(new java.awt.Dimension(180, 80));
        menuSalir.setPreferredSize(new java.awt.Dimension(210, 80));

        menuCerrarSesiion.setBackground(new java.awt.Color(211, 207, 195));
        menuCerrarSesiion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Exit.png"))); // NOI18N
        menuCerrarSesiion.setText("Cerrar sesion");
        menuCerrarSesiion.setPreferredSize(new java.awt.Dimension(210, 50));
        menuCerrarSesiion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarSesiionActionPerformed(evt);
            }
        });
        menuSalir.add(menuCerrarSesiion);

        menu.add(menuSalir);

        setJMenuBar(menu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuMProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMProductoActionPerformed
        GestionarProducto gp = new GestionarProducto();
        jDesktopPane_menu.add(gp);
        gp.setVisible(true);
    }//GEN-LAST:event_menuMProductoActionPerformed

    private void menuMUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMUsuarioActionPerformed
        // TODO add your handling code here:
        System.out.println("2");
    }//GEN-LAST:event_menuMUsuarioActionPerformed

    private void menuIProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIProductoActionPerformed
        Inventario inv = new Inventario();
        jDesktopPane_menu.add(inv);
        inv.setVisible(true);
        inv.moveToFront();


    }//GEN-LAST:event_menuIProductoActionPerformed

    private void menuRVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRVentaActionPerformed
        RegistrarArticuloMenu registrarVenta = new RegistrarArticuloMenu();
        jDesktopPane_menu.add(registrarVenta);
        registrarVenta.setVisible(true);
        registrarVenta.moveToFront();
    }//GEN-LAST:event_menuRVentaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        GestionarArticuloMenu modificarArticuloMenu = new GestionarArticuloMenu();
        jDesktopPane_menu.add(modificarArticuloMenu);
        modificarArticuloMenu.setVisible(true);
        modificarArticuloMenu.moveToFront();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        AgregarVenta agregarVenta = new AgregarVenta();
        jDesktopPane_menu.add(agregarVenta);
        agregarVenta.setVisible(true);
        agregarVenta.moveToFront();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void menuRUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRUsuarioActionPerformed
        RegistrarUsuario registrarUsuario = new RegistrarUsuario();
        jDesktopPane_menu.add(registrarUsuario);
        registrarUsuario.setVisible(true);
        registrarUsuario.moveToFront();
    }//GEN-LAST:event_menuRUsuarioActionPerformed

    private void menuCerrarSesiionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarSesiionActionPerformed

        JOptionPane.showMessageDialog(this, "Sesión cerrada correctamente");

        // Redirigir al formulario de inicio de sesión
        
        LoginTaqueria formularioInicioSesion = new LoginTaqueria();
        formularioInicioSesion.setVisible(true);

        // Cerrar la ventana actual
        this.dispose();
    }//GEN-LAST:event_menuCerrarSesiionActionPerformed

    private void menuREntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuREntradaActionPerformed
       RegistrarJornada rj=new RegistrarJornada();
       jDesktopPane_menu.add(rj);
       rj.setVisible(true);
       rj.moveToFront();
       
    }//GEN-LAST:event_menuREntradaActionPerformed

    public void usuarioLoggedIn(Usuario usuario){
        usuarioLoggedIn = usuario;
        Ctrl_Usuario ctrlUsuario = new Ctrl_Usuario();
        ctrlUsuario.obtenerPuesto(usuarioLoggedIn);
        
        switch(usuarioLoggedIn.getPuestoEmpleado()){
            case "admin" -> {
                this.setTitle("TAQUERIA LA GLORIETA (admin)");
            }
            case "asador" -> {
                menuIProducto.setEnabled(false);
                menuMProducto.setEnabled(false);
                menuRVenta.setEnabled(false);
                jMenuItem1.setEnabled(false);
                jMenuItem5.setEnabled(false);
                menuSueldo.setEnabled(false);
                menuRUsuario.setEnabled(false);
                menuMUsuario.setEnabled(false);
                this.setTitle("TAQUERIA LA GLORIETA (asador)");
            }
            case "taquero" -> {
                menuIProducto.setEnabled(false);
                menuMProducto.setEnabled(false);
                menuRVenta.setEnabled(false);
                jMenuItem1.setEnabled(false);
                jMenuItem5.setEnabled(false);
                menuSueldo.setEnabled(false);
                menuRUsuario.setEnabled(false);
                menuMUsuario.setEnabled(false);
                this.setTitle("TAQUERIA LA GLORIETA (taquero)");
            }
            case "mesero" -> {
                menuIProducto.setEnabled(false);
                menuMProducto.setEnabled(false);
                menuRVenta.setEnabled(false);
                jMenuItem1.setEnabled(false);
                menuSueldo.setEnabled(false);
                menuRUsuario.setEnabled(false);
                menuMUsuario.setEnabled(false);
                this.setTitle("TAQUERIA LA GLORIETA (mesero)");
            }
            case "cajero" -> {
                menuIProducto.setEnabled(false);
                menuMProducto.setEnabled(false);
                menuRVenta.setEnabled(false);
                jMenuItem1.setEnabled(false);
                jMenuItem5.setEnabled(false);
                menuRUsuario.setEnabled(false);
                menuMUsuario.setEnabled(false);
                this.setTitle("TAQUERIA LA GLORIETA (cajero)");
            }
            default -> {
                menuIProducto.setEnabled(false);
                menuMProducto.setEnabled(false);
                menuRVenta.setEnabled(false);
                jMenuItem1.setEnabled(false);
                jMenuItem5.setEnabled(false);
                menuRUsuario.setEnabled(false);
                menuMUsuario.setEnabled(false);
                menuREntrada.setEnabled(false);
                menuSueldo.setEnabled(false);
                JOptionPane.showMessageDialog(null, "Error: no se reconoció el puesto del empleado.");
                //System.out.println(usuario.getPuestoEmpleado());
            }
        }
    }

    // public void setUsuarioLogged(Usuario usuario){
    //usuarioLogged = usuario;
    //  }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OpcionesMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcionesMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcionesMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcionesMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpcionesMenu().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenuItem menuCerrarSesiion;
    private javax.swing.JMenuItem menuIProducto;
    private javax.swing.JMenu menuInv;
    private javax.swing.JMenu menuJornada;
    private javax.swing.JMenuItem menuMProducto;
    private javax.swing.JMenuItem menuMUsuario;
    private javax.swing.JMenuItem menuREntrada;
    private javax.swing.JMenuItem menuRUsuario;
    private javax.swing.JMenuItem menuRVenta;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JMenuItem menuSueldo;
    private javax.swing.JMenu menuSueldos;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenu menuVentas;
    // End of variables declaration//GEN-END:variables
}
