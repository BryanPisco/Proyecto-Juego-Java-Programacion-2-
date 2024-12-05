import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public abstract class Item {
    private int x;
    private int y;

    public Item(){

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

    public void leer(Scanner arch){
        this.x = arch.nextInt();
        this.y = arch.nextInt();
    }

    public abstract void interactuar(Personaje personaje);

    public abstract void render(Graphics g,int tamanho_celda);
}
