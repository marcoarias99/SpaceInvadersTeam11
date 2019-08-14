package data;

import screens.GameScreen;

public interface Level {
	
	// Instance variable for level
	
	int getExpectedTime();
    void apply(GameScreen gameScreen);
    void update(GameScreen gameScreen);

    /**
     * Returns the next level to play.
     * Return null indicates that the current level is the last level.
     * @return
     */
    Level getNextLevel();
}
