package objects;

public class Bomb extends GameObject {
	
	// Instance Variables for width, height, drop_speed and bullet speed
	
    public static final float WIDTH = 10.0f;
    public static final float HEIGHT = 10.0f;
    public static final float DROP_SPEED = 200.0f;
    private float bulletSpeed = DROP_SPEED;
    
    // Constructor

    public Bomb(float x, float y) {
        initBomb(x, y);
    }
    
    // Setter method for the speed, sets the bulletSpeed equal to the speed
    
    public void setSpeed(float speed) {
    	bulletSpeed = speed;
    }
    
    // Updates the position

    @Override
    public void update(float deltaTime) {
        getPosition().y += bulletSpeed * deltaTime;
    }

    private void initBomb(float x, float y) {
        getPosition().x = x;
        getPosition().y = y;
    }
    
    // Getter for the image for the bomb, so it can display the gif of the bomb

	@Override
	public String getImageName() {
		return "resources/shot.gif";
	}
}
