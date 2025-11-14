/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_1;

/**
 *
 * @author trigo
 */
import java.util.*;
import javax.swing.*;

public class Game extends RentItem implements MenuActions{
    private Calendar fechaPublicacion;
    private ArrayList<String> especificaciones;
    
    public Game(String codigo, String nombre, ImageIcon imagen){
        super(codigo, nombre, 20, imagen);
        fechaPublicacion = Calendar.getInstance();
        especificaciones = new ArrayList<>();
    }
    
    public void setFechaPublicacion(int y, int m, int d){
        fechaPublicacion.set(y, m - 1, d);
    }
    
    @Override
    public double pagoRenta(int dias){
        return 20 * dias;
    }
    
    @Override
    public String toString(){
        return super.toString() + 
                "\nFecha Publicacion: " + fechaPublicacion.getTime() +
                " - PS3 Game";
    }

    
    @Override
    public void submenu() {
        String menu =
                "1) Actualizar Fecha de Publicacion\n" +
                "2) Agregar Especificacion\n" +
                "3) Ver Especificaciones\n";
        
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
        ejecutarOpcion(op);
    }
    
    @Override
    public void ejecutarOpcion(int opcion) {
        switch(opcion) {
            case 1:
                int y = Integer.parseInt(JOptionPane.showInputDialog("Anio:"));
                int m = Integer.parseInt(JOptionPane.showInputDialog("Mes:"));
                int d = Integer.parseInt(JOptionPane.showInputDialog("Dia:"));
                setFechaPublicacion(y, m, d);
                JOptionPane.showMessageDialog(null, "Fecha actualizada.");
                break;
                
            case 2:
                String esp= JOptionPane.showInputDialog("Nueva especificacion:");
                especificaciones.add(esp);
                JOptionPane.showMessageDialog(null, "Agregada.");
                break;
                
            case 3:
                if(especificaciones.isEmpty()){
                    JOptionPane.showMessageDialog(null, "No hay especificaciones.");
                } else {
                    mostrarEspecificacionesRec(0, "");
                }
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Opcion invalida.");
        }
    }
    
    private void mostrarEspecificacionesRec(int i, String acumulado) {
        if (i == especificaciones.size()) {
            JOptionPane.showMessageDialog(null, acumulado);
            return;
        }
        
        mostrarEspecificacionesRec(i + 1, acumulado + "- " + especificaciones.get(i)+ "\n");
    }
}
