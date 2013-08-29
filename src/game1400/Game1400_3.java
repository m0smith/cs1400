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
    private String VERSION = "version 3";
    
    private final char PLAYER1 = 'X';
    private final char PLAYER2 = 'O';
    private final char CAT     = '=';
    private final char UNKNOWN = '?';
    
    // initialize the board
    private Square p1 = new Square('1');
    private Square p2 = new Square('2');
    private Square p3 = new Square('3');
    private Square p4 = new Square('4');
    private Square p5 = new Square('5');
    private Square p6 = new Square('6');
    private Square p7 = new Square('7');
    private Square p8 = new Square('8');
    private Square p9 = new Square('9');
    
    private String header = "How about a nice game of tic-tac-toe?";

    /**
     * @param args ignored
     */
    public static void main(String[] args) {
        Game1400_3 ticTacToe = new Game1400_3();
        char result = ticTacToe.playGame();
        System.out.printf ("END OF PROGRAM:%c\n" ,result);
    }

    private char playGame() {
        showBoard();
        int position = userInput();
        boolean playerMoved = validate(position);
        if (playerMoved) {
            updateBoard(position);
            computerMove();
            header = "Nice move";
            showBoard();
        }
        char status = findWinner();
        if (status == UNKNOWN) {
            return playGame();
        }
        header = "Game Over:" + status;
        showBoard();
        return status;
    }

    private void showBoard() {
        // Show the board
        System.out.printf("%s (%s)%n", header, VERSION);
        System.out.printf("%c|%c|%c%n", p1.display(), p2.display(), p3.display());
        System.out.println("-+-+-");
        System.out.printf("%c|%c|%c%n", p4.display(), p5.display(), p6.display());
        System.out.println("-+-+-");
        System.out.printf("%c|%c|%c%n", p7.display(), p8.display(), p9.display());
    }

    private int userInput() {
        System.out.printf("It is %c's turn.\nEnter your move [1-9](0=help)=>", PLAYER1);
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
            p1.claim(PLAYER1);
        }
        if (position == 2) {
            p2.claim(PLAYER1);
        }
        if (position == 3) {
            p3.claim(PLAYER1);
        }
        if (position == 4) {
            p4.claim(PLAYER1);
        }
        if (position == 5) {
            p5.claim(PLAYER1);
        }
        if (position == 6) {
            p6.claim(PLAYER1);
        }
        if (position == 7) {
            p7.claim(PLAYER1);
        }
        if (position == 8) {
            p8.claim(PLAYER1);
        }
        if (position == 9) {
            p9.claim(PLAYER1);
        }
    }

    /**
     * Computer makes a move (artifical intelligence?) Computer no longer
     * cheats
     */
    private void computerMove() {
        // Computer makes a move (artifical intelligence?)
        // Computer  no longer cheats
        Square square = findOpenSquare();
        if (square != null) {
            square.claim(PLAYER2);
        }
    }

    private void showHelp() {
        System.out.println("This is a classic game of tic-tac-toe");
        System.out.println("You enter a number between 1 and 9 to claim that square.");
    }

    private char threeInARow(Square p1, Square p2, Square p3) {
        char rtnval = p1.display();

        if (rtnval != p2.display()) {
            rtnval = UNKNOWN;
        }
        if (rtnval != p3.display()) {
            rtnval = UNKNOWN;
        }
        return rtnval;
    }

    private char findWinner() {
        char rtnval = threeInARow(p1, p2, p3);
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(p1, p5, p9);
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(p1, p4, p7);
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(p2, p5, p8);
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(p3, p6, p9);
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(p3, p5, p7);
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(p4, p5, p6);
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(p7, p8, p9);
        }
        if (rtnval == UNKNOWN) {
            rtnval = findCat();
        }
        return rtnval;
    }

    /**
     *
     * @return unknown if the game is not over or cat if it is a tie
     */
    private char findCat() {
        char rtnval = UNKNOWN;
        Square openSquare = findOpenSquare();
        if (openSquare == null) {
            rtnval = CAT;
        }
        return rtnval;
    }

    private Square findOpenSquare() {
        if (!p5.isClaimed()) {
            return p5;
        }
        if (!p1.isClaimed()) {
            return p1;
        }
        if (!p9.isClaimed()) {
            return p9;
        }
        if (!p7.isClaimed()) {
            return p7;
        }
        if (!p3.isClaimed()) {
            return p3;
        }
        if (!p6.isClaimed()) {
            return p6;
        }
        if (!p2.isClaimed()) {
            return p2;
        }
        if (!p4.isClaimed()) {
            return p4;
        }
        if (!p8.isClaimed()) {
            return p8;
        }
        return null;
    }
}
