package Ext;

import Main.Game;

import java.awt.*;

public class Paddle implements Cloneable {

    public int x, y;
    private int kryptis = 0;
    public int greitis = 10;
    public int taskai;
    public int width = 22, height = 85; //extendinti greita rakete ir leta rakete
    public Color spalva;
    public boolean kaire;
    public int acceleration = 0;
    PaddleFields a = new PaddleFields(x, y);

    public Paddle(boolean kair){
        spalva = Color.white;
        kaire = kair;
        taskai = 0;
        //priklausant nuo to ar rakete kairine ar desinine, nustatoma jos pradine vieta
        if(kair){
            x = 0;
        }
        else{
            x = Game.PLOTIS - this.width;
        }
        y = Game.AUKSTIS/2 - this.height /2;
    }

    final public void draw(Graphics g) {
        g.setColor(spalva);
        g.fillRect(x, y, width, height);

        g.setColor(Color.gray);
        int taskuX; //skaiciaus vieta x asyje, kad jis visada butu lygiuotas
        String taskuZodis = Integer.toString(taskai);
        Font stilius = new Font("Roboto", Font.PLAIN, 50); //teksto stilius taskams

        int zodzioPlotis = g.getFontMetrics(stilius).stringWidth(taskuZodis) + 1;
        int nuotolis = 25; //atstumas nuo vidurio linijos iki skaiciu

        if(kaire){
            taskuX = Game.PLOTIS / 2 - nuotolis - zodzioPlotis;
        }
        else{
            taskuX = Game.PLOTIS / 2 + nuotolis; //nustatoma tasku zenklo vieta
        }
        g.setFont(stilius);
        g.drawString(taskuZodis, taskuX, 50);
    }

    public void pridetiTaska() {
        taskai++;
    }

    public Object clone() throws CloneNotSupportedException {
        //try {
            Paddle cloned = (Paddle) super.clone();
            //cloned.a = new PaddleFields(x, y);
            return cloned;
        /*}
        catch (CloneNotSupportedException e) {
            throw new Error (e.getMessage());
        }*/
    }
}
