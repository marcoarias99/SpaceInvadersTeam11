package screens;

import java.util.ArrayList;

import data.GameData;
import internal.Game;
import internal.MenuScreen;
import internal.Rectangle;
import internal.Screen;
import internal.Vector2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import levels.Level;
import levels.Level1;
import objects.Alien;
import objects.Bomb;
import objects.Bullet;
import objects.Player;

public class GameScreen implements Screen {
	public static final float MARGIN_X = 5.0f;
	public static final float ALIEN_DOWNWARD_Y = 25.0f;
	public static final double PLAY_PAUSE_SIZE = 25.0;

	Game game;
	GameData data;
	Player player;
	Level level;
	ArrayList<Bullet> bullets = new ArrayList<>();
	ArrayList<Bomb> bombs = new ArrayList<>();
	float bulletTime = 0.0f;
	ArrayList<Alien> aliens = new ArrayList<>();
	ArrayList<Bomb> removedBombs = new ArrayList<>();
	ArrayList<Bullet> removedBullets = new ArrayList<>();

	boolean gameEnded = false;
	boolean win = false;
	boolean restarting = false;
	boolean paused = false;

	long startTime;

	int timeBonus;
	int elapsedTime = 0;
	
	float bulletSpawnDelay = 0.5f;

	Font main;
	Font lgFont;
	Font smallFont;
	Image pauseImage;
	Image playImage;
	Image restartImage;
	Image exitImage;
	Image outerSpaceImage;
	Color transparentBlack;
	
	Rectangle quitRect;
	Rectangle restartRect;

	public GameScreen(Game g, Level level) {
		game = g;
		this.level = level;
	}

	@Override
	public void create() {
		data = new GameData();
		player = new Player();
		player.getSize().set(Player.WIDTH, Player.HEIGHT);
		main = new Font(32.0);
		lgFont = Font.font(null, FontWeight.BOLD, 72.0);
		smallFont = new Font(16.0);
		transparentBlack = new Color(0, 0, 0, 0.5);
		pauseImage = new Image("resources/pause-64.png");
		playImage = new Image("resources/play-64.png");
		exitImage = new Image("resources/exit.png");
		restartImage = new Image("resources/Restart.png");
		outerSpaceImage = new Image("resources/OuterSpace.png");
		quitRect = new Rectangle(game.getWidth() * 0.25f, game.getHeight() * 0.5f, 100f, 100f);
		quitRect.x -= quitRect.width / 2.0f;
		quitRect.y -= quitRect.height / 2.0f;
		restartRect = new Rectangle(game.getWidth() * 0.75f, game.getHeight() * 0.5f, 100f, 100f);
		restartRect.x -= restartRect.width / 2.0f;
		restartRect.y -= restartRect.height / 2.0f;
		
		reset();
		level.apply(this);
	}

	public void reset() {
		aliens.clear();
		bullets.clear();
		bombs.clear();
		player.getPosition().set(game.getWidth() / 2.0f - player.getSize().width / 2.0f, game.getHeight() * 0.8f);
		gameEnded = false;
		win = false;
		bulletTime = 0.0f;
		paused = false;
		startTime = System.currentTimeMillis();
		elapsedTime = 0;
	}

	@Override
	public void update(float deltaTime) {
		if (!gameEnded && !paused) {
			updateGameLogic(deltaTime);
		} else {
			if (!restarting && win) {

				restarting = true;
				timeBonus = level.getExpectedTime() - elapsedTime;
				if (timeBonus <= 0) {
					timeBonus = 0;
				}
				data.addScore(timeBonus);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				if (level.getNextLevel() != null) {
					reset();
					level = level.getNextLevel();
					level.apply(this);
					restarting = false;
				}
			}
		}
		if (game.getInput().isMouseJustDown()) {
			Vector2 position = game.getInput().getMousePosition();
			if ((position.x <= PLAY_PAUSE_SIZE && position.y <= PLAY_PAUSE_SIZE)) {
				paused = !paused;
			}
			if (paused) {
				if (quitRect.isPointInside(position.x, position.y)) {
					game.setScreen(new MenuScreen(game));
				}
				if (restartRect.isPointInside(position.x, position.y)) {
					game.setScreen(new GameScreen(game, new Level1()));
				}
			}
			
		}
		if (gameEnded) {
			if (game.getInput().isKeyPressed(KeyCode.SPACE)) {
				game.setScreen(new GameScreen(game, new Level1()));
			}
		}
		if (game.getInput().isKeyJustPressed(KeyCode.P)) {
			paused = !paused;
		}

	}

	@Override
	
	public void render(GraphicsContext g) {
		g.drawImage(outerSpaceImage, 0, 0);
		g.drawImage(player.getImage(), player.getPosition().x, player.getPosition().y, player.getSize().width,
				player.getSize().height);

		for (int i = 0; i < aliens.size(); i++) {
			Alien alien = aliens.get(i);
			g.drawImage(alien.getImage(), alien.getPosition().x, alien.getPosition().y, alien.getSize().width,
					alien.getSize().height);
		}
		for (Bomb b : bombs) {
			g.drawImage(b.getImage(), b.getPosition().x, b.getPosition().y, b.getSize().width, b.getSize().height);
		}
		for (Bullet bullet : bullets) {
			if (bullet != null) {
				g.drawImage(bullet.getImage(), bullet.getPosition().x, bullet.getPosition().y, bullet.getSize().width,
						bullet.getSize().height);
			}
		}

		g.setFont(main);
		g.setFill(Color.WHITE);
		g.setTextAlign(TextAlignment.RIGHT);
		g.fillText("Level " + level.getCurrentLevel(), game.getWidth() * 0.7f, 25);
		g.fillText("Score: " + data.getScore(), game.getWidth() - 5, 25);

		g.setFont(smallFont);
		g.fillText("Enemies killed: " + data.getEnemiesKilled(), game.getWidth() - 5, game.getHeight() - 5);

		g.setTextAlign(TextAlignment.LEFT);
		if (elapsedTime > level.getExpectedTime()) {
			g.setFill(Color.RED);
		} else {
			g.setFill(Color.WHITE);
		}
		g.fillText("Time: " + elapsedTime, 0, game.getHeight() - 5);
		g.setFill(Color.WHITE);

		g.setFont(smallFont);
		g.fillText("Expected Time: " + level.getExpectedTime(), 100, game.getHeight() - 5);

		float accuracy = (float) data.getBulletsHit() / (float) (data.getBulletsHit() + data.getBulletsMissed()) * 100.0f;
		g.fillText(String.format("Accuracy: %.1f", accuracy), 300, game.getHeight() - 5);

		if (!paused) {
			g.drawImage(pauseImage, 0, 0, PLAY_PAUSE_SIZE, PLAY_PAUSE_SIZE);
		}
		if (paused) {
			g.setTextAlign(TextAlignment.CENTER);
			g.setFont(lgFont);
			g.fillText("PAUSED", game.getWidth() * 0.5f, game.getHeight() * 0.25f);
			g.setFill(transparentBlack);
			g.fillRect(0, 0, game.getWidth(), game.getHeight());
			g.drawImage(playImage, 0, 0, PLAY_PAUSE_SIZE, PLAY_PAUSE_SIZE);
			g.drawImage(exitImage, quitRect.x, quitRect.y, quitRect.width, quitRect.height);
			g.drawImage(restartImage, restartRect.x , restartRect.y, restartRect.width, restartRect.height);
		}

		// Draw the result of the game
		if (gameEnded) {
			if (win) {
				g.setTextAlign(TextAlignment.CENTER);
				g.setFont(main);
				g.setFill(Color.WHITE);
				if (level.getNextLevel() == null) {
					g.setFont(lgFont);
					g.fillText("YOU WIN!", game.getWidth() * 0.5f, game.getHeight() * 0.25f);
					drawGameInfo(g);
				} else {
					timeBonus = level.getExpectedTime() - elapsedTime;
					if (timeBonus <= 0) {
						timeBonus = 0;
					}
					g.setFont(main);
					g.fillText("+" + timeBonus + " Time Bonus! Loading next level...", game.getWidth() / 2.0f, game.getHeight() / 2.0f);
				}
			} else {
				g.setFont(lgFont);
				g.setTextAlign(TextAlignment.CENTER);
				g.fillText("Game Over!", game.getWidth() * 0.5f, game.getHeight() * 0.3f);
				drawGameInfo(g);
				g.setFont(smallFont);
				g.fillText("Press Space to Restart", game.getWidth() * 0.5f, game.getHeight() * 0.8f);
			}
		}
	}
	
	public void drawGameInfo(GraphicsContext g) {
		
		g.setFont(smallFont);
		int accuracyScore = (int) (data.getAccuracy() >= 50.0f ? (data.getAccuracy() / 100.0f) * 40.0f : 0.0f);
		g.fillText(String.format("Accuracy Bonus: %dpts", accuracyScore), game.getWidth() * 0.5f, game.getHeight() * 0.4f);
		g.fillText(String.format("Enemies Killed Bonus: %dpts", data.getEnemiesKilled()), game.getWidth() * 0.5f, game.getHeight() * 0.5f);
		g.setFont(lgFont);
		int finalScore = data.getScore() + data.getEnemiesKilled() + accuracyScore;
		g.fillText("Final Score: " + finalScore, game.getWidth() * 0.5f, game.getHeight() * 0.75f);
		
	}
	
	public void setBulletSpeed(float speed) {
		bulletSpawnDelay = speed;
	}

	@Override
	public void dispose() {
	}

	public void addBomb(Bomb bomb) {
		bombs.add(bomb);
	}

	public void addAlien(Alien alien) {
		aliens.add(alien);
	}

	public Alien getAlien(int index) {
		return aliens.get(index);
	}

	public int getAlienCount() {
		return aliens.size();
	}

	private void updateGameLogic(float deltaTime) {
		elapsedTime = (int) ((float) (System.currentTimeMillis() - startTime) / 1000.0f);
		player.update(deltaTime);
		updateAliens(deltaTime);
		updateBullet(deltaTime);
		updateBombs(deltaTime);
		checkCollisions();
		level.update(this);
	}

	private void checkCollisions() {
		// Collision checks with the aliens
		for (int i = 0; i < aliens.size(); i++) {
			Alien alien = aliens.get(i);

			// Alien and bullet collision
			for (Bullet bullet : bullets) {
				if (bullet != null) {
					if (bullet.collidesWith(alien)) {
						aliens.remove(i);
						bullets.remove(bullet);
						data.addScore(alien.getPoints());
						data.increaseEnemiesKilled();
						if (level.getCurrentLevel() <= 15) {
							data.increaseBulletsHit();
						}
						break;
					}
				}
			}

			// Alien and player collision
			if (alien.collidesWith(player)) {
				gameEnded = true;
				win = false;
			}
		}
		// Stop the game if the aliens have been wiped out
		if (aliens.size() == 0) {
			gameEnded = true;
			win = true;
		}
	}

	// TODO: Move alien updates to Alien#update(...)
	private void updateAliens(float deltaTime) {
		for (Alien alien : aliens) {
			alien.update(deltaTime);
		}

		// Boundary checks
		for (Alien alien : aliens) {
			int x = (int) alien.getPosition().x;

			// We'll move the aliens down and reverse its direction when it reaches an edge
			if (x + alien.getSize().width >= game.getWidth() - MARGIN_X
					&& alien.getDirection() == Alien.Direction.RIGHT) {
				for (Alien a : aliens) {
					a.setDirection(Alien.Direction.LEFT);
					a.getPosition().y += ALIEN_DOWNWARD_Y;
					a.addMovementSpeed(8.0f);
				}
				break;
			} else if (x <= MARGIN_X && alien.getDirection() == Alien.Direction.LEFT) {
				for (Alien a : aliens) {
					a.setDirection(Alien.Direction.RIGHT);
					a.getPosition().y += ALIEN_DOWNWARD_Y;
				}
				break;
			}
		}
	}

	private void updateBullet(float deltaTime) {
		bulletTime += deltaTime;

		// Spawn bullets
		if (game.getInput().isKeyPressed(KeyCode.SPACE)) {
			if (bulletTime >= bulletSpawnDelay) {
				Bullet bullet = new Bullet((int) (player.getPosition().x + Bullet.WIDTH / 2.0f),
						(int) player.getPosition().y);
				bullet.getSize().set(Bullet.WIDTH, Bullet.HEIGHT);
				bullets.add(bullet);
				bulletTime = 0.0f;
			}
		}

		// Update
		removedBullets.clear();
		for (Bullet bullet : bullets) {

			bullet.update(deltaTime);

			if (bullet.getPosition().y + bullet.getSize().height < 0) {
				removedBullets.add(bullet);
				data.increaseBulletsMissed();
			}
		}

		for (Bullet b : removedBullets) {
			bullets.remove(b);
		}
	}

	private void updateBombs(float deltaTime) {

		for (Bomb bomb : bombs) {
			bomb.update(deltaTime);
			if (bomb.collidesWith(player)) {
				gameEnded = true;
				win = false;
			}

			if (bomb.getPosition().y > game.getHeight()) {
				removedBombs.add(bomb);
			}
		}

		for (Bomb b : removedBombs) {
			bombs.remove(b);
		}
	}
}
