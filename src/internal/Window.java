package internal;

import data.Level1;
import screens.GameScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;

public class Window extends Application {
    public static final String TITLE = "Space Invaders";
    Scene scene;
    GraphicsContext graphics;
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Scene getScene() {
        return scene;
    }

    public GraphicsContext getGraphics() {
        return graphics;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        List<String> args = getParameters().getRaw();
        width = Integer.parseInt(args.get(0));
        height = Integer.parseInt(args.get(1));

        Canvas canvas = new Canvas(width, height);
        graphics = canvas.getGraphicsContext2D();

        Pane root = new Pane();
        root.getChildren().add(canvas);
        scene = new Scene(root, width, height);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Space Invaders");
        primaryStage.show();

        Game game = new Game(this);
        game.setScreen(new GameScreen(game, new Level1()));
        game.startGameLoop();
    }
}
