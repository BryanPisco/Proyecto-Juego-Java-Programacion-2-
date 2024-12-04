import java.awt.Color;
import java.awt.Graphics;

class Personaje{
    private int x_pos_inicial;
    private int y_pos_inicial;
    private char elemento;

    public Personaje(){
        x_pos_inicial = 6;
        y_pos_inicial = 14;
        elemento = 'P';
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

    public void dibujar(Graphics g, int tamCelda){
        g.setColor(Color.BLACK);
        g.fillRect(x_pos_inicial * tamCelda, y_pos_inicial * tamCelda, tamCelda, tamCelda);

        g.setColor(Color.BLACK);
        g.drawRect(x_pos_inicial * tamCelda, y_pos_inicial * tamCelda, tamCelda, tamCelda);

        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(elemento), x_pos_inicial * tamCelda + tamCelda / 4, y_pos_inicial * tamCelda + tamCelda / 2);
    }
    //Mapa map
    //&& futura_casilla.GetElemento() == 'I'
    public void mover_arriba(Mapa map){
        int x = GetPosX_Inicial();
        int y = GetPosY_Inicial();
        Casilla futura_casilla = new Casilla();
        futura_casilla = map.ObtenerCasilla(x,y-1);
        //SetPosY_Inicial(y_pos_inicial-1);
        //if (futura_casilla != null && (futura_casilla.GetElemento() == 'I' || futura_casilla.GetElemento() == 'P')) SetPosY_Inicial(y_pos_inicial-1);
        if (futura_casilla != null){
            System.out.println("Movimiento Arriba Elemento de la casilla futura: " + futura_casilla.GetElemento() + " Posicion en X = " + futura_casilla.GetX()+ " Posicion en Y = " + futura_casilla.GetY());
            if(futura_casilla.GetElemento() == 'I') SetPosY_Inicial(y_pos_inicial-1);
        }
        //map.repaint();
    }

    public void mover_derecha(Mapa map){
        int x = GetPosX_Inicial();
        int y = GetPosY_Inicial();
        Casilla futura_casilla = new Casilla();
        futura_casilla = map.ObtenerCasilla(x+1,y);
        //SetPosX_Inicial(x_pos_inicial+1);
        //if (futura_casilla != null && (futura_casilla.GetElemento() == 'I' || futura_casilla.GetElemento() == 'P')) SetPosX_Inicial(x_pos_inicial+1);
        if (futura_casilla != null){
            System.out.println("Movimiento Derecha Elemento de la casilla futura: " + futura_casilla.GetElemento() + " Posicion en X = " + futura_casilla.GetX()+ " Posicion en Y = " + futura_casilla.GetY());
            if(futura_casilla.GetElemento() == 'I') SetPosX_Inicial(x_pos_inicial+1);
        }
        //map.repaint();
    }

    public void mover_izquierda(Mapa map){
        int x = GetPosX_Inicial();
        int y = GetPosY_Inicial();
        Casilla futura_casilla = new Casilla();
        futura_casilla = map.ObtenerCasilla(x-1,y);
        //SetPosX_Inicial(x_pos_inicial-1);
        //if (futura_casilla != null && (futura_casilla.GetElemento() == 'I' || futura_casilla.GetElemento() == 'P')) SetPosX_Inicial(x_pos_inicial-1);
        if (futura_casilla != null){
            System.out.println("Movimiento Izquierda Elemento de la casilla futura: " + futura_casilla.GetElemento() + " Posicion en X = " + futura_casilla.GetX()+ " Posicion en Y = " + futura_casilla.GetY());
            if(futura_casilla.GetElemento() == 'I') SetPosX_Inicial(x_pos_inicial-1);
        }
        //map.repaint();
    }

    public void mover_abajo(Mapa map){
        int x = GetPosX_Inicial();
        int y = GetPosY_Inicial();
        Casilla futura_casilla = new Casilla();
        futura_casilla = map.ObtenerCasilla(x,y+1);
        //SetPosY_Inicial(y_pos_inicial+1);
        //if (futura_casilla != null && (futura_casilla.GetElemento() == 'I' || futura_casilla.GetElemento() == 'P')) SetPosY_Inicial(y_pos_inicial+1);
        if (futura_casilla != null){
            System.out.println("Movimiento Abajo Elemento de la casilla futura: " + futura_casilla.GetElemento() + " Posicion en X = " + futura_casilla.GetX()+ " Posicion en Y = " + futura_casilla.GetY());
            if(futura_casilla.GetElemento() == 'I') SetPosY_Inicial(y_pos_inicial+1);
        }
        //map.repaint();
    }
}