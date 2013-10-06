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
    
    private final int BOARD_SIZE = 9;
   
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
                status = findWinner();
                if(status == UNKNOWN) {
                    computerMove(position);
                    header = "Nice move";
                    showBoard();
                    status = findWinner();
                } 
            }
        }
        header = "Game Over:" + status;
        showBoard();
        return status;
    }

    private void showBoard() {
        // Show the board
        System.out.printf("%s (%s)", header, VERSION);
        
        int pos = 1;
        String row = "";
        for(int i = 0; i < 3; ++i) {
            System.out.println(row);
            String sep = "";
            for(int j = 0; j < 3; ++j){
                System.out.printf("%s%c", sep, board.display(pos++));
                //System.out.printf("i=%d j=%d\n", i,j);
                sep = "|";
            }
            System.out.println();
            row = "-+-+-";
        }
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
        } else if (position > BOARD_SIZE) {
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
    private void computerMove(int position) {
        // Computer makes a move (artifical intelligence?)
        // Computer  no longer cheats
        
        int computerPos = 3;
        for(int i = 1; i < BOARD_SIZE; ++i) {
           computerPos += 2;
           if(computerPos > 9) {
               computerPos = 2;
           }
           Square sq = board.getSquareFor(computerPos);
           if(! sq.isClaimed()) {
               sq.claim(PLAYER2);
               return;
           }
        }
        
        
        //Square square = findOpenSquare();
        //if (square != null) {
        //    square.claim(PLAYER2);
        //}
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
        char rtnval = threeInARow(board.getSquareFor(1), board.getSquareFor(2), board.getSquareFor(3));
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquareFor(1), board.getSquareFor(5), board.getSquareFor(9));
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquareFor(1), board.getSquareFor(4), board.getSquareFor(7));
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquareFor(2), board.getSquareFor(5), board.getSquareFor(8));
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquareFor(3), board.getSquareFor(6), board.getSquareFor(9));
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquareFor(3), board.getSquareFor(5), board.getSquareFor(7));
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquareFor(4), board.getSquareFor(5), board.getSquareFor(6));
        }
        if (rtnval == UNKNOWN) {
            rtnval = threeInARow(board.getSquareFor(7), board.getSquareFor(8), board.getSquareFor(9));
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
        
        for(int i = 1; i <= BOARD_SIZE; ++i){
            Square sq = board.getSquareFor(i);
            if(! sq.isClaimed()) {
                return sq;
            }
        }
        
        return null;
    }
}
