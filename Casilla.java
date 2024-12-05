import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

public class Casilla{
    private int x,y;
    private char elemento;

    public Casilla(){
        
    }

    public Casilla(int x,int y,char elemento){
        this.x = x;
        this.y = y;
        this.elemento = elemento;
    }

    public void SetX(int x){
        this.x = x;
    }

    public int GetX(){
        return this.x;
    }

    public void SetY(int y){
        this.y = y;
    }

    public int GetY(){
        return this.y;
    }

    public void SetElemento(char elemento){
        this.elemento = elemento;
    }

    public char GetElemento(){
        return this.elemento;
    }

    public void leer(Scanner arch){
        String buffer;
        x = arch.nextInt();
        y = arch.nextInt();
        buffer = arch.next();
        elemento = buffer.charAt(0);
    }

    public void dibujar(Graphics g, int tamCelda){
        if(elemento == 'I'){
            g.setColor(Color.ORANGE);
            g.fillRect(x * tamCelda, y * tamCelda, tamCelda, tamCelda);
            
            g.setColor(Color.BLACK);
            g.drawRect(x * tamCelda, y * tamCelda, tamCelda, tamCelda);
        }else{
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(x * tamCelda, y * tamCelda, tamCelda, tamCelda);
            
            g.setColor(Color.BLACK);
            g.drawRect(x * tamCelda, y * tamCelda, tamCelda, tamCelda);
        }
    }
}