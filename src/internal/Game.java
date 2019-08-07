package internal;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Game {
    public static Game main;
    private Window window;
    private Input input;
    private Screen screen;

    public Game(Window window) {
        this.window = window;
        input = new Input();
        input.registerWindowInputs(window);
        main = this;
    }

    public Input getInput() {
        return input;
    }

    public void setScreen(Screen newScreen) {
        if (screen != null) screen.dispose();
        screen = newScreen;
        screen.create();
    }

    public float getWidth() {
        return window.getWidth();
    }

    public float getHeight() {
        return window.getHeight();
    }

    void startGameLoop() {
        new AnimationTimer() {
            private long prev = System.nanoTime();

            @Override
            public void handle(long now) {
                float diff = (now - prev) / 1000000000.0f;
                diff = Math.min(diff, 1.0f/30.0f);
                step(diff);
                prev = now;
            }
        }.start();
    }

    void step(float deltaTime) {
        if (screen == null) {
            throw new RuntimeException("Screen is null! Did you forget to call #setScreen(...)?");
        }
        input.prepareNextFrame();
        screen.update(deltaTime);

        GraphicsContext graphics = window.getGraphics();

        // Clear the background
        Paint paint = graphics.getFill();
        graphics.setFill(Color.BLACK);
        graphics.fillRect(0, 0, window.getWidth(), window.getHeight());
        graphics.setFill(paint);

        screen.render(graphics);
    }
}
