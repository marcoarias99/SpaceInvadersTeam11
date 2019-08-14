package objects;

public class Alien3 extends Alien {

	public Alien3(float x, float y) {
		super(x, y);
		
	}

	@Override
	public void update(float deltaTime) {
		super.update(deltaTime);
		
		
	}
	
	@Override
	public Bomb getNewBomb() {
		Bomb b = super.getNewBomb();
		b.setSpeed(600.0f);
		return b;
	}
	
	@Override
	//Getter for the image, so that it can be imported for Alien #3 and Alien #3 can be displayed
	public String getImageName() {
		return "resources/alien77.png";
	}
	
	@Override
	public int getPoints() {
		return 25;
	}
	
}