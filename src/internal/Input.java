package internal;

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
	private boolean mouseJustDown = false;
	private HashMap<KeyCode, Boolean> activeKeys = new HashMap<>();
	private HashMap<KeyCode, Boolean> justPressedKeys = new HashMap<>();

	private EventHandler<KeyEvent> keyDownHandler = event -> {
		activeKeys.put(event.getCode(), true);
		justPressedKeys.put(event.getCode(), true);
	};
	private EventHandler<KeyEvent> keyUpHandler = event -> {
		activeKeys.put(event.getCode(), false);
		justPressedKeys.put(event.getCode(), false);
	};
	private EventHandler<MouseEvent> mouseDownHandler = event -> {
		mousePressed = true;
		mouseJustDown = true;
		mousePosition.x = (float) event.getSceneX();
		mousePosition.y = (float) event.getSceneY();
	};
	private EventHandler<MouseEvent> mouseUpHandler = event -> {
		mousePressed = false;
		mouseClicked = true;
		mouseJustDown = false;
	};

	/**
	 * Returns whether or not a key is pressed
	 *
	 * @param keyCode The key code
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

	public boolean isMousePressed() {
		return mousePressed;
	}

	public boolean isMouseClicked() {
		return mouseClicked;
	}
	
	public boolean isMouseJustDown() {
		if (mouseJustDown) {
			mouseJustDown = false;
			return true;
		}
		return false;
	}

	public Vector2 getMousePosition() {
		return mousePosition;
	}

	public boolean isKeyJustPressed(KeyCode p) {
		boolean b = justPressedKeys.getOrDefault(p, false);
		justPressedKeys.put(p, false);
		return b;
	}
}
