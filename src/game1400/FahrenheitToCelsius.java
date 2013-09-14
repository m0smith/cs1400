
package game1400;

import java.util.Scanner;

/**
 *  DO NOT USE float or double for MONEY!!!
 * Interesting inputs: 0, 100001 12E5 333333E-999 33333E999 1234E88
 * @author Matthew O. Smith
 */
public class FahrenheitToCelsius {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter degrees in Fahrenheit: ");
        double fahrenheit = input.nextDouble();
        
        double celsius = (5.0/9) * (fahrenheit - 32);
        System.out.printf("DOUBLE %%f: Fahrenheit %f is %f in Celsius%n", fahrenheit, celsius);
        System.out.printf("DOUBLE %%e: Fahrenheit %e is %e in Celsius%n", fahrenheit, celsius);
        System.out.printf("DOUBLE %%g: Fahrenheit %g is %g in Celsius%n", fahrenheit, celsius); 
        
        System.out.printf("DOUBLE %%.3f: Fahrenheit %.3f is %.3f in Celsius%n", fahrenheit, celsius);
        System.out.printf("DOUBLE %%.3e: Fahrenheit %.3e is %.3e in Celsius%n", fahrenheit, celsius);
        System.out.printf("DOUBLE %%.3g: Fahrenheit %.3g is %.3g in Celsius%n", fahrenheit, celsius); 
        
        System.out.printf("DOUBLE %%-,20.3f: Fahrenheit %-,20.3f is %-,20.3f in Celsius%n", fahrenheit, celsius);
       
        System.out.printf("DOUBLE %%-,20.3g: Fahrenheit %-,20.3g is %-,20.3g in Celsius%n", fahrenheit, celsius); 
        
        float  f_fahrenheit = (float) fahrenheit;
        float f_celsius =  ((5.0F/9) * (f_fahrenheit - 32));
        float celsiusCast  =  (float) ((5.0/9) * (f_fahrenheit - 32));
        System.out.printf("FLOAT: Fahrenheit %f is %f in Celsius%n", f_fahrenheit, f_celsius);
        System.out.printf("FLOAT (CAST): Fahrenheit %f is %f in Celsius%n", f_fahrenheit, celsiusCast);
        
        double brokenCelsius = (5/9) * (fahrenheit - 32);
        System.out.printf("BROKEN: Fahrenheit %f is %f in Celsius%n", fahrenheit, brokenCelsius);
        
    }
    
}
