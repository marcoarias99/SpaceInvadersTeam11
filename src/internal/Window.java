package internal;

import data.Level1;
import data.Level2;
import screens.GameScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;

public class Window extends Application {
    public static final String TITLE = "Galaxy Fighters";
package internal;

import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import screens.GameScreen;
//JavaFx Imports

/*
Windows class allows the openning of the file and the Data which 
will be shown from the windows thanks to JavaFx import Application

This class has basic information about what the window will look like 
realting to it width and height.
*/
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


    //Basic infomation about parmeters that will be set opening the canvas
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

        // Name that will appear on the top center when windows opens 
        primaryStage.setScene(scene);
        primaryStage.setTitle("Space Invaders");
        //Allows canvas to be opened
        primaryStage.show();

        Game game = new Game(this);
        game.setScreen(new MenuScreen(game));
        game.startGameLoop();
    }
}
