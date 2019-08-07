package objects;

public class Bullet extends GameObject {
    public static final float SPEED = 140.0f;
    public static final float WIDTH = 10.0f;
    public static final float HEIGHT = 15.0f;

    public Bullet(int x, int y) {
        super();
        initShot(x, y);
    }

    @Override
    public void update(float deltaTime) {
        getPosition().y -= SPEED * deltaTime;
    }

    private void initShot(int x, int y) {
        getPosition().set(x, y);
    }
}
