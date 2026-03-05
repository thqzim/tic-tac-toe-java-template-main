package org.example;

import  static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class BoardTest {

    @Test
    public void testValidMove() {
        Board b = new Board();
        assertTrue(b.isValidMove(1));
    }

    @Test
    public void testInvalidMoveAlreadyTaken() {
        Board b = new Board();
        b.placeMark(1, 'X');
        assertFalse(b.isValidMove(1));
    }

    @Test
    public void testWinCondition() {
        Board b = new Board();
        b.placeMark(1, 'X');
        b.placeMark(2, 'X');
        b.placeMark(3, 'X');
        assertTrue(b.checkWin('X'));
    }

    @Test
    public void testAllRowWinsForX() {
        Board b = new Board();

        b.placeMark(1, 'X');
        b.placeMark(2, 'X');
        b.placeMark(3, 'X');
        assertTrue(b.checkWin('X'));
        b.reset();

        b.placeMark(4, 'X');
        b.placeMark(5, 'X');
        b.placeMark(6, 'X');
        assertTrue(b.checkWin('X'));
        b.reset();

        b.placeMark(7, 'X');
        b.placeMark(8, 'X');
        b.placeMark(9, 'X');
        assertTrue(b.checkWin('X'));
    }

    @Test
    public void testAllColumnWinsForX() {
        Board b = new Board();

        b.placeMark(1, 'X');
        b.placeMark(4, 'X');
        b.placeMark(7, 'X');
        assertTrue(b.checkWin('X'));
        b.reset();

        b.placeMark(2, 'X');
        b.placeMark(5, 'X');
        b.placeMark(8, 'X');
        assertTrue(b.checkWin('X'));
        b.reset();

        b.placeMark(3, 'X');
        b.placeMark(6, 'X');
        b.placeMark(9, 'X');
        assertTrue(b.checkWin('X'));
    }

    @Test
    public void testDiagonalWinsForX() {
        Board b = new Board();

        b.placeMark(1, 'X');
        b.placeMark(5, 'X');
        b.placeMark(9, 'X');
        assertTrue(b.checkWin('X'));
        b.reset();

        b.placeMark(3, 'X');
        b.placeMark(5, 'X');
        b.placeMark(7, 'X');
        assertTrue(b.checkWin('X'));
    }

    @Test
    public void testAllWinsForO() {
        Board b = new Board();

        b.placeMark(1, 'O');
        b.placeMark(2, 'O');
        b.placeMark(3, 'O');
        assertTrue(b.checkWin('O'));
        b.reset();

        b.placeMark(4, 'O');
        b.placeMark(5, 'O');
        b.placeMark(6, 'O');
        assertTrue(b.checkWin('O'));
        b.reset();

        b.placeMark(7, 'O');
        b.placeMark(8, 'O');
        b.placeMark(9, 'O');
        assertTrue(b.checkWin('O'));
    }

    @Test
    public void testAllColumnWinsForO() {
        Board b = new Board();

        b.placeMark(1, 'O');
        b.placeMark(4, 'O');
        b.placeMark(7, 'O');
        assertTrue(b.checkWin('O'));
        b.reset();

        b.placeMark(2, 'O');
        b.placeMark(5, 'O');
        b.placeMark(8, 'O');
        assertTrue(b.checkWin('O'));
        b.reset();

        b.placeMark(3, 'O');
        b.placeMark(6, 'O');
        b.placeMark(9, 'O');
        assertTrue(b.checkWin('O'));
    }

    @Test
    public void testDiagonalWinsForO() {
        Board b = new Board();

        b.placeMark(1, 'O');
        b.placeMark(5, 'O');
        b.placeMark(9, 'O');
        assertTrue(b.checkWin('O'));
        b.reset();

        b.placeMark(3, 'O');
        b.placeMark(5, 'O');
        b.placeMark(7, 'O');
        assertTrue(b.checkWin('O'));
    }

    @Test
    public void testTieBoard() {
        Board b = new Board();

        b.placeMark(1, 'X');
        b.placeMark(2, 'O');
        b.placeMark(3, 'X');
        b.placeMark(4, 'X');
        b.placeMark(5, 'O');
        b.placeMark(6, 'X');
        b.placeMark(7, 'O');
        b.placeMark(8, 'X');
        b.placeMark(9, 'O');
        assertTrue(b.isDraw());
    }

    @Test
    public void testIsDrawFalseWhenBoardNotFull() {
        Board b = new Board();
        b.placeMark(1, 'X');
        b.placeMark(2, 'O');
        assertFalse(b.isDraw());
    }
}
