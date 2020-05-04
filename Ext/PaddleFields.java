package Ext;

public class PaddleFields {
    int x, y;
    public PaddleFields(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
