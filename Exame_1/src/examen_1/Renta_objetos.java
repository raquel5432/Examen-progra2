/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen_1;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ALISSONRAQUELMARTINE
 */
public class Renta_objetos {
 private ArrayList<RentItem> objeto;

public Renta_objetos(){
    objeto = new ArrayList<>();
    
}

public void inicio(){
    while(true){
        String menu=
                "1) Agregar objeto\n" +
                "2) Rentar objeto\n" +
                "3) Iniciar menu-juego\n"+
                "4) Imprimir reporte\n"+
                "5) salir";
       
        int opciones = Integer.parseInt(JOptionPane.showInputDialog(menu));
        
        switch(opciones){
            
            case 1: agregarObjet();
            break;
            case 2: rentarObjeto();
            break;
            case 3: iniciarSubmenu();
            break;
            case 4: imprimiReporte();
            break;
            case 5: return;
            default:
                JOptionPane.showInputDialog(null,"Opcion invalida");
            
        }
    }
}

private boolean codigoExiste(String codigo){

for(RentItem r : objeto)  
    if(r.getCodigo().equals(codigo))
        return true;
return false;
}

private ImageIcon cargarImagen(){
    try {
        String path = JOptionPane.showInputDialog("Ruta de la imagen");
        return new ImageIcon(path);
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,"Error cargando imagen.");
    return null;
    }   
}

private void agregarObjeto(){
    
    String[] opciones = {"Movie","Game"};
    int tipo = JOptionPane.showOptionDialog(null,"Selecione tipo de objeto;",
            "Agregar Objeto",0,0, 
            null,opciones,opciones[0]);
}

String codigo = JOptionPane.showInputDialog("Codigo:");

if (codigoExiste(codigo)){
JOptionPane.showMessageDialog(null, "Código ya existe.");
            return;
        }
String Nombre = JOptionPane.showInputDialog("nombre:");
ImageIcon imagen = cargarImagen();

if (tipo == 0){
double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio Base:"));

objeto.add(new Movie(codigo,Nombre,precio,imagen));
}else{
objeto.add(new Game(codigo,Nombre,imagen));
}
JOptionPane
}




