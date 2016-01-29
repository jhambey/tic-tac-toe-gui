package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
   

	@Test
	public void testInitialBoardIsEmpty() {
		TicTacToe.ClearBoard();
		assertTrue(TicTacToe.IsBoardEmpty());

	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToe.ClearBoard();
		TicTacToe.who = 'X';
		TicTacToe.Mark(0, 2);
		assertEquals('X',TicTacToe.board[0][2]);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TicTacToe.ClearBoard();
		TicTacToe.who = 'O';
		TicTacToe.Mark(2, 0);
		assertEquals('O',TicTacToe.board[2][0]);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		TicTacToe.ClearBoard();
		TicTacToe.who = 'O';
		TicTacToe.Mark(0, 0);
		TicTacToe.who = 'X';
		TicTacToe.Mark(0, 0);
		assertEquals("This tile has already been taken.", TicTacToe.UnableToMark());
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		TicTacToe.ClearBoard();
		TicTacToe.turns = 1;
		assertTrue(TicTacToe.StillRunning());
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TicTacToe.ClearBoard();
		TicTacToe.who = 'X';
		TicTacToe.Mark(0, 0);
		TicTacToe.Mark(1, 1);
		TicTacToe.Mark(0, 1);
		TicTacToe.Mark(2, 2);
		TicTacToe.Mark(0, 2);
		TicTacToe.GetWinner();
		assertEquals("X",TicTacToe.Winner());
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TicTacToe.ClearBoard();

		TicTacToe.Mark(1,1);
		TicTacToe.Mark(0, 0);
		TicTacToe.Mark(2, 0);
		TicTacToe.Mark(0, 2);
		TicTacToe.Mark(0, 1);
		TicTacToe.Mark(2, 1);
		TicTacToe.Mark(1, 2);
		TicTacToe.Mark(1, 0);
		TicTacToe.Mark(2, 2);
		TicTacToe.GetWinner();
		assertEquals("TIE", TicTacToe.Winner());
	}	
}
