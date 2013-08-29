package game1400;

/**
 *
 * @author Smith
 */
class Square {

    private char name;
    private char owner;
    private boolean claimed = false;

    Square(char c) {
        name = c;
    }

    boolean claim(char player) {
        boolean rtnval = false;
        if (!claimed) {
            claimed = true;
            owner = player;
            rtnval = true;
        }
        return rtnval;
    }

    boolean isClaimed() {
        return claimed;
    }

    char display() {
        char rtnval = name;
        if (claimed) {
            rtnval = owner;
        }
        return rtnval;
    }
}
