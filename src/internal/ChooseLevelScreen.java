package internal;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import screens.GameScreen;
import data.*;

public class ChooseLevelScreen implements Screen {

	private Game game;
	private Font main;
	private Image outerSpace;
	private Image exitImage;
	
	private Rectangle exitImageRect;
	
	ArrayList<LevelRect> rectangles = new ArrayList<LevelRect>();
	
	public ChooseLevelScreen(Game game) {
		this.game = game;
	}
	
	
	
	@Override
	public void create() {
		float startX = game.getWidth() * 0.15f;
		float startY = game.getHeight() * 0.2f;
		float colDistance = game.getWidth() * 0.15f;
		float rowDistance = game.getHeight() * 0.15f;
		
		exitImageRect = new Rectangle(0, game.getHeight() - 50.0f, 50.0f, 50.0f);
		
		// TODO Auto-generated method stub
		main = Font.font(null, FontWeight.BOLD, 52.0);
		outerSpace = new Image("resources/OuterSpace.png");
		exitImage = new Image("resources/exit.png");
		for (int i = 0; i < 16; i++) {
			float x = startX + (i % 5) * colDistance;
			float y = startY + ((int) (i / 5.0f)) * rowDistance;
			LevelRect l = new LevelRect(x, y, 50.0f, 50.0f);
			l.setLevel(i+1);
			rectangles.add(l);
		}

	}

	@Override
	public void update(float deltaTime) {
		// TODO Auto-generated method stub
		handleInput();
		
	}

	@Override
	public void render(GraphicsContext g) {
		
		// TODO Auto-generated method stub
		g.drawImage(outerSpace, 0, 0);
		g.setTextAlign(TextAlignment.CENTER);
		g.setFont(main);
		for (int i = 1; i <= 15; i++) {
			Rectangle r = rectangles.get(i-1);
			float x = r.x + r.width / 2.0f;
			float y = r.y + 50;
			g.setFill(Color.ORANGE);
			g.fillText(String.valueOf(i), x, y);
			
		}
		g.drawImage(exitImage, exitImageRect.x, exitImageRect.y, exitImageRect.width, exitImageRect.height);
		
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	public void handleInput() {
		
		if (game.getInput().isMouseJustDown()) {
			for (LevelRect rect: rectangles) {
				if (rect.isPointInside(game.getInput().getMousePosition().x, game.getInput().getMousePosition().y)) {
					game.setScreen(new GameScreen(game, rect.getLevel()));
				}
			}
			if (exitImageRect.isPointInside(game.getInput().getMousePosition().x, game.getInput().getMousePosition().y)) {
				game.setScreen(new MenuScreen(game));
			}
		}
	}

}
