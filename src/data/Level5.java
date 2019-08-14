package data;

//Imports aliens, bomb and the screen for Level 5
import objects.Alien;
import objects.Alien2;
import objects.Bomb;
import screens.GameScreen;

public class Level5 implements Level {
    public static float ALIEN_SPACING = 7.0f;
    @Override
    public void apply(GameScreen gameScreen) {
        //Create aliens
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                float offsetX = Alien.WIDTH + ALIEN_SPACING;
                float offsetY = Alien.HEIGHT + ALIEN_SPACING;
                Alien alien = new Alien2(150.0f + offsetX * (float) j, 5.0f + offsetY * (float) i);
                
                alien.getSize().set(Alien.WIDTH, Alien.HEIGHT);
                alien.setMovementSpeed(50.0f);
                gameScreen.addAlien(alien);
            }
        }
    }

    @Override
    public void update(GameScreen gameScreen) {
    	int alienCount = gameScreen.getAlienCount();
        float bombSpawnChance = 2.7f;
        if (Math.random() * 100.0f <= bombSpawnChance && alienCount > 0) {
        	int randomIndex = (int)((float) Math.random() * (float) alienCount);
            Bomb b = gameScreen.getAlien(randomIndex).getNewBomb();
            gameScreen.addBomb(b);
        }
    }

    @Override
    //Getter for next level, updates and proceeds to level 6 if level 5 has been won...
    public Level getNextLevel() {
        return new Level6();
    }

	@Override
	//Getter for expected time, sets it as 25 seconds for level 5
	public int getExpectedTime() {
		
		return 25;
	}
}
