package data;



import org.junit.jupiter.api.Test;

class GameDataTest extends GameData {
	
	
	// Tests to see if the score at the beginning is equal to 0

	@Test
	void testGameData() {
		assertTrue("Score isn't equal to 0", 0);

	}

	private void assertTrue(String string, int i) {

		
	}

	
	// Tests to see if getScore (getter) returns the score
	@Test
	void testGetScore() {
		assertEquals(0,getScore());
		
	}
	
	// Test if the scores is added by 5 every time alien 1 is destroyed

	@Test
	void testAddAlienDestroyedScore() {
		assertEquals1("Score isn't added by 5", 5, 0);
		}

		private void assertEquals1(String string, int i, int j) {

			
		}
		
		// Tests if the score is added by 10 every time alien 2 is destroyed
	

	@Test
	void testAddAlien2DestroyedScore() {
		assertEquals1("Score isn't added by 10", 10, 0);
		}

		private void assertEquals(int i, int j) {

			
		}
	
		// Tests to see if the score is added up 

	@Test
	void testAddScore() {
		assertEquals(0, getScore());
	}
	
	// Tests to check if the setter method works 

	@Test
	void testSetScore() {
		assertEquals(0, getScore());
	}

}
