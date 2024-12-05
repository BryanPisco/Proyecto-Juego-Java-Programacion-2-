import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class PosionMana extends Item{
    private int aumento_mana;
    private Image sprite;

    public void SetAumento(int aumento_mana){
        this.aumento_mana = aumento_mana;
    }

    public int GetAumento(){
        return this.aumento_mana;
    }

    @Override
    public void leer(Scanner arch){
        super.leer(arch);
        aumento_mana = arch.nextInt();
        sprite = new ImageIcon("Sprites/Item/posion_mana.png").getImage();
    }

    @Override
    public void interactuar(Personaje personaje){
        personaje.aumentarMana(aumento_mana);
        System.out.println("Mana aumentada en: " + aumento_mana);
    }

    @Override
    public void render(Graphics g,int tamanho_celda) {
        //Image scaledSprite = sprite.getScaledInstance(tamanho_celda, tamanho_celda, Image.SCALE_SMOOTH);
        //g.drawImage(sprite, super.GetX()*tamanho_celda, super.GetY()*tamanho_celda, null);
        g.drawImage(sprite, super.GetX() * tamanho_celda, super.GetY() * tamanho_celda, tamanho_celda, tamanho_celda, null);

        g.setColor(Color.BLACK);
        g.drawRect(super.GetX() * tamanho_celda, super.GetY() * tamanho_celda, tamanho_celda, tamanho_celda);
    }
}
