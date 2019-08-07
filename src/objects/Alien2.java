package objects;

public class Alien2 extends Alien {

	public Alien2(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		
		
	}
	
	@Override
	public void spawnBomb() {
		super.spawnBomb();
		getBomb().setSpeed(500.0f);
	}
	
	@Override
	public String getImageName() {
		return "resources/alien.png";
	}
	
}
