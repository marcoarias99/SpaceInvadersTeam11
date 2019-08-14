package internal;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;

class WindowTest extends Window{
	
	 
	// Tests to see if the getWidth (getter) returns the width

	@Test
	void testGetWidth() {
		assertEquals(0,getWidth());
		assertTrue(1);

	}

	private void assertTrue(int width) {
		width = 1;
		
	}
	
	// Tests to see if the getHeight (getter) returns the height

	@Test
	void testGetHeight() {
		assertEquals(0,getHeight());
		assertTrue(1);
	}
	
	// Tests to see if the getScene (getter) returns the scene

	@Test
	void testGetScene() {
		assertEquals(null, getScene());
		assertTrue(1);
	}
	
	// Tests to see if the getGraphics ( getter) returns the graphics

	@Test
	void testGetGraphics() {
		assertEquals(null, getGraphics());
		assertTrue(1);

	}

}
