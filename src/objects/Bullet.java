package objects;

public class Bullet extends GameObject {
    public static final float SPEED = 430.0f;
    public static final float WIDTH = 10.0f;
    public static final float HEIGHT = 15.0f;

    public Bullet(int x, int y) {
        initShot(x, y);
    }

    @Override
    public void update(float deltaTime) {
        getPosition().y -= SPEED * deltaTime;
    }

    private void initShot(int x, int y) {
        getPosition().set(x, y);
    }

	@Override
	public String getImageName() {
		return "resources/bullet.png";
	}
}
