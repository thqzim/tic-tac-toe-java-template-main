package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Board board;
    private char currentPlayer;
    
    private boolean xIsComputer;
    private boolean oIsComputer;
    private int movesMade;
    private Random random;

    public Game(char startingPlayer, boolean xIsComputer, boolean oIsComputer) {
        board = new Board();
        currentPlayer = startingPlayer;

        this.xIsComputer = xIsComputer;
        this.oIsComputer = oIsComputer;
        this.movesMade = 0;
        this.random = new Random();
    }

    public char play() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            board.printBoard();

                if (isComputerTurn()) {
                    int move = chooseComputerMove();
                    System.out.println("Computer (" + currentPlayer + ") chooses: " + move);
                    board.placeMark(move, currentPlayer);
                    movesMade++;
                } else {

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
            movesMade++;

    }   

            if (board.checkWin(currentPlayer)) {
                board.printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                
                return (currentPlayer == 'X') ? 'O' : 'X';
            }

            if (board.isDraw()) {
                board.printBoard();
                System.out.println("It's a draw!");
                return 'T';
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private boolean isComputerTurn() {
        return (currentPlayer == 'X' && xIsComputer) || (currentPlayer == 'O' && oIsComputer);
    }

    private int chooseComputerMove() {
        //first move -> take corner if available
        if (movesMade == 0) {
            int[] corners = {1,3,7,9};
            List<Integer> available = new ArrayList<>();
            for (int c : corners) if (board.isValidMove(c)) available.add(c);
            if (!available.isEmpty()) return available.get(random.nextInt(available.size()));
        }

        //second move -> take center if available
        if (movesMade == 1 && board.isValidMove(5)) return 5;

        //winning move
        for (int pos = 1; pos <= 9; pos++) 
            if (board.wouldWin(currentPlayer, pos)) return pos;

        //block opponent
        char opponent = (currentPlayer == 'X') ? 'O' : 'X';
        for (int pos = 1; pos <= 9; pos++) 
            if (board.wouldWin(opponent, pos)) return pos;
        
        //random move
        List<Integer> available = new ArrayList<>();
        for (int pos = 1; pos <=9; pos++)
            if (board.isValidMove(pos)) available.add(pos);

        return available.get(random.nextInt(available.size()));

    }
}
