/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taqueria;

/**
 *
 * @author 1
 */
public class Taqueria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoginTaqueria loginTaqueria = new LoginTaqueria();
        loginTaqueria.run();
        Usuario usuario = new Usuario();
        usuario.setIsAdmin(true);
        usuario.setUsuario("admin");
        usuario.setPassword("123");
        loginTaqueria.setUsuario(usuario);
        System.out.println("hello");
        
    }
    
}
