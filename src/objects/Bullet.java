package objects;

public class Bullet extends GameObject {
	
	// Instance variables for the speed, width, height of the bullet
	
    public static final float SPEED = 430.0f;
    public static final float WIDTH = 10.0f;
    public static final float HEIGHT = 15.0f;
    
    // Constructor 

    public Bullet(int x, int y) {
        initShot(x, y);
    }
    
    // Updates the position

    @Override
    public void update(float deltaTime) {
        getPosition().y -= SPEED * deltaTime;
    }

    private void initShot(int x, int y) {
        getPosition().set(x, y);
    }
    
    // Getter for the image of the bomb, to display the bomb 

	@Override
	public String getImageName() {
		return "resources/bomb.png";
	}
}
