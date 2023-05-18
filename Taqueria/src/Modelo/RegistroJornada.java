/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;
import java.time.LocalDate;
import java.sql.Time;
/**
 *
 * @author 1
 */
public class RegistroJornada {
    private int id_registro;
    private int id_empleado;
    private LocalDate fecha;
    private Time hora_entrada;
    private Time hora_salida;

    public RegistroJornada() {
        this.id_registro = 0;
        this.id_empleado = 0;
        this.fecha = LocalDate.now(); // Asignar la fecha actual
        this.hora_entrada = null; 
        this.hora_salida = null; 
    }

    public RegistroJornada(int id_registro, int id_empleado, LocalDate fecha, Time hora_entrada, Time hora_salida) {
        this.id_registro = id_registro;
        this.id_empleado = id_empleado;
        this.fecha = fecha;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(Time hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public Time getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(Time hora_salida) {
        this.hora_salida = hora_salida;
    }
}
