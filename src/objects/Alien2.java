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
	public Bomb getNewBomb() {
		Bomb b = super.getNewBomb();
		b.setSpeed(375.0f);
		return b;
	}
	
	@Override
	public String getImageName() {
		return "resources/invader1.png";
	}
	
	@Override
	public int getPoints() {
		return 10;
	}
	
}

