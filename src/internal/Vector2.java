package internal;

/* 
Defines the postion according the their x and y coordinates for all 
the objects inside the game: Aliens, Bullets and Player
*/

public class Vector2 {
    public float x, y;

    public Vector2(float vX, float vY) {
        set(vX, vY);
    }

    public Vector2() {
        set(0.0f, 0.0f);
    }

    public void set(float vX, float vY) {
        x = vX;
        y = vY;
    }
}
