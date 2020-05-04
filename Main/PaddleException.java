package Main;

public class PaddleException extends Exception {
    public int height, width;
    public PaddleException(String message, int width, int height) {
        super(message);
        this.height = height;
        this.width = width;
        System.out.println("Paddle height: " + height + ", width: " + width);
    }
    public PaddleException(String message) {
        super(message);
    }
}
