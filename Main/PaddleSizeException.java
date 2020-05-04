package Main;

public class PaddleSizeException extends PaddleException {
    public PaddleSizeException(String message) {
        super(message);
    }
    public PaddleSizeException(String message, int width, int height) {
        super(message, width, height);
    }
}
