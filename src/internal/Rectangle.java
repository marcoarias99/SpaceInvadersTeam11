package internal;

public class Rectangle {

	public float x, y, width, height;
	
	public Rectangle (float x, float y, float width, float height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	public boolean isPointInside(float px, float py) {
		return (px >= x && px <= x + width) && (py >= y && py <= y + height);
	}
	
}
