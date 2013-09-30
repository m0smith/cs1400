
package review1;

/**
 *
 * @author Matthew Smith
 */
public class Guess {
    // We need a name and a guess
    
    private String name;
    private float guess;
    
    public Guess(String newName) {
        name = newName;
        guess = -1;
    }
    
    public void setName(String newName) {
        name = newName;
    }
    
    public void setGuess(double newGuess){
        guess = (float) newGuess;
    }
    
    public String getName() {
        return name;
    }
    
    public double getGuess() {
        return guess;
    }
    
    public void dumpContents() {
        System.out.printf("Name: %s Guess: %f\n", name, guess);
    }
}
