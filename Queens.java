package eightQueens;

import java.util.Scanner;

public class Queens {

	int[][] chessBoard = new int[8][8];

	public Queens() {

		int numPosition = 8; // Placeholder for number positions on the chess
								// board

		System.out.print("This is an 8 Queens chessboard\n\n");
		System.out.print("Please enter a position on the board (i.e. D3)\n");

		placeQueen();

		System.out.print("\n    a   b   c   d   e   f   g   h");

		for (int row = 0; row < chessBoard.length; row++) // A nested for loop to create the chess board
		{
			System.out.print("\n  +-------------------------------+\n" + numPosition-- + " |");

			for (int column = 0; column < chessBoard[row].length; column++) {
				System.out.print("   |");
			}
		}
		System.out.print("\n  +-------------------------------+\n");
	}

	public void placeQueen() // Enter queen at user's specified position
	{
		Scanner scan = new Scanner(System.in);
		String boardPosition = scan.next();
		
			while (boardPosition.length() != 2) {
				System.out.println("Please enter a position between A1 & H8:");
				boardPosition = scan.next();
			}
	
			int column = boardPosition.charAt(0) - 'a';
			int row = boardPosition.charAt(0) - '1';
			
			
			 for(int i = 0; i < column; i++)
			{
				for(int j = 0; j < row; j++)
				{
					if(i == column && j == row)
						
					System.out.print("Q");	
			}
			}
			
	    
			
		scan.close();
	}
}
