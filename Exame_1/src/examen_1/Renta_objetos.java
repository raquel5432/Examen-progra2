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


    static ArrayList<RentItem> items = new ArrayList<>();

    public static void main(String[] args) {

        while (true) {

            String menu =
                    "1) Agregar Ítem\n" +
                    "2) Rentar Ítem\n" +
                    "3) Ejecutar Submenú\n" +
                    "4) Imprimir Todo\n" +
                    "5) Salir\n";

            int op = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (op) {
                case 1: agregarItem(); break;
                case 2: rentarItem(); break;
                case 3: ejecutarSubmenu(); break;
                case 4: imprimirTodo(); break;
                case 5: return;
                default: JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }

    private static boolean codigoExiste(String cod) {
        for (RentItem r : items) {
            if (r.getCodigo().equals(cod))
                return true;
        }
        return false;
    }

    private static ImageIcon cargarImagen() {
        try {
            String path = JOptionPane.showInputDialog("Ingrese ruta de la imagen:");
            return new ImageIcon(path);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Imagen no cargada.");
            return null;
        }
    }

    private static void agregarItem() {
        String[] opciones = {"Movie", "Game"};
        int tipo = JOptionPane.showOptionDialog(null, "Seleccione tipo:",
                "Agregar", 0, 0, null, opciones, opciones[0]);

        String cod = JOptionPane.showInputDialog("Código:");
        if (codigoExiste(cod)) {
            JOptionPane.showMessageDialog(null, "Código duplicado.");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Nombre:");
        ImageIcon img = cargarImagen();

        if (tipo == 0) {  // MOVIE
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio Base:"));
            items.add(new Movie(cod, nombre, precio, img));
        } else {  // GAME
            items.add(new Game(cod, nombre, img));
        }

        JOptionPane.showMessageDialog(null, "Ítem agregado.");
    }

    private static RentItem buscar(String cod) {
        for (RentItem r : items)
            if (r.getCodigo().equals(cod)) return r;
        return null;
    }

    private static void rentarItem() {
        String cod = JOptionPane.showInputDialog("Código:");
        RentItem r = buscar(cod);

        if (r == null) {
            JOptionPane.showMessageDialog(null, "Item No Existe");
            return;
        }

        JOptionPane.showMessageDialog(null, r.toString(), "Datos del Ítem",
                JOptionPane.INFORMATION_MESSAGE, r.getImage());

        int dias = Integer.parseInt(JOptionPane.showInputDialog("Días a rentar:"));
        double total = r.pagoRenta(dias);

        JOptionPane.showMessageDialog(null, "Total a pagar: " + total + " Lps");
    }

    private static void ejecutarSubmenu() {
        String cod = JOptionPane.showInputDialog("Código:");
        RentItem r = buscar(cod);

        if (r == null) {
            JOptionPane.showMessageDialog(null, "Item No Existe");
            return;
        }

        if (r instanceof MenuActions) {
            ((MenuActions) r).submenu();
        } else {
            JOptionPane.showMessageDialog(null, "Este ítem no tiene submenú.");
        }
    }

    private static void imprimirTodo() {
        String texto = "";

        for (RentItem r : items) {
            texto += "----------------------\n";
            texto += r.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, texto);
    }
}