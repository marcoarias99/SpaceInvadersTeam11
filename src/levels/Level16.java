package levels;

import objects.Alien;
import objects.Alien2;
import objects.Alien3;
import objects.Alien4;
import objects.Alien5;
import objects.Bomb;
import screens.GameScreen;

public class Level16 implements Level {
    public static float ALIEN_SPACING = 0.01f;
    @Override
    public void apply(GameScreen gameScreen) {
        // Create aliens
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 27; j++) {
                float offsetX = Alien.WIDTH + ALIEN_SPACING;
                float offsetY = Alien.HEIGHT + ALIEN_SPACING;
                
                Alien alien;
                
                if (
                	(j == 0 && i <= 4) ||
                	((i == 0 || i == 4) && (j == 1 || j == 2)) || 
                	(j == 4 && i <= 4) || 
                	((i == 0 || i == 2) && (j >= 5 && j <= 6)) || 
                	(i == 1 && j == 6) ||
                	((i == 0 || i == 2 || i == 4) && (j >= 8 && j <= 10)) ||
                	(i == 1 && j == 8) || (i == 3 && j == 10) ||
                	(j == 12 && i <= 4) ||
                	((i == 0 || i == 4) && (j == 13 || j == 14))
                	) {
                	alien = new Alien2(0.0f + offsetX * (float) j, 0.0f + offsetY * (float) i);
                } else if (
                	(i == 5 && j <= 2) ||
                	(i >= 6 && j == 1) || 
                	(i >= 5 && j == 4) ||
                	((i == 5 || i == 7 || i == 9) && (j == 5 || j == 6)) ||
                	(i >= 5 && (j == 8 || j == 10)) ||
                	((i == 5 || i == 7) && (j == 9)) ||
                	(i >= 5 && (j == 12 || j == 16)) ||
                	(i == 6 && (j == 13 || j == 15)) ||
                	(i == 7 && j == 14)) 
                	 {
                	alien = new Alien4(0.0f + offsetX * (float) j, 0.0f + offsetY * (float) i);
                } else if (
                		(i >= 5 && (j == 21 || j == 25)) ||
                    	(i == 6 && (j == 20 || j == 24)) ||
                    	(i == 9 && ((j >= 20 && j <= 22) || (j >= 24 && j <= 27)))
                    	) {
                	alien = new Alien5(0.0f + offsetX * (float) j, 0.0f + offsetY * (float) i);
                } else if (
                		(i == 0 || i == 2 || i == 4) && (j >= 16 && j <= 18) ||
                		(i == 1 && j == 18) || (i == 3 && j == 16) ||
                		((i == 0 || i == 2 || i == 4) && (j == 20 || j == 21 || j == 24 || j == 25)) ||
                		(j == 22 && i <= 4)|| (j == 26) && i <= 4) {
                	alien = new Alien3(0.0f + offsetX * (float) j, 0.0f + offsetY * (float) i);
                } else {
                	alien = new Alien(0.0f + offsetX * (float) j, 0.0f + offsetY * (float) i);
                }
                
                
                alien.getSize().set(Alien.WIDTH, Alien.HEIGHT);
                alien.setMovementSpeed(0.0f);
                gameScreen.addAlien(alien);
                
                gameScreen.setBulletSpeed(0.001f);
            }
        }
    }

    @Override
    public void update(GameScreen gameScreen) {
    	int alienCount = gameScreen.getAlienCount();
        float bombSpawnChance = 0.0f;
        if (Math.random() * 100.0f <= bombSpawnChance && alienCount > 0) {
        	int randomIndex = (int)((float) Math.random() * (float) alienCount);
            Bomb b = gameScreen.getAlien(randomIndex).getNewBomb();
            gameScreen.addBomb(b);
        }
    }

    @Override
    public Level getNextLevel() {
        return null;
    }

	@Override
	public int getExpectedTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurrentLevel() {
		// TODO Auto-generated method stub
		return 16;
	}
}
