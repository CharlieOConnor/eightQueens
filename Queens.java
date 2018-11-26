package eightQueens;

import java.util.Scanner;

public class Queens {

	String[][] chessBoard = new String[8][8];

	/** Maybe change to a string? (Originally an int) */

	public Queens() {

		
		
		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[i].length; j++) {
				chessBoard[i][j] = " ";
			}
		}
		
				
		
	}
	
    public static void printBoard() 
    {
    	int numPosition = 1; // Placeholder for number positions on the chess board
    	
    	System.out.print("This is an 8 Queens chessboard\n\n");

		System.out.print("\n    a   b   c   d   e   f   g   h");

		for (int row = 0; row < chessBoard.length; row++) // A nested for loop to create the chess board
		{
			System.out.print("\n  +-------------------------------+\n" + numPosition++ + " |");

			for (int column = 0; column < chessBoard[row].length; column++) {
				System.out.print(" ");
				System.out.print(chessBoard[row][column]); //Adds space in-between pipes
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
 
		int column = boardPosition.charAt(0) - 'a';
		int row = boardPosition.charAt(1) - 49;

        if(column > 8)
        {
        	boardPosition = scan.next();
        }
        chessBoard[row][column] = "\u265B";
        
		scan.close();
	}
}
