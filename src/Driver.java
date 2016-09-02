//@author: Kirtwinder Gulati

import java.util.*;

/**  Problem Definition: Given the number of cannonballs on each side of the base, calculate the total number of cannonballs in the entire
 *      tetrahedral stack
 *   Input: The first line contains "n", giving the number of tetrahedral problems posed, for a maximum of 100 problems.
 *      Following that are exactly "n" lines, each with a single number giving the number of cannonballs on each side
 *      of the base, a positive integer from 0 to 100, not inclusive.
 *   Output: The problem number, followed by a colon(:), a blank space, the number of cannonballs on each side of the
 *      base, another blank space, and the total number of cannonballs in the tetrahedron.
 */

public class Driver
{
    private static int problemsToSolve = 0;
    private static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        problemsToSolve = myScanner.nextInt();
        int sizeofBase;
        for(int i = 0; i < problemsToSolve; i++)
        {
            sizeofBase = myScanner.nextInt();
            System.out.println(i + ": " + sizeofBase + " " + loopedArea(sizeofBase));
            System.out.println("The mathematical version says the area is " + mathArea(sizeofBase));
        }
    }

    //The simplest way to find the area of a pyramidical stack is with loops, since the base has n x n cannonballs
    //the next row up has n-1 x n-1 cannonballs and so on so forth until 1 ball at the top.
    private static int loopedArea(int base)
    {
        //create an int for the area, and assign 0 by default
        int area = 0;
        //now, from the base to the last cannonball, decrementing i, we add the area of each row to the total area
        for(int i = base; i > 0; i--)
        {
            area += (i * i);
        }
        //and return that sum
        return area;
    }

    private static int mathArea(int base)
    {
        return ((base * base * base)/3 + (base * base)/2 + (base/6));
    }
}
