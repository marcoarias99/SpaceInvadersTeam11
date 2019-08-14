package objects;

public class Alien extends GameObject {
	
	// Instance variables for the width, height, movement speed, direction of Alien 1
	
    public static final float WIDTH = 22.0f;
    public static final float HEIGHT = 36.0f;
    private float movement_speed = 40.0f;
    private Direction direction = Direction.RIGHT;
    
    // Constructor

    public Alien(float x, float y) {
        initAlien(x, y);
    }
    
    //  Updates the position of Alien 1

    @Override
    public void update(float deltaTime) {
        position.x += movement_speed * deltaTime * direction.value;
    }
    
    private void initAlien(float x, float y) {
        getPosition().set(x, y);
    }
    
    // Generates bombs for Alien 1

    public Bomb getNewBomb() {
        Bomb bomb = new Bomb(getPosition().x, getPosition().y);
        bomb.getSize().set(Bomb.WIDTH, Bomb.HEIGHT);
        return bomb;
    }
    
    // Getter for the instance variable direction

    public Direction getDirection() {
        return direction;
    }
    
    // Setter for the instance variable direction

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public enum Direction {
        LEFT(-1), RIGHT(1);

        int value;

        Direction(int value) {
            this.value = value;
        }
    }
    
    // Adds the movement speed of Alien 1
    
    public void addMovementSpeed(float f) {
    	movement_speed += f;
    }
    
    // Setter method for the movement speed of Alien 1
    
    public void setMovementSpeed(float f) {
    	movement_speed = f;
    }

    // Getter for the image, so that it can be imported for Alien 1, and displays it
	@Override
	public String getImageName() {
		return "resources/invader2.png";
	}
	
	// Getter for the points, indicates every time alien 1 is killed it returns 5 points 
	
	public int getPoints() {
		return 5;
	}
}
