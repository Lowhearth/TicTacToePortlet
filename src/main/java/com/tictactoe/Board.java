package com.tictactoe;

import java.io.Serializable;
import java.util.stream.Stream;

public class Board implements Serializable {

	String[] boardState = new String[9];
	String turn = "X";
	Logic logic = new Logic();
	String winner = "Z";

	public Board() {
		this.boardState = Stream.of(this.boardState).map(i -> "").toArray(String[]::new);
	}

	public Board(String[] boardState) {

		this.boardState = boardState;

	}

	public String getSquare(int i) {

		return boardState[i];
	}

	public boolean setSquare(int i, String s) {
		if (boardState[i].equals("") && this.winner.equals("Z")) {
			boardState[i] = s;
			this.turn = this.turn.equals("X") ? "O" : "X";
			if (logic.checkForWinner(this, s)) {
				this.winner = s;
				return true;
			}
			return true;
		} else
			return false;

	}

	public String[] getBoard() {
		return boardState;
	}

}
