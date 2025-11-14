/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_1;

/**
 *
 * @author trigo
 */
import javax.swing.*;
import java.util.Calendar;

public abstract class RentItem {
    protected String codigo;
    protected String nombre; 
    protected double precioBase;
    protected int copias;
    protected ImageIcon image;
    
    public RentItem(String codigo, String nombre, double precioBase, ImageIcon image){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioBase = precioBase; 
        this.copias = 0;
        this.image = image;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public ImageIcon getImage() {
        return image;
    }
    
    @Override
    public String toString(){
        return "Codigo: " + codigo + "\nNombre: " + nombre +
                "\nPrecio Base: " + precioBase + "\nCopias: " + copias;
    }
    
    public abstract double pagoRenta(int dias);
}
