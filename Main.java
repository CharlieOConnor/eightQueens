package eightQueens;

public class Main {

	public static void main(String args[]) {
		
		Queens.setup();
		Queens.placeFirstQueen();
		Queens.markConflicts();
		//Queens.printBoard();
		Queens.placeRemainingQueens();
		Queens.printBoard();
	}
}
