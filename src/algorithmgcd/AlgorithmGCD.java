/* 
Kevin Poon n00900355
COT4400 Analysis of Algorithms
Dr. Klostermeyer

This program calculates the average running time for the gcd() recursive method.
Takes input from the user.

Written using Netbeans IDE
*/

package algorithmgcd;
import java.util.*;

public class AlgorithmGCD {

    public static int trial = 1;
    public static int size;
    public static long gcd(long p, long q) {
        if(q == 0)
            return p;
        else    {
            return gcd(q, p % q);
        }
    }//end gcd

    public static long trialDiv(long p, long q) {
        ArrayList<Long> pfactors = new ArrayList<>();
        long gcd = 1;
        for(long i = p; i >= 1; i--) {
            if(p % i == 0)  {
                pfactors.add(i); 
            }
        }
        Collections.sort(pfactors);
        for(long i = q ; i >= 1; i--) { //does not check factors greater than q
            if(q % i == 0)  {
                if(Collections.binarySearch(pfactors, i) >= 0) {
                    gcd = i;
                    break; 
                }
            }
        }
        return gcd;
    }
    public static double testGcd(long p, long q)  {
        long start;
        long end;
        // only includes time spent calculating, not printing
        start = System.nanoTime();
        long result = gcd(p, q);
        end = System.nanoTime();
        long time = end - start;
        
        System.out.println("Trial " + trial + " Time: " + time + " ns");
        return time;
    }
    public static double testTrialDiv(long p, long q)   {
        long start;
        long end;
        
        start = System.nanoTime();
        long result = trialDiv(p, q);
        end = System.nanoTime();
        long time = end - start;
        
        System.out.println("Trial " + trial + " Time: " + time + " ns");
        return time;
    }
    public static void main(String[] args) {
        System.out.println("Enter two numbers separated by a space: ");
        Scanner scan = new Scanner(System.in);
        long p = Long.parseLong(scan.next());
        long q = Long.parseLong(scan.next());
        long temp;
        
        if(q > p)   { //guarantee that p is the larger number
            temp = q;
            q = p;
            p = temp;
        }
 
        System.out.println("---------- GCD algorithm analysis -----------");
        long totalTime = 0;
        long loop = 3;
        
        System.out.println("gcd(" + p + ", " + q + ") = " + gcd(p, q));
        for(int x = 0; x < loop; x++) {
            totalTime += testGcd(p, q);
            trial++;
        }
        double avgTime = totalTime / loop;
        System.out.println("Average time for gcd(): " + avgTime + " ns");
        
        System.out.println("--------- Trial Division Method ----------");
        long start;
        long end;
        /* 
        This algorithm takes much longer than Euclid's. 
        Takes ludicrously long to calculate at 9 digits and up. Switch units to
        microseconds. 
        */
        System.out.print("gcd(" + p + ", " + q + ") = ");
        start = System.nanoTime();
        System.out.println(trialDiv(p, q));
        end = System.nanoTime();
        totalTime = end - start;
        System.out.println("Trial 1 Time: " + totalTime + " ns");
        
        trial = 2;
        for(int x = 1; x < loop; x++) {
            totalTime += testTrialDiv(p, q);
            trial++;
        }
        avgTime = (totalTime/1000) / loop;
        System.out.println("Average time for trialDiv(): " + avgTime + " microseconds");
       
        
    }//end main
    
}
