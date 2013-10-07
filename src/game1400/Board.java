
package game1400;

/**
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
 * They can only contain:<ul>
 * <li>a number - if the square is not claimed
 * <li>X - if owned by player 1
 * <li>O - if owned by player 2
 * </ul>
 * @author Smith
 */
public class Board {
     
    private Square p1 = new Square();
    private Square p2 = new Square();
    private Square p3 = new Square();
    private Square p4 = new Square();
    private Square p5 = new Square();
    private Square p6 = new Square();
    private Square p7 = new Square();
    private Square p8 = new Square();
    private Square p9 = new Square();
    
    public Board()
    {
        initInternal();
    }
    
    public void claimSquare(int position, char player){
        Square sq = getSquareFor(position);
        if(sq != null) {
            sq.claim(player);
        }
    }
    
    public char display(int position) {
        Square sq = getSquareFor(position);
        if(sq != null) {
            return sq.display();
        } 
        return ' ';
    }
    
    public Square getSquareFor(int position) {
        Square sq;
        switch (position) {
            case 1:
                sq = p1;
                break;
            case 2:
                sq = p2;
                break;
            case 3:
                sq = p3;
                break;
            case 4:
                sq = p4;
                break;
            case 5:
                sq = p5;
                break;
            case 6:
                sq = p6;
                break;
            case 7:
                sq = p7;
                break;
            case 8:
                sq = p8;
                break;
            case 9:
                sq = p9;
                break;
            default:
                System.out.printf("Invalid board position %d should never get here\n", position);
                sq = null;
                break;
        }
        return sq;
    }

    
    
    public void init() {
        initInternal();
    }
    
    private void initInternal() {
        char n = '1';
        for(int i = 1; i <= 9; ++i) {
            Square s = getSquareFor(i); 
            s.init();
            s.setName(n++);
        }
    }
    
}
