package eightQueens;

import java.util.Scanner;

public class Queens {

	static String[][] chessBoard = new String[8][8]; // Create a 2D array for
														// the chess board
	static int row;
	static int column;
	static int currentRow;
	static int currentColumn;

	/**
	 * Fill all positions in the board with empty spaces
	 */
	public void setup() {

		for (row = 0; row < chessBoard.length; row++) {
			for (column = 0; column < chessBoard[row].length; column++) {
				chessBoard[row][column] = " ";
			}
		}
	}

	/**
	 * Print the final state of the board after all queens have been added
	 */
	public void printBoard() {
		int numPosition = 1; // Placeholder for number positions on the chess
								// board

		System.out.print("\nThis is an 8 Queens chessboard\n\n");

		System.out.print("\n    a   b   c   d   e   f   g   h");

		for (row = 0; row < chessBoard.length; row++) // A nested for loop to
														// create the chess
														// board
		{
			System.out.print("\n  +-------------------------------+\n" + numPosition++ + " |");

			for (column = 0; column < chessBoard[row].length; column++) {
				System.out.print(" ");
				System.out.print(chessBoard[row][column]); // Adds space
															// in-between pipes
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

		System.out.print("Please enter a position on the board (i.e. D3)\n");
		boardPosition = scan.next();

		while (success == false) // Try catch block to handle all exceptions to accepted user input
		{
			try {
				column = boardPosition.charAt(0) - 'a';
				row = boardPosition.charAt(1) - 49;
				chessBoard[row][column] = "\u265B"; // Print user's entered Queen
				success = true;

			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Please enter a two character position between A1 & H8:");
				boardPosition = scan.next();
			}

			catch (StringIndexOutOfBoundsException e) {
				System.out.println("Please enter a two character position between A1 & H8:");
				boardPosition = scan.next();
			}

			if (boardPosition.length() != 2) {
				success = false;
				System.out.println("Please enter a two character position between A1 & H8:");
				boardPosition = scan.next();
			}

		}
		scan.close(); // Close the scanner to prevent a resource leak
	}

	/**
	 * Mark positions that are "off limits" by adding dots around at horizontal,
	 * vertical and diagonal positions that the queen is placed in
	 */
	public void markConflicts() {
		for (currentRow = 0; currentRow < 8; currentRow++) {
			for (currentColumn = 0; currentColumn < 8; currentColumn++) {
				
				// Check for conflicts in the same column
				if (chessBoard[row][currentColumn] == " ") {
					chessBoard[row][currentColumn] = ".";
				}
				// Check for conflicts in the same row
				if (chessBoard[currentRow][column] == " ") {
					chessBoard[currentRow][column] = ".";
				}
				// Check for left diagonal conflicts
				if ((currentRow - currentColumn) == (row - column) && chessBoard[currentRow][currentColumn] == " ") {
					chessBoard[currentRow][currentColumn] = ".";
				}
				// Check for right diagonal conflicts
				if ((currentRow + currentColumn) == (row + column) && chessBoard[currentRow][currentColumn] == " ") {
					chessBoard[currentRow][currentColumn] = ".";
				}
			}
		}
	}

	/**
	 * A rudimentary method to automatically print as close to the full 8 queens
	 * as possible.
	 */
	public void placeRemainingQueens() {
		for (row = 0; row < 8; row++) {
			for (column = 0; column < 8; column++) {
				if (chessBoard[row][column] == " ") {
					chessBoard[row][column] = "\u265B"; // Place new queen
					markConflicts(); // Call this method again to mark off all
										// new conflict positions
				}
			}
		}
	}

	/**
	 * Remove all markers on conflict positions for easier viewing when the
	 * board is printed
	 */
	public void removeDots() {
		for (row = 0; row < 8; row++) {
			for (column = 0; column < 8; column++) {
				if (chessBoard[row][column] == ".") {
					chessBoard[row][column] = " ";
				}
			}
		}
	}
}
