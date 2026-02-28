package org.example;

public class Board {
    private char[] cells;

    public Board() {
        cells = new char[9];
        for (int i = 0; i < 9; i++) {
            cells[i] = (char) ('1' + i);
        }
    }

    public boolean isValidMove(int position) {
        if (position < 1 || position > 9) return false;
        char c = cells[position - 1];
        return c != 'X' && c != 'O';
    }

    public void placeMark(int position, char mark) {
        cells[position - 1] = mark;
    }

    public boolean checkWin(char mark) {
        int[][] wins = {
            {0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}
        };

        for (int[] w : wins) {
            if (cells[w[0]] == mark && cells [w[1]] == mark && cells [w[2]] == mark) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isDraw() {
        for (char c : cells) {
            if (c != 'X' && c != 'O') return false;
        }
        return true;
    }

    public void reset() {
        for (int i = 0; i < 9; i++) {
            cells[i] = (char) ('1' + i);
        }
    }

    public void printBoard() {
        System.out.println();
        System.out.println(" " + cells[0] + " | " + cells[1] + " | " + cells[2]);
        System.out.println("---+---+---");
        System.out.println(" " + cells[3] + " | " + cells[4] + " | " + cells[5]);            
        System.out.println("---+---+---");         
        System.out.println(" " + cells[6] + " | " + cells[7] + " | " + cells[8]);
        System.out.println();
     }
}
    
