package eightQueens;

public class Main {

	public static void main(String args[]) {
		
		Queens.setup();
		Queens.placeQueen();
		Queens.markConflicts();
		Queens.printBoard();
	}
}
