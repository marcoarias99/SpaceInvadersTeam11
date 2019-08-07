package internal;

public class Size {
    public float width, height;

    public Size(float sX, float sY) {
        set(sX, sY);
    }

    public Size() {
        set(0.0f, 0.0f);
    }

    public void set(float sX, float sY) {
        width = sX;
        height = sY;
    }
}
