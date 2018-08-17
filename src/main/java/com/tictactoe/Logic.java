package com.tictactoe;

public class Logic {
	
	int [][] winningMovements = new int[][] {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6} };
	String [] lineCoordinates = new String [3];
	public Logic() {
		
	}
	
	public boolean checkForWinner( Board board, String s) {
		String [] squares = board.getBoard();
		
		for (int i = 0 ; i<8; i++) {
			
			if( squares[winningMovements[i][0]].equals(s)&& squares[winningMovements[i][0]].equals(squares[winningMovements[i][1]]) && squares[winningMovements[i][0]].equals(squares[winningMovements[i][2]]) ) {
				this.lineCoordinates[0] = Integer.toString(winningMovements[i][0]);
				this.lineCoordinates[1] = Integer.toString(winningMovements[i][1]);
				this.lineCoordinates[2] = Integer.toString(winningMovements[i][2]);

				return true;
			}
			
		}
		return false;

	}
}
