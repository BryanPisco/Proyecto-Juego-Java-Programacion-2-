import javax.swing.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ProyectoPokemon{
    public static void main(String []arg)throws FileNotFoundException {
        File archivo_mapa = new File("mapeo.txt");
        File archivo_items = new File("posicion_items.txt");
        Scanner arch_items = new Scanner(archivo_items);
        Scanner arch_mapa = new Scanner(archivo_mapa);
        Mapa juego = new Mapa();
        juego.crear(arch_mapa);
        juego.cargarItems(arch_items);

        JFrame frame = new JFrame("Proyecto Pokemon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(juego);  // Agregar el mapa al JFrame
        //juego.requestFocusInWindow();
        frame.setSize(800, 800);  // Ajusta el size segun tus necesidades
        frame.setVisible(true);
        juego.requestFocusInWindow();
    }
}
