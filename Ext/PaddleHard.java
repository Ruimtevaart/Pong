package Ext;

import Main.PaddleSizeException;

import java.awt.*;

public class PaddleHard extends Paddle {
    public int shrinkScore;
    public int aukstis = 85;
    public PaddleHard(boolean kair){
        super(kair);
        super.greitis = 5;
        shrinkScore = 0;
        super.spalva = Color.blue;
    }

    @Override
    public String toString() {
        return "PaddleHard{" +
                "greitis=" + greitis +
                ", taskai=" + taskai +
                ", spalva=" + spalva +
                '}';
    }
    @Override
    public void pridetiTaska() {
        super.taskai+=2;
        try {
            sumazintiDydi();
        } catch (PaddleSizeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sumazintiDydi() throws PaddleSizeException { //kiekviena karta kai gaunamas taskas, raketes dydis (aukstis) sumazinamas 1 pikseliu
        if ((super.height - 2) <= 0)
        {
            throw new PaddleSizeException("Paddle dimensions cannot be negative values. Current height: " + super.height + ", width: " + super.width, super.height, super.width);
        }
        super.height -=2;
        shrinkScore++;
    }
}
