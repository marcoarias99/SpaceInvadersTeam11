package screens;

import data.GameData;
import data.Level;
import internal.Game;
import internal.Screen;
import objects.Alien;
import objects.Alien2;
import objects.Bomb;
import objects.Bullet;
import objects.Player;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class GameScreen implements Screen {
    public static final float MARGIN_X = 25.0f;
    public static final float ALIEN_DOWNWARD_Y = 25.0f;
    public static final float BULLET_SPAWN_DELAY = 1.0f;

    Game game;
    GameData data;
    Player player;
    Level level;
    ArrayList<Bullet> bullets = new ArrayList<>();
    float bulletTime = 0.0f;
    ArrayList<Alien> aliens = new ArrayList<>();
    ArrayList<Bullet> removedBullets = new ArrayList<>();

    boolean gameEnded = false;
    boolean win = false;
    boolean restarting = false;

    Font main;

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

        reset();
        level.apply(aliens);
    }

    public void reset() {
        aliens.clear();
        bullets.clear();
        player.getPosition().set(game.getWidth() / 2.0f - player.getSize().width / 2.0f, game.getHeight() * 0.8f);
        gameEnded = false;
        win = false;
        bulletTime = 0.0f;
    }

    @Override
    public void update(float deltaTime) {
        if (!gameEnded) {
            updateGameLogic(deltaTime);
        } else {
            if (restarting || !win) return;
            
            restarting = true;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reset();
            if (level.getNextLevel() != null) {
            	level = level.getNextLevel();
            	level.apply(aliens);
            	restarting = false;
            }
        }
    }

    @Override
    public void render(GraphicsContext g) {
    	
        g.drawImage(
                player.getImage(),
                player.getPosition().x,
                player.getPosition().y,
                player.getSize().width,
                player.getSize().height);

        for (int i = 0; i < aliens.size(); i++) {
        	Alien alien = aliens.get(i);
            g.drawImage(
                    alien.getImage(),
                    alien.getPosition().x,
                    alien.getPosition().y,
                    alien.getSize().width,
                    alien.getSize().height
            );

            Bomb b = alien.getBomb();
            if (b != null) {
                g.drawImage(
                        b.getImage(),
                        b.getPosition().x,
                        b.getPosition().y,
                        b.getSize().width,
                        b.getSize().height
                );
            }
        }
        for (Bullet bullet : bullets) {
            if (bullet != null) {
                g.drawImage(bullet.getImage(),
                        bullet.getPosition().x,
                        bullet.getPosition().y,
                        bullet.getSize().width,
                        bullet.getSize().height
                );
            }
        }

        g.setFont(main);
        g.setFill(Color.WHITE);
        g.setTextAlign(TextAlignment.RIGHT);
        g.fillText(String.valueOf(data.getScore()), game.getWidth() - 5, 25);

        // Draw the result of the game
        if (gameEnded) {
            String outcome;
            if (win) {
                if (level.getNextLevel() == null) {
                    outcome = "WINNER! Game ended!";
                } else {
                    outcome = "WINNER! Loading next level...";
                }
            } else {
                outcome = "Game Over!";
            }
            g.setTextAlign(TextAlignment.CENTER);
            g.setFont(main);
            g.setFill(Color.WHITE);
            g.fillText(outcome, game.getWidth() / 2.0f, game.getHeight() / 2.0f);
        }
    }

    @Override
    public void dispose() {
    }

    private void updateGameLogic(float deltaTime) {
        player.update(deltaTime);
        updateAliens(deltaTime);
        updateBullet(deltaTime);
        checkCollisions();
        level.update(aliens);
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
                        break;
                    }
                }
            }

            // Alien and player collision
            if (alien.collidesWith(player)) {
                gameEnded = true;
                win = false;
            }

            // Bomb and player collision
            if (alien.getBomb() != null) {
                if (alien.getBomb().collidesWith(player)) {
                    gameEnded = true;
                    win = false;
                }
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
        for (Alien alien: aliens) {
            alien.update(deltaTime);
        }


        // Boundary checks
        for (Alien alien : aliens) {
            int x = (int) alien.getPosition().x;

            // We'll move the aliens down and reverse its direction when it reaches an edge
            if (x + alien.getSize().width >= game.getWidth() - MARGIN_X && alien.getDirection() == Alien.Direction.RIGHT) {
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
            if (bulletTime >= BULLET_SPAWN_DELAY) {
                Bullet bullet = new Bullet(
                        (int) (player.getPosition().x + Bullet.WIDTH / 2.0f),
                        (int) player.getPosition().y);
                bullet.getSize().set(
                        Bullet.WIDTH,
                        Bullet.HEIGHT
                );
                bullets.add(bullet);
                bulletTime = 0.0f;
            }
        }

        // Update
        // TODO: Store the removed bullets in a separate array and use that as a reference to delete
        // everything from the main array.
        removedBullets.clear();
        for (Bullet bullet : bullets) {
            
        	bullet.update(deltaTime);
            
            if (bullet.getPosition().y + bullet.getSize().height < 0) {
            	removedBullets.add(bullet);
            }
        }
        
        for (Bullet b : removedBullets) {
        	bullets.remove(b);
        }
    }
}
