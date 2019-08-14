package internal;

import javafx.scene.canvas.GraphicsContext;

public interface Screen {
	//Deals with the creation of the main screen
    void create();
    void update(float deltaTime);
    void render(GraphicsContext g);
    void dispose();
}
