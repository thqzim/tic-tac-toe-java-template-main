package org.example;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    GameLog log = new GameLog();

    char startingPlayer = 'X';

    while (true) {
      System.out.println("Welcome to Tic-Tac-Toe!");

      boolean xIsComputer = false;
      boolean oIsComputer = false;

      System.out.println("What kind of game would you like to play?\n");
      System.out.println("1. Human vs Human");
      System.out.println("2. Human vs Computer");
      System.out.println("3. Computer vs Human\n");

      int selection = 0;
      while (true) {
        System.out.println("What is your selection? ");
        String input = sc.nextLine().trim();
        try {
            selection = Integer.parseInt(input);
        } catch (Exception e) {
          System.out.println("That is not valid selection! Try again.");
          continue;
        }
        if (selection < 1 || selection > 3) {
          System.out.println("That is not a valid selecion! Try again.");
        } else break;
      }

      if (selection == 1) {
        System.out.println("\nGreat! Human vs. Human.\n");
        xIsComputer = false;
        oIsComputer = false;
      } else if (selection == 2) {
        System.out.println("\nGreat! Human vs. Computer. The human will go first.\n");
        xIsComputer = false;
        oIsComputer = true;
        startingPlayer = 'X';

      } else {
        System.out.println("\nGreat! Computer vs. Human. The computer will go first.\n");
        xIsComputer = true;
        oIsComputer = false;
        startingPlayer = 'X';
      }

      Game game = new Game(startingPlayer, xIsComputer, oIsComputer);

      char result = game.play();

      if (result == 'T') {
        log.recordTie();
      } else {
        char winner = (result == 'X') ? 'O' : 'X';
        log.recordWin(winner);
      }

      log.printLog();


      System.out.print("\nPlay again? (y/n) ");
      String again = sc.nextLine().trim().toLowerCase();

      if (!again.equals("y")) {
        System.out.println("\nWriting the game log to disk. Please see game.txt for final statistics!");
        log.saveToFile("game.txt");
         System.out.println("Goodbye!");
         break;
      }

      System.out.println("\nGood! Starting a new game!\n");
        
    }
  }
}
