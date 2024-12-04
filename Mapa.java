import java.util.ArrayList;
import java.util.Scanner;
// Imports para mapeo
import javax.swing.*;
import java.awt.*;
// imports para movimiento de personaje
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Mapa extends JPanel implements KeyListener{
    private int size_x;
    private int size_y;
    private ArrayList<Casilla> casillas;
    private int tamanho_celda;
    private Personaje personaje;

    public Mapa(){
        size_x = 20;
        size_y = 20;
        casillas = new ArrayList<>(size_x * size_y);
        tamanho_celda = 40;
        personaje = new Personaje();

        setFocusable(true);
        addKeyListener(this);
    }

    public Mapa(int size_x,int size_y){
        this.size_x = size_x;
        this.size_y = size_y;
        casillas = new ArrayList<>(size_x * size_y);
        tamanho_celda = 40;
        personaje = new Personaje();

        setFocusable(true);
        addKeyListener(this);
    }

    public Casilla ObtenerCasilla(int x,int y){
        int index = x * size_x + y;
        if (x >= 0 && x < size_x && y >= 0 && y < size_y && index < casillas.size()) return casillas.get(index);
        return null;
    }

    public void crear(Scanner arch){
        while(arch.hasNext()){
            Casilla cas = new Casilla();
            cas.leer(arch);
            casillas.add(cas);
        }
    }

    // Implementacion del metodo keyPressed de KeyListener
    @Override
    public void keyPressed(KeyEvent key) {
        int x = personaje.GetPosX_Inicial();
        int y = personaje.GetPosY_Inicial();

        int keyCode = key.getKeyCode();
        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {  // Arriba
            if (y > 0) personaje.mover_arriba(this);
        }

        if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {  // Abajo
            if (y < size_y - 1) personaje.mover_abajo(this);
        }

        if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {  // Izquierda
            if (x > 0) personaje.mover_izquierda(this);
        }

        if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {  // Arriba
            if (x < size_x - 1) personaje.mover_derecha(this);
        }
        repaint(); // Redibujar el panel despues de mover al personaje
    }

    // Metodos vacios necesarios para implementar KeyListener
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void addNotify(){
        super.addNotify();
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Casilla casilla : casillas) {
            casilla.dibujar(g, tamanho_celda);
        }
        personaje.dibujar(g,tamanho_celda);
    }
}