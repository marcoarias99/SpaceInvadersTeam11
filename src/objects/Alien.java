package objects;

import internal.Game;

public class Alien extends GameObject {
    public static final float WIDTH = 22.0f;
    public static final float HEIGHT = 36.0f;
    private float movement_speed = 40.0f;
    private Direction direction = Direction.RIGHT;
    private Bomb bomb;

    public Alien(float x, float y) {
        initAlien(x, y);
    }

    @Override
    public void update(float deltaTime) {
        position.x += movement_speed * deltaTime * direction.value;
        updateBomb(deltaTime, Game.main);
    }

    private void updateBomb(float deltaTime, Game game) {
        if (bomb != null) {
            bomb.update(deltaTime);
            if (bomb.getPosition().y > game.getHeight()) {
                bomb = null;
            }
        }
    }

    private void initAlien(float x, float y) {
        getPosition().set(x, y);
    }

    public void spawnBomb() {
        bomb = new Bomb(getPosition().x, getPosition().y);
        bomb.getSize().set(Bomb.WIDTH, Bomb.HEIGHT);
    }

    public Bomb getBomb() {
        return bomb;
    }

    public Direction getDirection() {
        return direction;
    }

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
    
    public void addMovementSpeed(float f) {
    	movement_speed += f;
    }

	@Override
	public String getImageName() {
		return "resources/alien.png";
	}
	
	public int getPoints() {
		return 5;
	}
}
