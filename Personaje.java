import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.FileNotFoundException;

public class Personaje{
    private int x_pos_inicial;
    private int y_pos_inicial;
    private int salud;
    private int mana;
    private ArrayList<ArrayList<Image>> spritesPorDireccion;
    //private ArrayList<Image> sprites;
    private int sprite_indice;
    //private char elemento;
    private String direccionActual;

    public Personaje(){
        x_pos_inicial = 6;
        y_pos_inicial = 14;
        direccionActual = "abajo";
        salud = 50;
        mana = 50;
        //elemento = 'P';

        spritesPorDireccion = new ArrayList<>(4);
        try{
        cargarSpritesPorDireccion("Sprites/Personaje Pokemon/Arriba", "arriba");
        cargarSpritesPorDireccion("Sprites/Personaje Pokemon/Abajo", "abajo");
        cargarSpritesPorDireccion("Sprites/Personaje Pokemon/Izquierda", "izquierda");
        cargarSpritesPorDireccion("Sprites/Personaje Pokemon/Derecha", "derecha");
        } catch (FileNotFoundException e){
            System.err.println("Error al cargar sprites: " + e.getMessage());
        }
        sprite_indice=0;
    }

    public void SetPosX_Inicial(int x_pos_inicial){
        this.x_pos_inicial = x_pos_inicial;
    }

    public int GetPosX_Inicial(){
        return this.x_pos_inicial;
    }

    public void SetPosY_Inicial(int y_pos_inicial){
        this.y_pos_inicial = y_pos_inicial;
    }

    public int GetPosY_Inicial(){
        return this.y_pos_inicial;
    }
    
    public void aumentarSalud(int cantidad) {
        salud += cantidad;
        System.out.println("Nueva salud: " + salud);
    }

    public void aumentarMana(int cantidad) {
        mana += cantidad;
        System.out.println("Nuevo Mana: " + mana);
    }

    public void cargarSpritesPorDireccion(String carpeta, String direccion) throws FileNotFoundException{
        ArrayList<Image> sprites = new ArrayList<>(4);
        
        for (int i=1;i<=4;i++){
            String nombreArchivo = carpeta + "/movimiento_" + i + ".png";
            // Se agrega un File para obtener el archivo y comprobar si existe , esto es de prueba ya que se esta aprendiendo a usar
            File archivo = new File(nombreArchivo);
            if(archivo.exists()){
                sprites.add(new ImageIcon(nombreArchivo).getImage());
            } else{
                System.out.println("No se encontro el archivo: " + nombreArchivo);
            }
        }
        
        if(sprites.size() == 4){
            spritesPorDireccion.add(sprites);
        }else{
            System.out.println("No se cargaron correctamente todos los sprites para " + direccion);
        }
    }

    public void dibujar(Graphics g, int tamCelda){
        int direccionIndice = obtenerIndiceDireccion(direccionActual);
        g.drawImage(spritesPorDireccion.get(direccionIndice).get(sprite_indice), x_pos_inicial * tamCelda, y_pos_inicial * tamCelda, tamCelda, tamCelda, null);
        
        // g.setColor(Color.BLACK);
        // g.fillRect(x_pos_inicial * tamCelda, y_pos_inicial * tamCelda, tamCelda, tamCelda);

        g.setColor(Color.BLACK);
        g.drawRect(x_pos_inicial * tamCelda, y_pos_inicial * tamCelda, tamCelda, tamCelda);

        //g.setColor(Color.WHITE);
        //g.drawString(String.valueOf(elemento), x_pos_inicial * tamCelda + tamCelda / 4, y_pos_inicial * tamCelda + tamCelda / 2);
    }

    public void alternarSprite(){
        sprite_indice = (sprite_indice + 1) % 4;
    }

    public int obtenerIndiceDireccion(String direccion) {
        if(direccion == "arriba") return 0;
        if(direccion == "abajo") return 1;
        if(direccion == "izquierda") return 2;
        if(direccion == "derecha") return 3;
        return 1; // Retorno 1 por defecto ya que es donde aparece por primera vez en el mapa
    }

    public void mover_arriba(Mapa map){
        int x = GetPosX_Inicial();
        int y = GetPosY_Inicial();
        Casilla futura_casilla = map.ObtenerCasilla(x,y-1);
        if (futura_casilla != null){
            System.out.println("Movimiento Arriba Elemento de la casilla futura: " + futura_casilla.GetElemento() + " Posicion en X = " + futura_casilla.GetX()+ " Posicion en Y = " + futura_casilla.GetY());
            if(futura_casilla.GetElemento() == 'I'){
                SetPosY_Inicial(y_pos_inicial-1);
                direccionActual = "arriba";
                alternarSprite();
            }
        }
    }

    public void mover_derecha(Mapa map){
        int x = GetPosX_Inicial();
        int y = GetPosY_Inicial();
        Casilla futura_casilla = map.ObtenerCasilla(x+1,y);
        if (futura_casilla != null){
            System.out.println("Movimiento Derecha Elemento de la casilla futura: " + futura_casilla.GetElemento() + " Posicion en X = " + futura_casilla.GetX()+ " Posicion en Y = " + futura_casilla.GetY());
            if(futura_casilla.GetElemento() == 'I'){
                SetPosX_Inicial(x_pos_inicial+1);
                direccionActual = "derecha";
                alternarSprite();
            }
        }
    }

    public void mover_izquierda(Mapa map){
        int x = GetPosX_Inicial();
        int y = GetPosY_Inicial();
        Casilla futura_casilla = map.ObtenerCasilla(x-1,y);
        if (futura_casilla != null){
            System.out.println("Movimiento Izquierda Elemento de la casilla futura: " + futura_casilla.GetElemento() + " Posicion en X = " + futura_casilla.GetX()+ " Posicion en Y = " + futura_casilla.GetY());
            if(futura_casilla.GetElemento() == 'I'){
                SetPosX_Inicial(x_pos_inicial-1);
                direccionActual = "izquierda";
                alternarSprite();
            }
        }
    }

    public void mover_abajo(Mapa map){
        int x = GetPosX_Inicial();
        int y = GetPosY_Inicial();
        Casilla futura_casilla = map.ObtenerCasilla(x,y+1);
        if (futura_casilla != null){
            System.out.println("Movimiento Abajo Elemento de la casilla futura: " + futura_casilla.GetElemento() + " Posicion en X = " + futura_casilla.GetX()+ " Posicion en Y = " + futura_casilla.GetY());
            if(futura_casilla.GetElemento() == 'I'){
                SetPosY_Inicial(y_pos_inicial+1);
                direccionActual = "abajo";
                alternarSprite();
            }
        }
    }
}