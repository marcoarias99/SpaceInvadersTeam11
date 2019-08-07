import java.util.Random;
import java.util.Scanner;

public class SpaceInvadersText {
	static int ROWS = 10, COLUMNS = 10;
	static Random random = new Random();
	static boolean ships[][] = new boolean[ROWS][COLUMNS];
	static int currentCol = random.nextInt(COLUMNS);
	static Scanner scanner = new Scanner(System.in);
	
	public static void shiftDown() {
		// enemy's requirements to be able to go down one column
		for(int i = ROWS-4; i >= 0; i--) {
			for(int j=0; j<COLUMNS; j++) {
				ships[i + 1][j] = ships[i][j];
			}
		}

		for(int i=0; i<COLUMNS; i++) {
			ships[0][i] = false;
		}
		int shipIndex = random.nextInt(COLUMNS);
		if(shipIndex < COLUMNS) {
			ships[0][shipIndex] = true;
		}
	}

	public static void fireOnColumn(int col) {
		for(int i=0; i<ROWS; i++) {
			ships[i][col] = false;
		}
	}

	public static void printShips() {
		System.out.print("\n ");
		for(int j=-1; j<COLUMNS; j++) {
			System.out.print((j+1) + "  ");
		}
		// Upper Horizontal Line 
		System.out.println("\n    -  -  -  -  -  -  -  -  -  -");
		// Enumeration of Grid Columns (Vertical)
		for(int i=0; i<ROWS; i++) {
			System.out.printf("%2s ", (i+1));
			for(int j=0; j<COLUMNS; j++) {
				// Show
				if(ships[i][j]) {
					// Show Enemy inside the grid
					System.out.print(" * ");
				} else {
					// 
					System.out.print(" | ");
				}
			}
			System.out.println();
		}
		// Lower Horizontal Line
		System.out.println("    -  -  -  -  -  -  -  -  -  - ");
		System.out.print(" ");
		for(int j=0; j<COLUMNS; j++) {
			//Player Designation
			if(j == currentCol) {
				System.out.print(" P");
			}
			System.out.print(" ");
		}
		System.out.println();
	}
	
// 	Grid for the code 
	
//		0  1  2  3  4  5  6  7  8  9  10	
//         -  -  -  -  -  -  -  -  -  -
//	    1  |  |  |  |  |  |  |  |  |  | 
//		2  |  |  |  |  |  |  |  |  |  | 
//		3  |  |  |  |  |  |  |  |  |  | 
//		4  |  |  |  |  |  |  |  |  |  | 
//		5  |  |  |  |  |  |  |  |  |  | 
//		6  |  |  |  |  |  |  |  |  |  | 
//		7  |  |  |  |  |  |  |  |  |  | 
//		8  |  |  |  |  |  |  |  |  |  | 
//		9  |  |  |  |  |  |  |  |  |  | 
//	   10  |  |  |  |  |  |  |  |  |  |
//		   -  -  -  -  -  -  -  -  -  -
//	       		P
	
	
	public static String getChoice() {
		// Scanner input for players movement 
		// "f" for fire
		// "m" + " " +"num" to move
		System.out.print("Enter your choice('f' to fire, 'm <Col no>' to move: ");
		return scanner.nextLine();
	}

	private static boolean gameOver() {
		//Check if game is still going through a true/false expression
		boolean gameOver = false;
		for(int i=0; i<COLUMNS; i++) {
			if(ships[ROWS-1][i]) {
				//Game Ends
				gameOver = true;
				break;
			}
		}
		return gameOver;
	}

	public static void main(String[] args) {
		shiftDown();
		printShips();
		while(true) {
			String choice = getChoice();
			if(choice.equalsIgnoreCase("f")) {
				fireOnColumn(currentCol);
				shiftDown();
				printShips();
			// Way of writing the movement of player "P"
			} else if(choice.startsWith("m")) {
				String tokens[] = choice.split(" ");
				int col = Integer.parseInt(tokens[1]) - 1;
				
				//Wrong inputs on the Scanner
				if((col < 0) || (col >= COLUMNS)) {
					System.out.println("Invalid move. Column not found. Try again.");
				} else {
					// Game Over Statement
					if(gameOver()) {
						System.out.println("Game Over.");
						break;
					}
					currentCol = col;
					shiftDown();
					printShips();
				}
			} else {
				System.out.println("Invalid choice. Try again.");
			}
		}
		System.out.println("Better Luck next time!");
	}
	

}
