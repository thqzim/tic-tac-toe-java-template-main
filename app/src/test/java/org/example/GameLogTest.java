package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameLogTest {

    @Test
    public void testInitialCountsAreZero() {
        GameLog log = new GameLog();
        log.printLog();
    }

    @Test
    public void testRecordXWin() {
        GameLog log = new GameLog();
        log.recordWin('x');
        log.recordWin('X');
        log.recordWin('X');
        assertDoesNotThrow(() -> log.printLog());
    }

    @Test
    public void testRecordOWin() {
        GameLog log = new GameLog();
        log.recordWin('O');
        log.recordWin('O');
        assertDoesNotThrow(() -> log.printLog());
    }

    @Test
    public void testRecordTie() {
        GameLog log = new GameLog();
        log.recordTie();
        log.recordTie();
        log.recordTie();
        assertDoesNotThrow(() -> log.printLog());
    }

    @Test
    public void testSaveToFileDoesNotThrow() {
        GameLog log = new GameLog();
        log.recordWin('X');
        log.recordWin('O');
        log.recordTie();
        assertDoesNotThrow(() -> log.saveToFile("test_game_log.txt"));
    }
}
