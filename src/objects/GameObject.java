package objects;

import internal.Size;
import internal.Vector2;
import javafx.scene.image.Image;

public abstract class GameObject {
    protected Vector2 position = new Vector2();
    protected Size size = new Size();
    protected Image image;

    public GameObject() {
    	image = new Image(getImageName());
    }

    public GameObject(int x, int y) {
    	this();
        position.set(x, y);
    }

    abstract public void update(float deltaTime);
    abstract public String getImageName();

    public Vector2 getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }
    
    public Image getImage() {
    	return image;
    }

    public boolean collidesWith(GameObject object) {
        if(position.x < object.position.x + object.size.width &&
                position.x + size.width > object.position.x &&
                position.y < object.position.y + object.size.height &&
                position.y + size.height > object.position.y)
        {
            return true;
        } else {
            return false;
        }
    }
}
