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
}
