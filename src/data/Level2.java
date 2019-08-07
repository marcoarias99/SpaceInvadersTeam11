package data;

import objects.Alien;
import objects.Alien2;

import java.util.ArrayList;

public class Level2 implements Level {
	public static float ALIEN_SPACING = 7.0f;
    @Override
    public void apply(ArrayList<Alien> aliens) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                float offsetX = Alien.WIDTH + ALIEN_SPACING;
                float offsetY = Alien.HEIGHT + ALIEN_SPACING;
                Alien alien;
                
                
                if (i < 2) {
                	alien = new Alien(150.0f + offsetX * (float) j, 5.0f + offsetY * (float) i);
                } else {
                	alien = new Alien2(150.0f + offsetX * (float) j, 5.0f + offsetY * (float) i);
                }
                
                
                alien.getSize().set(Alien.WIDTH, Alien.HEIGHT);
                aliens.add(alien);
            }
        }
    }

    @Override
    public void update(ArrayList<Alien> aliens) {
        float bombSpawnChance = 0.8f;
        if (Math.random() * 100.0f <= bombSpawnChance && aliens.size() > 0) {
            aliens.get((int)((float) Math.random() * (float) aliens.size())).spawnBomb();
        }
    }

    @Override
    public Level getNextLevel() {
        return null;
    }
}
