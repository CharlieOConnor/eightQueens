package eightQueens;

public class Main {

	public static void main(String args[]) {
		
		/* Create an constructor for the queen class */
	    Queens queens = new Queens(); 
		
		queens.setup();
		queens.placeFirstQueen();
		queens.printBoard();
		System.out.println("\nUser's inputted Queen ↑\n");
		System.out.println("All 8 Queens entered ↓");
		queens.solve8Queens(); 
		queens.printBoard();
	}
}

