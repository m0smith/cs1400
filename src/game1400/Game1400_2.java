package game1400;

import java.util.Scanner;

/**
 * This is a game of tic-tac-toe version 2.
 *
 * The board is represented by the variables p1 through p9 thusly:
 * 
 * <pre>
 *   p1 | p2 | p3
 *   ---+----+---
 *   p4 | p5 | p6
 *   ---+----+---
 *   p7 | p8 | p9
 * </pre>
 *
 * They can only contain:<ul>
 * <li>a number - if the square is not claimed
 * <li>X - if owned by player 1
 * <li>O - if owned by player 2
 *</ul>
 * 
 * Thus far we can:<ul>
 * <li>
 *    display the board and ask the user for input.
 * </li>
 *
 * <li>
 *    added a help feature, validate the user input, 
 *    have the computer make a move, update the board with both moves 
 *    and display the new board state
 * </li>
 *
 * </ul>
 *
 *
 * This version demonstrates:<ul>
 * <li>equality (==)
 * <li>inequality (!=)
 * <li>relationship (< > <= >=)
 * <li>if statement
 * <li>boolean
 *
 * </ul>
 *
 * @author Matthew Smith
 * @see <a href="https://www.github.com/m0smith/cs1400">Sample Code Repo</a>
 */
public class Game1400_2 {

    /**
     * @param args ignored
     */
    public static void main(String[] args) {
        // Version of the code
        String version = "version 2";

        // Some constants to make life easier
        char player1 = 'X';
        char player2 = 'O';

        // initialize the board
        char p1 = '1';
        char p2 = '2';
        char p3 = '3';

        char p4 = '4';
        char p5 = '5';
        char p6 = '6';

        char p7 = '7';
        char p8 = '8';
        char p9 = '9';

        String header = "How about a nice game of tic-tac-toe?";

        // Show the board
        System.out.printf("%s (%s)%n", header, version);
        System.out.printf("%c|%c|%c%n", p1, p2, p3);
        System.out.println("-+-+-");
        System.out.printf("%c|%c|%c%n", p4, p5, p6);
        System.out.println("-+-+-");
        System.out.printf("%c|%c|%c%n", p7, p8, p9);

        // Ask user for move
        System.out.printf("It is %c's turn.\nEnter your move [1-9](0=help)=>", player1);
        Scanner scanner = new Scanner(System.in);
        int position = scanner.nextInt();

        // Validate the move
        boolean playerMoved = true;
        boolean tooSmall = position < 0;

        if (tooSmall) {
            playerMoved = false;
            System.out.printf("%d is not a valid move\n", position);
            System.out.println("This is a classic game of tic-tac-toe");
            System.out.println("You enter a number between 1 and 9 to claim that square.");
        }
        if (position > 9) {
            playerMoved = false;
            System.out.printf("%d is not a valid move\n", position);
            System.out.println("This is a classic game of tic-tac-toe");
            System.out.println("You enter a number between 1 and 9 to claim that square.");
        }


        // Show Help
        if (position == 0) {
            playerMoved = false;
            System.out.println("This is a classic game of tic-tac-toe");
            System.out.println("You enter a number between 1 and 9 to claim that square.");
        }

        // Update the board
        if (position == 1) {
            p1 = player1;
        }
        if (position == 2) {
            p2 = player1;
        }
        if (position == 3) {
            p3 = player1;
        }
        if (position == 4) {
            p4 = player1;
        }
        if (position == 5) {
            p5 = player1;
        }
        if (position == 6) {
            p6 = player1;
        }
        if (position == 7) {
            p7 = player1;
        }
        if (position == 8) {
            p8 = player1;
        }
        if (position == 9) {
            p9 = player1;
        }

        // Computer makes a move (artifical intelligence?)
        // Computer cheats (how?)
        if (p5 != player1) {
            p5 = player2;
        }
        if (p5 == player1) {
            p1 = player2;
        }

        // Update the user feedback
        if (playerMoved) {
            header = "Nice move";
            // Show the board
            System.out.println(header);
            System.out.printf("%c|%c|%c%n", p1, p2, p3);
            System.out.println("-+-+-");
            System.out.printf("%c|%c|%c%n", p4, p5, p6);
            System.out.println("-+-+-");
            System.out.printf("%c|%c|%c%n", p7, p8, p9);
        }
    }
}
