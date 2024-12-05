import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class PosionSalud extends Item{
    private int aumento_salud;
    private Image sprite;

    public void SetAumento(int aumento_salud){
        this.aumento_salud = aumento_salud;
    }

    public int GetAumento(){
        return this.aumento_salud;
    }

    @Override
    public void leer(Scanner arch){
        super.leer(arch);
        aumento_salud = arch.nextInt();
        sprite = new ImageIcon("Sprites/Item/posion_vida.png").getImage();
    }

    @Override
    public void interactuar(Personaje personaje){
        personaje.aumentarSalud(aumento_salud);
        System.out.println("Salud aumentada en: " + aumento_salud);
    }

    @Override
    public void render(Graphics g,int tamanho_celda) {
        //Image scaledSprite = sprite.getScaledInstance(tamanho_celda, tamanho_celda, Image.SCALE_SMOOTH);
        g.drawImage(sprite, super.GetX()*tamanho_celda, super.GetY()*tamanho_celda, null);
    }
}
