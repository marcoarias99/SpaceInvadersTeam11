package internal;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Game {
	//Setting instance variables.
    public static Game main;
    private Window window;
    private Input input;
    private Screen screen;
    
    //Constructor
    public Game(Window window) {
        this.window = window;
        input = new Input();
        input.registerWindowInputs(window);
        main = this;
    }
    
    //Getter for input
    public Input getInput() {
        return input;
    }
    
    //Setter for screen
    public void setScreen(Screen newScreen) {
        if (screen != null) screen.dispose();
        screen = newScreen;
        screen.create();
    }
    
    //Getter for width
    public float getWidth() {
        return window.getWidth();
    }
    
    //Getter for height
    public float getHeight() {
        return window.getHeight();
    }
    
    //This method generates the animation and starts the game loop
    void startGameLoop() {
        new AnimationTimer() {
            private long prev = System.nanoTime();

            @Override
            //This implements the Java FX Animation Timer handler
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
