package eightQueens;

public class Main {

	public static void main(String args[]) {
		
	    Queens queens = new Queens(); //Create an instance of the Queens class
		
		queens.setup();
		queens.placeFirstQueen();
		queens.printBoard();
		System.out.println("\nUser's inputted Queen ↑\n");
		System.out.println("All 8 Queens entered ↓");
		queens.solve8Queens(); 
		queens.printBoard();
	}
}

