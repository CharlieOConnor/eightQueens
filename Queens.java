package eightQueens;

import java.util.Scanner;

public class Queens {

	static String[][] chessBoard = new String[8][8]; // Create a 2D array for the chess board

	static int row;
	static int column;

	public static void setup() {

		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[i].length; j++) {
				chessBoard[i][j] = " ";
			}
		}
	}

	public static void printBoard() {
		int numPosition = 1; // Placeholder for number positions on the chess board

		System.out.print("This is an 8 Queens chessboard\n\n");

		System.out.print("\n    a   b   c   d   e   f   g   h");

		for (int row = 0; row < chessBoard.length; row++) // A nested for loop to create the chess board
		{
			System.out.print("\n  +-------------------------------+\n" + numPosition++ + " |");

			for (int column = 0; column < chessBoard[row].length; column++) {
				System.out.print(" ");
				System.out.print(chessBoard[row][column]); // Adds space in-between pipes
				System.out.print(" |");
			}
		}
		System.out.print("\n  +-------------------------------+\n");
	}

	public static void placeQueen() // Enter queen at user's specified position
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
	    int currentRow;
		int currentColumn;
		
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
			   if (Math.abs(currentRow - currentColumn) == Math.abs(row - column) && chessBoard[currentRow][currentColumn] == " ") 
			   {
				   chessBoard[currentRow][currentColumn] = ".";
			   }
			   // Check for right diagonal conflicts
			   if (currentRow + currentColumn == row + column && chessBoard[currentRow][currentColumn] == " ")
			   {
				   chessBoard[currentRow][currentColumn] = ".";
			   }
			
			}
		}
	}
}
