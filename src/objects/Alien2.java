package objects;

public class Alien2 extends Alien {
	/*
	Red Alien class
	Second enemy for player which will apear after level 3
	x and y coordinates for Aliens movements
	*/
	public Alien2(float x, float y) {
		super(x, y);
	}

	/*
	Overide method used with deltaTime to be able allow Red alien to 
	update its position inside the game.

	Also allowing Alien shoot and the bombs velocity
	*/
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
	


	/*
	png file which allow the apperance of alien 2 on code
	Location of image: Resources File

	Amount of point that will be added to the score bored 
	after one of this aliens is destroyed
	*/
	@Override
	public String getImageName() {
		return "resources/alien77.png";
	}
	
	@Override
	public int getPoints() {
		return 30;
	}
	
}
