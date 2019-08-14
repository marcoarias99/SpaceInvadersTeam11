package levels;

import screens.GameScreen;

public interface Level {
	
	int getExpectedTime();
    void apply(GameScreen gameScreen);
    void update(GameScreen gameScreen);
    int getCurrentLevel();

    /**
     * Returns the next level to play.
     * Return null indicates that the current level is the last level.
     * @return
     */
    Level getNextLevel();
}
