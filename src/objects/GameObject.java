package objects;

import internal.Size;
import internal.Vector2;

public abstract class GameObject {
    protected Vector2 position = new Vector2();
    protected Size size = new Size();

    public GameObject() {
    }

    public GameObject(int x, int y) {
        position.set(x, y);
    }

    abstract public void update(float deltaTime);

    public Vector2 getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
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
