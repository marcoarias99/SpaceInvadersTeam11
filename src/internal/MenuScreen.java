package internal;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import levels.Level1;
import screens.GameScreen;

public class MenuScreen implements Screen {

	private Game game;
	private Font main;
	private Font fontBold;
	private Font smallFont;
	private Image outerSpace;
	
	public MenuScreen(Game game) {
		this.game = game;
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		main = Font.font(null, FontWeight.BOLD, 32.0);
		fontBold = Font.font(null, FontWeight.BOLD, 64.0);
		smallFont = new Font(16.0);
		outerSpace = new Image("resources/OuterSpace.png");
		
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
		g.setFill(Color.WHITE);
		g.fillText("PLAY", game.getWidth() * 0.25f, game.getHeight() * 0.6f);
		g.fillText("CHOOSE LEVEL", game.getWidth() * 0.65f, game.getHeight() * 0.6f);
		
		g.setFont(smallFont);
		g.fillText("Instructions:", game.getWidth() * 0.5f, game.getHeight() * 0.7f);
		g.fillText("Press Left or Right to move the Spaceship", game.getWidth() * 0.5f, game.getHeight() * 0.75f);
		g.fillText("Press Space to Shoot", game.getWidth() * 0.5f, game.getHeight() * 0.8f);
		g.fillText("Press P to Pause", game.getWidth() * 0.5f, game.getHeight() * 0.85f);
		
		g.setFill(Color.GREEN);
		g.setFont(fontBold);
		g.fillText("GALAXY FIGHTERS", game.getWidth() * 0.5f, game.getHeight() * 0.3f);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	private void handleInput() {
		if (game.getInput().isMouseJustDown()) {
			if (game.getInput().getMousePosition().x < game.getWidth() / 2.0f ) {
				game.setScreen(new GameScreen(game, new Level1()));
			} else {
				game.setScreen(new ChooseLevelScreen(game));
			}
		}
	}

}
