package Ext;

import Main.Game;

import java.awt.*;

public class Ball{

    public static final int DYDIS = 16;

    private int x, y; //kamuoliuko pozicija ant ekrano
    private int xKryptis, yKryptis; //gali buti arba 1 arba -1
    public int greitis = 5; //pradinis greitis

    public Ball() {
        reset();
    }

    private void reset() {
        x = Game.PLOTIS/2 - DYDIS/2; //pastato kamuoliuka i ekrano centra
        y = Game.AUKSTIS/2 - DYDIS/2;
        xKryptis = Game.sign(Math.random() * 2.0 - 1); //sugeneruoja kamuoliuko krypti
        yKryptis = Game.sign(Math.random() * 2.0 - 1);
    }

    public void keistiXKrypti(){
        xKryptis = xKryptis * -1;
    }

    public void keistiYKrypti(){
        yKryptis = yKryptis * -1;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, DYDIS, DYDIS);
    }

    public void update(Paddle raketeK, Paddle raketeD) {
        x = x + xKryptis * greitis;
        y = y + yKryptis * greitis;

        if(y + DYDIS >= Game.AUKSTIS || y <= 0){ //jeigu kamuoliukas atsitrenkia i virsu arba apacia
            keistiYKrypti();
        }

        if(x + DYDIS >= Game.PLOTIS){ //jeigu desine rakete nepataiko i kamuoliuka
            raketeK.pridetiTaska();
            raketeD.height =85;
            reset();
        }
        if(x <= 0){ //jeigu kaire rakete nepataiko i kamuoliuka
            raketeD.pridetiTaska();
            reset();
        }
    }
    @Override
    public String toString() {
        return "Ball{" +
                "x=" + x +
                ", y=" + y +
                ", xKryptis=" + xKryptis +
                ", yKryptis=" + yKryptis +
                ", greitis=" + greitis +
                '}';
    }

    public void erase() {

    }
}
