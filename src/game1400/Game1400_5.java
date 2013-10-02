package game1400;

import java.util.Scanner;

/**
 * This is a game of tic-tac-toe version 5.
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
 * <li>
 * The game is complete with a simple AI.
 * </li>
 *
 * </ul>
 *
 *
 * This version demonstrates:<ul>
 * <li> classes / objects / parameters fields, constructors, getters, setters,
 * access modifiers</li>
 *
 * <li>
 * Algorithms Control Structures: sequence, selection, repetition if else ?:
 * </li>
 *
 * </ul>
 *
 * @author Matthew Smith
 * @see <a href="https://www.github.com/m0smith/cs1400">Sample Code Repo</a>
 * @see <a href="https://www.github.com/m0smith/cs1400-uml">UML Repo</a>
 */
public class Game1400_5 {

    private Board board = new Board();
    
    /**
     * Version of the code
     */
    private final String VERSION = "version 5";
    private final char PLAYER1   = 'X';
    private final char PLAYER2   = 'O';
    private final char CAT       = '=';
    private final char UNKNOWN   = '?';
   
    private String header = "How about a nice game of tic-tac-toe?";

    /**
     * @param args ignored
     */
    public static void main(String[] args) {
        Game1400_5 ticTacToe = new Game1400_5();
        char result = ticTacToe.playGame();
        System.out.printf("END OF PROGRAM:%c\n", result);
    }
    /**
     * Let the players take turns until the game is over.
     * @return the final result: PLAYER1, PLAYER2 or CAT
     */
    private char playGame() {
        showBoard();
        char status = UNKNOWN;
        while (status == UNKNOWN) {
            int position = userInput();
            boolean playerMoved = validate(position);
            if (playerMoved) {
                board.claimSquare(position, PLAYER1);
                computerMove();
                header = "Nice move";
                showBoard();
            }
            status = findWinner();
        }
        header = "Game Over:" + status;
        showBoard();
        return status;
    }

    private void showBoard() {
        // Show the board
        System.out.printf("%s (%s)%n", header, VERSION);
        System.out.printf("%c|%c|%c%n", board.display(1), board.display(2), board.display(3));
        System.out.println("-+-+-");
        System.out.printf("%c|%c|%c%n", board.display(4), board.display(5), board.display(6));
        System.out.println("-+-+-");
        System.out.printf("%c|%c|%c%n", board.display(7), board.display(8), board.display(9));
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
        } else if (position > 9) {
            playerMoved = false;
            System.out.printf("%d is not a valid move\n", position);
            showHelp();
        } else if (position == 0) {
            playerMoved = false;
            showHelp();
        }
        return playerMoved;
    }

    /**
     * Computer makes a move (artifical intelligence?) Computer no longer cheats
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
        char rtnval = threeInARow(board.getSquaureFor(1), board.getSquaureFor(2), board.getSquaureFor(3));
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquaureFor(1), board.getSquaureFor(5), board.getSquaureFor(9));
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquaureFor(1), board.getSquaureFor(4), board.getSquaureFor(7));
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquaureFor(2), board.getSquaureFor(5), board.getSquaureFor(8));
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquaureFor(3), board.getSquaureFor(6), board.getSquaureFor(9));
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquaureFor(3), board.getSquaureFor(5), board.getSquaureFor(7));
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquaureFor(4), board.getSquaureFor(5), board.getSquaureFor(6));
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquaureFor(7), board.getSquaureFor(8), board.getSquaureFor(9));
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
        Square openSquare = findOpenSquare();
        return openSquare == null ? CAT : UNKNOWN;
    }

    private Square findOpenSquare() {
        for(int i = 1; i <= 9; ++i){
            Square sq = board.getSquaureFor(i);
            if(! sq.isClaimed()) {
                return sq;
            }
        }
        
        return null;
    }
}
