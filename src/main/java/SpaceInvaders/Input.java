package SpaceInvaders.internal;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;

public class Input {
    private Vector2 mousePosition = new Vector2();
    private boolean mousePressed = false;
    private boolean mouseClicked = false;
    private HashMap<KeyCode, Boolean> activeKeys = new HashMap<>();

    private EventHandler<KeyEvent> keyDownHandler = event -> activeKeys.put(event.getCode(), true);
    private EventHandler<KeyEvent> keyUpHandler = event -> activeKeys.put(event.getCode(), false);
    private EventHandler<MouseEvent> mouseDownHandler = event -> mousePressed = true;
    private EventHandler<MouseEvent> mouseUpHandler = event -> {
        mousePressed = false;
        mouseClicked = true;
    };

    /**
     * Returns whether or not a key is pressed
     *
     * @param keyCode The key code, defined in {@link java.awt.event.KeyEvent}
     * @return true if the key is pressed, false otherwise
     */
    public boolean isKeyPressed(KeyCode keyCode) {
        return activeKeys.getOrDefault(keyCode, false);
    }

    void registerWindowInputs(Window window) {
        Scene scene = window.getScene();
        scene.setOnKeyPressed(keyDownHandler);
        scene.setOnKeyReleased(keyUpHandler);
        scene.setOnMousePressed(mouseDownHandler);
        scene.setOnMouseReleased(mouseUpHandler);
    }

    void prepareNextFrame() {
        mouseClicked = false;
    }
}
