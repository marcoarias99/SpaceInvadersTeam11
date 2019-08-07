package SpaceInvaders.objects;

public class Bomb extends Enemy {
    public static final float WIDTH = 10.0f;
    public static final float HEIGHT = 10.0f;
    public static final float DROP_SPEED = 140.0f;

    public Bomb(float x, float y) {
        initBomb(x, y);
    }

    @Override
    public void update(float deltaTime) {
        getPosition().y += DROP_SPEED * deltaTime;
    }

    private void initBomb(float x, float y) {
        getPosition().x = x;
        getPosition().y = y;
    }
}
