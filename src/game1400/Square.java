package game1400;

/**
 *
 * @author Smith
 */
public class Square {

    private char name;
    private char owner;
    private boolean claimed = false;

    public Square() {
    }
    
    public Square(char c) {
        name = c;
    }
    
    public void init(){
        owner = 0;
        claimed = false;
    }
    
    public void setName(char n) {
        name = n;
    }
    
    public char getName() {
        return name;
    }

    public boolean claim(char player) {
        boolean rtnval = false;
        if (!claimed) {
            claimed = true;
            owner = player;
            rtnval = true;
        }
        return rtnval;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public char display() {
        char rtnval = name;
        if (claimed) {
            rtnval = owner;
        }
        return rtnval;
    }
}
