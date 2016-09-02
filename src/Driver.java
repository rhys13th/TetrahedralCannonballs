//@author: Kirtwinder Gulati

//Java.util is used for the scanner
import java.util.*;

/**  Problem Definition: Given the number of cannonballs on each side of the base, calculate the total number of cannonballs in the entire
 *      tetrahedral stack
 *   Input: The first line contains "n", giving the number of tetrahedral problems posed, for a maximum of 100 problems.
 *      Following that are exactly "n" lines, each with a single number giving the number of cannonballs on each side
 *      of the base, a positive integer from 0 to 100, not inclusive.
 *   Output: The problem number, followed by a colon(:), a blank space, the number of cannonballs on each side of the
 *      base, another blank space, and the total number of cannonballs in the tetrahedron.
 */

//First, let's make our important things
public class Driver
{
    //like our variables. While they could be local variables, this makes them easier for me to keep track of
    private static int problemsToSolve = 0;
    private static int sizeofBase;
    //We also create a scanner to read from the console
    private static Scanner myScanner = new Scanner(System.in);

    //main is where everything happens, but we still want to break up some of the bulkier functions to make it easier
    //to read
    public static void main(String[] args)
    {
        //The first int according to the problem definition is how many problems we have to solve
        problemsToSolve = myScanner.nextInt();
        //Since we only print the answers at the end, we make an array to hold them
        String[] myAnswers = new String[problemsToSolve];
        //Now, we do the same thing for each problem, so might as well loop it
        for(int i = 1; i <= problemsToSolve; i++)
        {
            //Each line after problemsToSolve has the size of the base
            sizeofBase = myScanner.nextInt();
            //And we can add the formatted answer in directly, since we make a function do the actual math for us
            myAnswers[i-1] = (i + ": " + sizeofBase + " " + loopedArea(sizeofBase));
        }
        printAnswers(myAnswers);
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
            //This is the lazy way of counting cannonballs in each row; if the row has 2 on the base, it has 2 + 1 = 3
            //if it had 4 cannonballs on one side, that's 4 + 3 + 2 + 1 = 10 cannonballs total in that row
            for(int j = i; j > 0; j--)
            {
                area += j;
            }
        }
        //and return that end sum
        return area;
    }

    //Simple function to print from the answers array
    private static void printAnswers(String[] answers)
    {
        for(int i = 0; i < answers.length; i++)
        {
            System.out.println(answers[i]);
        }
    }
}
