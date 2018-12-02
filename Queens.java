package eightQueens;

import java.util.Scanner;

public class Queens {

	/* Create a 2D array for the chess board */
	String[][] chessBoard = new String [8][8]; 

	/**
	 * Fill all positions in the board with empty spaces
	 * to allow queens to be placed
	 */
	public void setup() {
		
		for (int row = 0; row < chessBoard.length; row++) {
			for (int column = 0; column < chessBoard[row].length; column++) {
				/* Fill all positions with spaces */
				chessBoard[row][column] = " "; 
			}
		}
	}

	/**
	 * Print the final state of the board after all queens have been added
	 */
	public void printBoard() {
		
		int numPosition = 1; 

		System.out.print("\n    a   b   c   d   e   f   g   h");
		
		/* A nested for loop to create the chess board */
		for (int row = 0; row < chessBoard.length; row++) 
		{
			System.out.print("\n  +-------------------------------+\n" + numPosition++ + " |");

			for (int column = 0; column < chessBoard[row].length; column++) {
				System.out.print(" ");
				System.out.print(chessBoard[row][column]); // Prints space or queen															
				System.out.print(" |");
			}
		}
		System.out.print("\n  +-------------------------------+\n");
	}

	/**
	 * The first queen is placed via user input
	 */
	public void placeFirstQueen() {
		Scanner scan = new Scanner(System.in);
		String boardPosition;
		boolean success = false;

		System.out.print("Please enter a position on the board (i.e. D3): ");
		boardPosition = scan.next();

		while (success == false) // Try catch block to handle all exceptions for accepted user input
		{
			try {
				int column = boardPosition.charAt(0) - 'a';
				int row = boardPosition.charAt(1) - 49;
				chessBoard[row][column] = "\u265B"; // Enter user's Queen at specified position
				success = true;
			} 
			
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.print("Please enter a two character position between A1 & H8: ");
				boardPosition = scan.next();
			}

			catch (StringIndexOutOfBoundsException e) {
				System.out.print("Please enter a two character position between A1 & H8: ");
				boardPosition = scan.next();
			}

			if (boardPosition.length() != 2) {
				success = false;
				System.out.print("Please enter a two character position between A1 & H8: ");
				boardPosition = scan.next();
			}

		}
		scan.close(); // Close the scanner to prevent a resource leak
	}
	
	/** 
	 * Check all possible conflicts for each new queen
	 */
	public boolean isSafe(int row, int column)
	{
        int i, j;
        
        /* Check for column conflicts */
        for(i = 0; i < 8; i++)
        {
        	if(chessBoard[i][column] == "\u265B") 
    			return true;
        } 
        /* Check for row conflicts */
        for(j = 0; j < 8; j++)
        {
        	if(chessBoard[row][j] == "\u265B")
        		return false;
        } 
        /* Check upper diagonal on the left side */
        for(i = row, j = column; i >= 0 && j >= 0; i--, j--)
        {
        	if(chessBoard[i][j] == "\u265B")
        		return false;
        }
        /* Check lower diagonal on the left side */
        for(i = row, j = column; i < 8 && j >= 0; i++, j--)
        {
        	if(chessBoard[i][j] == "\u265B")
        		return false;
        }
        /* Check upper diagonal on the right side */
        for(i = row, j = column; i >= 0 && j < 8; i--, j++)
        {
        	if(chessBoard[i][j] == "\u265B")
        		return false;
        }
        /* Check lower diagonal on the right side */
        for(i = row, j = column; i < 8 && j < 8; i++, j++)
        {
        	if(chessBoard[i][j] == "\u265B")
        		return false;
        }   
		return true;
	}
	
	/** 
	 * Begin placing queens by calling isSafe() method recursively
	 */
	public boolean placeRemainingQueens(int column)
	{
		/* Base case: if all queens are placed
		   then return true */
		if (column == 8)
		{
			return true;
		}
		
		for(int i = 0; i < 8; i++)
		{
			if(isSafe(i, column))
			{
				chessBoard[i][column] = "\u265B";
			
			if(placeRemainingQueens(column + 1) == true)			
				return true;
			
			    chessBoard[i][column] = " ";
			}
		}
		return false;
	}
	
	/**
	 * Initialise starting column for placing the remaining
	 * queens, so it can be called in the main class 
	 */
	public void solve8Queens()
	  {
		placeRemainingQueens(0);
	  }
}
