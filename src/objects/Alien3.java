package objects;

public class Alien3 extends Alien {

	public Alien3(float x, float y) {
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
		b.setSpeed(575.0f);
		return b;
	}
	
	@Override
	public String getImageName() {
		return "resources/alien79.png";
	}
	
	@Override
	public int getPoints() {
		return 25;
	}
	
}