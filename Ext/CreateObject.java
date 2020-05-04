package Ext;

public class CreateObject implements PaddleFactory {
    public Paddle createPaddle(String type, boolean left) {
        switch (type) {
            case "hard":
                return new PaddleHard(left);
            case "easy":
                return new PaddleEasy(left);
            default:
                return new Paddle(left);
        }
    }
}
