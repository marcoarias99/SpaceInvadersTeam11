package objects;

public class Bomb extends GameObject {
    public static final float WIDTH = 10.0f;
    public static final float HEIGHT = 10.0f;
    public static final float DROP_SPEED = 200.0f;
    private float bulletSpeed = DROP_SPEED;

    public Bomb(float x, float y) {
        initBomb(x, y);
    }
    
    public void setSpeed(float speed) {
    	bulletSpeed = speed;
    }

    @Override
    public void update(float deltaTime) {
        getPosition().y += bulletSpeed * deltaTime;
    }

    private void initBomb(float x, float y) {
        getPosition().x = x;
        getPosition().y = y;
    }

	@Override
	public String getImageName() {
		return "resources/shot.gif";
	}
}
