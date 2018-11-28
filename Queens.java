package eightQueens;

import java.util.Scanner;

public class Queens {

	static String[][] chessBoard = new String[8][8]; // Create a 2D array for the chess board

	static int row;
	static int column;
    static int currentRow;
	static int currentColumn;

	public static void setup() {

		for (row = 0; row < chessBoard.length; row++) {
			for (column = 0; column < chessBoard[row].length; column++) {
				chessBoard[row][column] = " ";
			}
		}
	}

	public static void printBoard() {
		int numPosition = 1; // Placeholder for number positions on the chess board

		System.out.print("This is an 8 Queens chessboard\n\n");

		System.out.print("\n    a   b   c   d   e   f   g   h");

		for (row = 0; row < chessBoard.length; row++) // A nested for loop to create the chess board
		{
			System.out.print("\n  +-------------------------------+\n" + numPosition++ + " |");

			for (column = 0; column < chessBoard[row].length; column++) {
				System.out.print(" ");
				System.out.print(chessBoard[row][column]); // Adds space in-between pipes
				System.out.print(" |");
			}
		}
		System.out.print("\n  +-------------------------------+\n");
	}

	public static void placeFirstQueen() // Enter queen at user's specified position
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a position on the board (i.e. D3)\n");
		String boardPosition = scan.next();

		while (boardPosition.length() != 2) {
			System.out.println("Please enter a position between A1 & H8:");
			boardPosition = scan.next();
		}

		column = boardPosition.charAt(0) - 'a';
		row = boardPosition.charAt(1) - 49;

		chessBoard[row][column] = "\u265B"; // Print user's entered Queen

		scan.close(); // Close the scanner to prevent a resource leak
	}
	
	/**
	 * Mark positions that are "off limits" by adding 
	 * dots around at horizontal, vertical and
	 * diagonal positions that the queen is placed in
	 */
	public static void markConflicts() 
	{
		for (currentRow = 0; currentRow < 8; currentRow++) 
		{
			for (currentColumn = 0; currentColumn < 8; currentColumn++) 
			{
			   // Check for conflicts in the same column
			   if (chessBoard[row][currentColumn] == " ") 
			   {
				   chessBoard[row][currentColumn] = ".";
			   }
			   // Check for conflicts in the same row
			   if (chessBoard[currentRow][column] == " ") 
			   {
				   chessBoard[currentRow][column] = ".";
			   }
			   // Check for left diagonal conflicts 
			   /** Not Working*/
			   if ((currentRow - currentColumn) == (row - column) && chessBoard[currentRow][currentColumn] == " ") 
			   {
				   chessBoard[currentRow][currentColumn] = ".";
			   }
			   // Check for right diagonal conflicts
			   if ((currentRow + currentColumn) == (row + column) && chessBoard[currentRow][currentColumn] == " ")
			   {
				   chessBoard[currentRow][currentColumn] = ".";
			   }			
			}
		}
	}
	
	/**public static void printCurrentBoard()
	{
		System.out.print(chessBoard);
	}*/
	
	/**
	 * A rudimentary method to automatically print as close
	 * to the full 8 queens as possible.
	 */
	public static void placeRemainingQueens() 
	{
	 for(row = 0; row < 8; row++)
	 {
	   for(column = 0; column < 8; column++)
	   {
		   if (chessBoard[row][column] == " ")
		   {
			   chessBoard[row][column] = "\u265B";
			   markConflicts();
		   }
	   }
	 }
	}
}
