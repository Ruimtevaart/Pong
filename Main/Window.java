package Main;

import javax.swing.*;

public class Window {
    public Window(String Pavadinimas, Game zaidimas)
    {
        JFrame Langas = new JFrame(Pavadinimas);
        Langas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //nustatoma, kad vartotojas negaletu keisti lango dydzio
        Langas.setResizable(false);
        //pridedami zaidimo komponentai i langa
        Langas.add(zaidimas);
        //nustatomas lango dydis
        Langas.pack();
        //langas padedamas viduryje ekrano
        Langas.setLocationRelativeTo(null);
        //rodomas langas
        Langas.setVisible(true);
        //paleidziamas zaidimas
        zaidimas.start();
    }
}
