package org.example;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    GameLog log = new GameLog();

    char startingPlayer = 'X';

    while (true) {
      System.out.println("Welcome to Tic-Tac-Toe!");
      Game game = new Game(startingPlayer);
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

      if (result == 'T') {
        startingPlayer = (startingPlayer == 'X') ? 'O' : 'X';
      } else {
        startingPlayer = result;
      }

      System.out.println("\nGood! This time " + startingPlayer + " will go first!\n");
        
    }
  }
}
