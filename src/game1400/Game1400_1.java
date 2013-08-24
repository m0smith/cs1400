/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game1400;

import java.util.Scanner;

/**
 *  This is a game of tic-tac-toe
 * @author Smith
 */
public class Game1400_1 {

    /**
     * @param args ignored
     */
    
    public static void main(String[] args) {
        int score = 0;
        
        // Show the board
        System.out.println("How about a nice game of tic-tac-toe?");
        System.out.println("1|2|3");
        System.out.println("-+-+-");
        System.out.println("4|5|6");
        System.out.println("-+-+-");
        System.out.println("7|8|9");
        
        // Ask user for move
        System.out.print("Enter you move =>");
        Scanner scanner = new Scanner(System.in);
        int position = scanner.nextInt();
        
        // Compute score (nonsense)
        score = ((position + 5) * 2 - 10) % 6;
        System.out.printf("You entered %d and your score is %d\n", position, score);
    }
}
