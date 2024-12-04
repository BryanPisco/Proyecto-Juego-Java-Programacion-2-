import javax.swing.*;
import java.util.Scanner;

class ProyectoPokemon{
    public static void main(String []arg){
        Scanner arch = new Scanner(System.in);
        Mapa juego = new Mapa();
        juego.crear(arch);

        JFrame frame = new JFrame("Proyecto Pokemon");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(juego);  // Agregar el mapa al JFrame
        //juego.requestFocusInWindow();
        frame.setSize(800, 800);  // Ajusta el size segun tus necesidades
        frame.setVisible(true);
        juego.requestFocusInWindow();
    }
}
