/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_1;

/**
 *
 * @author trigo
 */
import java.util.Calendar;
import javax.swing.*;
public class Movie extends RentItem {
    
    private Calendar fechaEstreno;
    
    public Movie(String codigo, String nombre, double precio, ImageIcon image){
        super(codigo, nombre, precio, image);
        fechaEstreno = Calendar.getInstance();
    }
    
    public void setFechaEstreno(Calendar f) {
        this.fechaEstreno = f;
    }
    
    public Calendar getFechaEstreno(){
        return fechaEstreno;
    }
    
    public String getEstado(){
        Calendar hoy = Calendar.getInstance();
        
        int meses =
                (hoy.get(Calendar.YEAR) - fechaEstreno.get(Calendar.YEAR)) * 12 +
                (hoy.get(Calendar.MONTH) - fechaEstreno.get(Calendar.MONTH));
        
        return meses <= 3 ? "ESTRENO" : "NORMAL";
    }
    
    @Override
    public double pagoRenta(int dias) {
        String estado = getEstado();
        double total = precioBase * dias;
        
        if (estado.equals("ESTRENO") && dias > 2){
            total += (dias - 2) * 50;
        } else if (estado.equals("NORMAL") && dias > 5) {
            total += (dias - 5) * 30;
        }
        
        return total;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nEstado: " + getEstado() + " - Movie";
    }
}
