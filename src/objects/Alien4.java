package objects;

public class Alien4 extends Alien {

	public Alien4(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		
		
	}
	
	@Override
	public Bomb getNewBomb() {
		Bomb b = super.getNewBomb();
		b.setSpeed(200.0f);
		return b;
	}
	
	@Override
	public String getImageName() {
		return "resources/images.png";
	}
	
	@Override
	public int getPoints() {
		return 50;
	}
	
}

