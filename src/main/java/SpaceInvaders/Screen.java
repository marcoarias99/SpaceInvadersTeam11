package SpaceInvaders.internal;

import javafx.scene.canvas.GraphicsContext;

public interface Screen {
    void create();
    void update(float deltaTime);
    void render(GraphicsContext g);
    void dispose();
}