package data;

import objects.Alien;
import objects.Alien2;
import objects.Alien3;
import objects.Bomb;
import screens.GameScreen;

public class Level7 implements Level {
	public static float ALIEN_SPACING = 7.0f;
    @Override
    public void apply(GameScreen gameScreen) {
    	//Creating aliens
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                float offsetX = Alien.WIDTH + ALIEN_SPACING;
                float offsetY = Alien.HEIGHT + ALIEN_SPACING;
                Alien alien;
                
                if (
                	(i == 0 || i == 4) && j == 4 ||
                    (i == 2 && (j == 0 || j == 4 || j == 8))) {
                    alien = new Alien3(150.0f + offsetX * (float) j, 5.0f + offsetY * (float) i);
                } else if (
                	(i == 0 || i == 4 && (j <= 3 || j >= 5)) ||
                	((i == 1 || i == 3) && (j == 0 || j == 4 || j == 8)) ||
                	(i == 2 && ((j >= 1 && j <= 3) || (j >= 5 && j <= 7)))
                	) {
                	alien = new Alien2(150.0f + offsetX * (float) j, 5.0f + offsetY * (float) i);
                } else {
                	alien = new Alien(150.0f + offsetX * (float) j, 5.0f + offsetY * (float) i);
                }
                
                
                alien.getSize().set(Alien.WIDTH, Alien.HEIGHT);
                alien.setMovementSpeed(55.0f);
                gameScreen.addAlien(alien);
            }
        }
    }

    @Override
    public void update(GameScreen gameScreen) {
    	 int alienCount = gameScreen.getAlienCount();
         float bombSpawnChance = 2.2f;
         if (Math.random() * 100.0f <= bombSpawnChance && alienCount > 0) {
         	int randomIndex = (int)((float) Math.random() * (float) alienCount);
             Bomb b = gameScreen.getAlien(randomIndex).getNewBomb();
             gameScreen.addBomb(b);
         }
    }

    @Override
  //Getter for next level, updates and proceeds to level 7 if level 6 has been won...
    public Level getNextLevel() {
        return new Level8();
    }

	@Override
	public int getExpectedTime() {
		//Getter for expected time, sets it as 30 seconds for level 7
		return 30;
	}
}
