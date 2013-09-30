/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game1400;

/**
 * NEVER USE floats for MONEY!!!!!!!!
 * @author lpmsmith
 */
public class Floats {
    public static void main(String[] args){
        double f = 100001.0;
        float ff = 100001.0F;
        int i = (int) f;
        System.out.printf("int: %d%n", i);
        System.out.printf("DOUBLE: %f is %f%n", f, (5.0/9.0 * (f - 32.0)));
        System.out.printf("DOUBLE CAST: %f is %f%n", f, (float) (5.0/9 * (f - 32)));
        System.out.printf("FLOAT: %f is %f%n", ff, (5.0F/9.0F * (ff - 32)));
        System.out.printf("BROKEN: %f is %f%n", ff, 5/9 * (ff - 32));
        
        int i2 = Integer.parseInt("69",16);
        System.out.println(Integer.toString(i2));
        
    }
    
}
