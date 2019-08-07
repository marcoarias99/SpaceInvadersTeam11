package objects;

import internal.Game;
import javafx.scene.input.KeyCode;

import static screens.GameScreen.MARGIN_X;

public class Player extends GameObject {
    public static final float WIDTH = 30.0f;
    public static final float HEIGHT = 25.0f;
    public static final float MOVEMENT_SPEED = 200.0f;

    public Player() {
    }

    @Override
    public void update(float deltaTime) {
        if (Game.main.getInput().isKeyPressed(KeyCode.LEFT)) {
            position.x -= MOVEMENT_SPEED * deltaTime;
        } else if (Game.main.getInput().isKeyPressed(KeyCode.RIGHT)) {
            position.x += MOVEMENT_SPEED * deltaTime;
        }

        // Limit to within bounds of the screen
        if (position.x + size.width / 2.0f < MARGIN_X) {
            position.x = MARGIN_X - size.width / 2.0f;
        } else if (position.x + size.width / 2.0f > Game.main.getWidth() - MARGIN_X) {
            position.x = Game.main.getWidth() - MARGIN_X - size.width / 2.0f;
        }
    }
}
