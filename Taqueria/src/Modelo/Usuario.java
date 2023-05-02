package Modelo;

/**
 *
 * @author 1
 */
public class Usuario {

    //atributos
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private String telefono;
    private int esatado;

    public Usuario() {
        this.id_usuario = 0;
        this.nombre = "";
        this.apellido = "";
        this.usuario = "";
        this.password = "";
        this.telefono = "";
        this.esatado = 0;
    }
 // set and get

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEsatado() {
        return esatado;
    }

    public void setEsatado(int esatado) {
        this.esatado = esatado;
    }
    
}


