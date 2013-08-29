package game1400;

import java.util.Scanner;

/**
 * This is a game of tic-tac-toe version 3.
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
 * </ul>
 *
 * Thus far we can:<ul>
 * <li>
 * display the board and ask the user for input.
 * </li>
 *
 * <li>
 * added a help feature, validate the user input, have the computer make a move,
 * update the board with both moves and display the new board state
 * </li>
 *
 * </ul>
 *
 *
 * This version demonstrates:<ul>
 * <li> classes / objects / parameters fields, constructors, getters, setters,
 * access modifiers</li>
 *
 * </ul>
 *
 * @author Matthew Smith
 * @see <a href="https://www.github.com/m0smith/cs1400">Sample Code Repo</a>
 * @see <a href="https://www.github.com/m0smith/cs1400-uml">UML Repo</a>
 */
public class Game1400_3 {
    /**
     * Version of the code
     */
    private String version = "version 3";
    
    /**
     * Define player 1 (the human)
     */
    private char player1 = 'X';
    
    /**
     * Define player 2 (the computer)
     */
    private char player2 = 'O';
    
    // initialize the board
    private char p1 = '1';
    private char p2 = '2';
    private char p3 = '3';
    private char p4 = '4';
    private char p5 = '5';
    private char p6 = '6';
    private char p7 = '7';
    private char p8 = '8';
    private char p9 = '9';
    
    private String header = "How about a nice game of tic-tac-toe?";

    /**
     * @param args ignored
     */
    public static void main(String[] args) {
        Game1400_3 ticTacToe = new Game1400_3();
        ticTacToe.playGame();
    }
    private void playGame() {
        showBoard();
        int position = userInput();
        boolean playerMoved = validate(position);
        if(playerMoved) {
            updateBoard(position);
            computerMove();
             header = "Nice move";
            showBoard();
        }
    }
    private void showBoard() {
        // Show the board
        System.out.printf("%s (%s)%n", header, version);
        System.out.printf("%c|%c|%c%n", p1, p2, p3);
        System.out.println("-+-+-");
        System.out.printf("%c|%c|%c%n", p4, p5, p6);
        System.out.println("-+-+-");
        System.out.printf("%c|%c|%c%n", p7, p8, p9);
    }

    private int userInput() {
        System.out.printf("It is %c's turn.\nEnter your move [1-9](0=help)=>", player1);
        Scanner scanner = new Scanner(System.in);
        int position = scanner.nextInt();
        return position;
    }

    private boolean validate(int position) {
        boolean playerMoved = true;
        boolean tooSmall = position < 0;
        if (tooSmall) {
            playerMoved = false;
            System.out.printf("%d is not a valid move\n", position);
            showHelp();
        }
        if (position > 9) {
            playerMoved = false;
            System.out.printf("%d is not a valid move\n", position);
            showHelp();
        }
        // Show Help
        if (position == 0) {
            playerMoved = false;
            showHelp();
        }
        return playerMoved;
    }

    private void updateBoard(int position) {
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
    }

    private void computerMove() {
        // Computer makes a move (artifical intelligence?)
        // Computer cheats (how?)
        if (p5 != player1) {
            p5 = player2;
        }
        if (p5 == player1) {
            p1 = player2;
        }
    }

    private void showHelp() {
        System.out.println("This is a classic game of tic-tac-toe");
        System.out.println("You enter a number between 1 and 9 to claim that square.");
    }
}
