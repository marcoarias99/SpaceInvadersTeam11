package data;

import objects.Alien;

import java.util.ArrayList;

public interface Level {
    void apply(ArrayList<Alien> aliens);
    void update(ArrayList<Alien> aliens);

    /**
     * Returns the next level to play.
     * Return null indicates that the current level is the last level.
     * @return
     */
    Level getNextLevel();
}
