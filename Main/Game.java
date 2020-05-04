package Main;

import Ext.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final int PLOTIS = 1000;
    public static final int AUKSTIS = PLOTIS * 9/16;

    public boolean paleistas = false;
    private Thread zaidimothreadas;

    private Ball kamuoliukas;
    private Paddle raketeK;
    private Paddle raketeD;

    public static void main(String args[])
    {
        new Game();
    }

    public Game ()
    {
        parengimaspiesimui();
        createObjects();
        new Window("Pong!", this);
    }

    public static int sign(double d) {
        if (d <= 0){
            return -1;
        }
        return 1;
    }

    private void createObjects() {
        kamuoliukas = new Ball();

        PaddleFactory create = new CreateObject();
        raketeK = create.createPaddle("easy", true);
        raketeD = create.createPaddle("hard", false);

        raketeK = new Paddle(true);
        try {
            raketeK.kaire = false;
            raketeK.x = PLOTIS - raketeK.width;
            raketeD = (Paddle) raketeK.clone();
            raketeK.kaire = true;
            raketeK.x = 0;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private void parengimaspiesimui() {
        //nustatomas lango dydis
        this.setPreferredSize(new Dimension(PLOTIS, AUKSTIS));
        this.setMaximumSize(new Dimension(PLOTIS, AUKSTIS));
        this.setMinimumSize(new Dimension(PLOTIS, AUKSTIS));
    }

    @Override
    public void run() {
        //game loop
        this.requestFocus();

        // game timer
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (paleistas) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                update();
                delta--;
                draw();
                frames++;
            }
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        sustabdyti();
    }

    private void update() {
        //funkcija skirta ivykdyti objektu judejima
        kamuoliukas.update(raketeK, raketeD);
    }

    private void draw() {
        BufferStrategy buffer = this.getBufferStrategy();
        if(buffer == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = buffer.getDrawGraphics();

        nupiestiFona(g);

        kamuoliukas.draw(g);

        raketeK.draw(g);
        raketeD.draw(g);

        g.dispose();
        buffer.show();
    }

    private void nupiestiFona(Graphics g) {
        //nustato juoda fona
        g.setColor(Color.black);
        g.fillRect(0,0, PLOTIS, AUKSTIS); //uzpildo visa ekrana juoda spalva
        //nupiesia bruksniuota linija vidury lango
        g.setColor(Color.white);
        Graphics2D g2d = (Graphics2D) g;
        Stroke bruksniuota = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 10 }, 0);
        g2d.setStroke(bruksniuota);
        g2d.drawLine(PLOTIS/2,0, PLOTIS/2, AUKSTIS);

    }

    public void sustabdyti() {
        try {
            zaidimothreadas.join();
            paleistas = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        zaidimothreadas = new Thread(this);
        zaidimothreadas.start();
        paleistas = true;
    }
}
