/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game1400;

/**
 *
 * @author Smith
 */
class Score {
    
    private char name1;
    private char name2;
    private char name3;
    
    private int wins1 = 0;
    private int wins2 = 0;
    private int wins3 = 0;

    Score(char n1, char n2, char n3) {
        name1 = n1;
        name2 = n2;
        name3 = n3;
    }
    
    public String display() {
        return String.format("%c wins: %d %c wins: %d %c wins: %d", name1, wins1, name2, wins2, name3, wins3);
    }

    public int addWin(char n) {
        if(n == name1) {
            return ++wins1;
        } else if(n == name2) {
            return ++wins2;
        } else if(n == name3) {
            return ++wins3;
        } else {
            return -1;
        }
        
    }
}
