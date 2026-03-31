package org.example;

public class GameLog {
    private int xWins;
    private int oWins;
    private int ties;

    public GameLog() {
        this.xWins = 0;
        this.oWins = 0;
        this.ties = 0;
    }

    public void recordWin(char winner) {
        if (winner == 'X') {
            xWins++;
        } else if (winner == 'O') {
            oWins++;
        }
    }

    public void recordTie() {
        ties++;
    }

    public void printLog() {
        System.out.println("\nThe current log is:\n");
        System.out.println("Player X Wins   " + xWins);
        System.out.println("Player O Wins   " + oWins);
        System.out.println("Ties            " + ties);
    }

    public void saveToFile(String filename) {
        try (java.io.PrintWriter out = new java.io.PrintWriter(filename)) {
            out.println("Final Game Statistics:");
            out.println("-----------------------");
            out.println("Player X Wins: " + xWins);
            out.println("Player O Wins: " + oWins);
            out.println("Ties: " + ties);
        } catch (Exception e) {
            System.out.println("Error writing game log to disk.");
        }
    }
}
