package levels;

import objects.Alien;
import objects.Bomb;
import screens.GameScreen;

public class Level1 implements Level {
    public static float ALIEN_SPACING = 7.0f;
    @Override
    public void apply(GameScreen gameScreen) {
        // Create aliens
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                float offsetX = Alien.WIDTH + ALIEN_SPACING;
                float offsetY = Alien.HEIGHT + ALIEN_SPACING;
                Alien alien = new Alien(150.0f + offsetX * (float) j, 5.0f + offsetY * (float) i);
                alien.getSize().set(Alien.WIDTH, Alien.HEIGHT);
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
    public Level getNextLevel() {
        return new Level2();
    }

	public int getExpectedTime() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getCurrentLevel() {
		// TODO Auto-generated method stub
		return 1;
	}
}
