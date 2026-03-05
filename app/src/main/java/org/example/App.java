package org.example;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("Welcome to Tic-Tac-Toe!");
      Game game = new Game();
      game.play(); 

      System.out.print("Play again? (y/n) ");
      String again = sc.nextLine().trim().toLowerCase();

      if (!again.equals("y")) {
         System.out.println("Goodbye!");
         break;
      }
        
    }
  }
}
