package data;

import objects.Alien;

import java.util.ArrayList;

public class Level2 implements Level {
    public static float ALIEN_SPACING = 7.0f;
    @Override
    public void apply(ArrayList<Alien> aliens) {

        Alien alien = new Alien(200.0f, 200.0f);
        alien.getSize().set(100.0f, 100.0f); // BIG FAT PLACEHOLDER ALIEN
        aliens.add(alien);
    }

    @Override
    public void update(ArrayList<Alien> aliens) {
    }

    @Override
    public Level getNextLevel() {
        return null;
    }
}
