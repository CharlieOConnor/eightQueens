package eightQueens;

public class Main {

	public static void main(String args[]) {
		
		Queens Queens = new Queens(); //Create an instance of the Queens class
		
		Queens.setup();
		Queens.placeFirstQueen();
		Queens.markConflicts();
		Queens.printBoard();	
		Queens.tryPlaceRemainingQueens();
		Queens.removeDots(); 
		Queens.printBoard();
	}
}
