package org.example;
import java.util.Scanner;

public class Game {
    private Board board;
    private char currentPlayer;

    public Game() {
        board = new Board();
        currentPlayer = 'X';
    }

    public void play() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            board.printBoard();
            System.out.print("Player " + currentPlayer + ", enter a move (1-9): ");
            
            String input = sc.nextLine().trim();

            int move;
            try {
                move = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }
            
            if (!board.isValidMove(move)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board.placeMark(move, currentPlayer);

            if (board.checkWin(currentPlayer)) {
                board.printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (board.isDraw()) {
                board.printBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }
}
