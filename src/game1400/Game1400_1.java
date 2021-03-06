package game1400;

import java.util.Scanner;

/**
 *  This is a game of tic-tac-toe.
 * 
 * https://www.github.com/m0smith/cs1400
 * 
 * This version demonstrates:<ul>
 * <li>output (println, print, printf)
 * <li>input (Scanner)
 * <li>arithmetic
 * <li>variables
 * <ul>
 * @author Matthew Smith
 */
public class Game1400_1 {

    /**
     * @param args ignored
     */
    
    public static void main(String[] args) {
        int score = 0;
        String header = "How about a nice game of tic-tac-toe?";
               
        // Show the board
        System.out.println(header);
        System.out.println("1|2|3");
        System.out.println("-+-+-");
        System.out.println("4|5|6");
        System.out.println("-+-+-");
        System.out.println("7|8|9");
        
        // Ask user for move
        System.out.print("It is your turn;\nEnter your move =>");
        Scanner scanner = new Scanner(System.in);
        int position = scanner.nextInt();
        
        // Compute score (nonsense)
        int subscore = position + score + 10;
        score = (subscore * 2 - 10) % 6;
        System.out.printf("You entered %-10d and your score is %d %-10s.\n", position, score, "Dude!!");
    }
}
