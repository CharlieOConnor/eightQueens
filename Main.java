package eightQueens;

public class Main {

	public static void main(String args[]) {
		
		/*NQueenProblem Queen = new NQueenProblem(); 
        Queen.solveNQ(); */
		
	    Queens Queens = new Queens(); //Create an instance of the Queens class
		
		Queens.setup();
		Queens.placeFirstQueen();
		Queens.printBoard();	
		Queens.solve8Queens(); 
		Queens.printBoard();
	}
}
