/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.time.LocalDate;
/**
 *
 * @author franc
 */
public class Sueldo {
    private int id_sueldo;
    private int id_puesto;
    private int monto;
    private LocalDate fecha_pago;
    
    public Sueldo(int id_sueldo, int id_puesto, int monto, LocalDate fecha_pago)
    { 
        this.id_sueldo = id_sueldo;
        this.id_puesto = id_puesto;
        this.monto = monto;
        this.fecha_pago = fecha_pago;
    }
    public Sueldo(){
        this.id_sueldo = 0;
        this.id_puesto = 0;
        this.monto = 0;
        this.fecha_pago = null;
    }
    public void set_id_sueldo(int id_sueldo)
    {
        this.id_sueldo = id_sueldo;
    }
    public void set_id_puesto(int id_puesto)
    {
        this.id_puesto = id_puesto;
    }
    public void set_monto(int monto)
    {
        this.monto = monto;
    }
    public void set_fecha_pago(LocalDate fecha_pago)
    {
        this.fecha_pago = fecha_pago;
    }

    public int get_id_sueldo() {
        return id_sueldo;
    }
    public int get_id_puesto() {
        return id_puesto;
    }
    public int get_monto() {
        return monto;
    }
    public LocalDate get_fecha_pago() {
        return fecha_pago;
    }
}
