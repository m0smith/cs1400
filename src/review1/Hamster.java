package review1;

import java.util.Scanner;

public class Hamster {
    
    boolean correct;
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        
        System.out.print("\nEnter first guess: ");
        double num1;
        num1 = input.nextDouble();
        System.out.print("\nEnter second guess: ");
        double num2 = input.nextDouble();
        
        // Name on its own line
        System.out.println(name);
        
        // print Hello World on the same line using 2 statements
        System.out.print("Hello ");
        System.out.println("World");
        
        // Print name, numbers and sum on the same line
        System.out.printf("%s, %f, %f, %,.2f%n", name, num1, num2, num1 + num2);
        
        // Create a guess
        
        Guess guess1 = new Guess("");
        guess1.setName(name);
        guess1.setGuess(num1);
        
        Guess guess2 = new Guess("alice");
        guess2.setGuess(num2);
        
        // Did the user guess the number
        
        double theComputer = 8;
        
        boolean correct = false;
        String winner = "";
        
        if(guess1.getGuess() == theComputer) {
            correct = true;
            winner = guess1.getName();
        }
        
        if(guess2.getGuess() == theComputer) {
            correct = true;
            winner = guess2.getName();
        }
        
        if(correct) {
            System.out.print("You guessed right:");
            System.out.println(winner);
        }
        
        if( correct != true) {
            System.out.println("Try again loser");
        }
        
        
        int top = 11;
        int bottom = 5;
                
        int d = top/bottom;
        int r = top % bottom;
        
        System.out.printf("%d/%d = %d with %d remander\n", top, bottom, d, r);
    }
}
