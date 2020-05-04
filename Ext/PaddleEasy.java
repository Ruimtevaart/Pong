package Ext;

import java.awt.*;

public class PaddleEasy extends Paddle{
    public int kiekPadidejo;
    private int puseTasko;
    public PaddleEasy(boolean kair){
        super(kair);
        puseTasko = 0;
        super.greitis = 15;
        super.spalva = Color.red;
    }


    @Override
    public String toString() {
        return "PaddleEasy{" +
                "greitis=" + greitis +
                ", taskai=" + taskai +
                ", spalva=" + spalva +
                '}';
    }
    @Override
    public void pridetiTaska() {
        if (puseTasko == 0){
            puseTasko = 1;
        }
        else {
            super.taskai++;
            puseTasko = 0;
        }
    }
}
