// class to test out the Kaprekar scheme that will be 
// implemented in the Kaprekar lab. Students may modify
// the code below to test out individual methods, but
// the code is originally set up to test out known
// behavior.

import java.util.ArrayList;
import java.util.Scanner;

public class KaprekarTest {
    public static void main(String[] args) {
        // the number of digits to use. Change as needed.
        // if numDigits is 4, for example, all numbers will be
        // treated as 4-digit numbers, even if they must be
        // "padded" with leading zeroes.
        Scanner scan = new Scanner(System.in);

        // we will consider values in [first, last]
        int first = 0, last = 9999;


        System.out.print("Enter Integer you want to test: ");
        // N can be any integer
        int N = scan.nextInt(), result, result1, result2, result3, result4;
        ArrayList<Integer> result5 = new ArrayList<>();
        System.out.print("Enter length of digits you wish: ");
        int numDigits = scan.nextInt();
        System.out.println(numDigits);

        //N can be any integer
        try{
            result = NumericalTools.getKaprekar(N, numDigits);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        //defines the max # of iterations
        int maxIterations1 = 1000;

        // let N be any random integer in [0, 10^numDigits)
        //N = (int) (Math.pow(10, numDigits) * Math.random());

        // compute the Kaprekar number of N and print it
        
        System.out.println("number being tested = " + N);

        System.out.println();

        result1 = NumericalTools.getAlpha(N,numDigits);
        System.out.println("getAlpha result = " + result1);

        result2 = NumericalTools.getBeta(N,numDigits);
        System.out.println("getBeta result = " + result2);
        result = NumericalTools.getKaprekar(N, numDigits);
        System.out.println("kaprekar number = " + result);
        System.out.println();

        result3 = NumericalTools.kIterate(N,numDigits,maxIterations1);
        System.out.println("final result  = " + result3);

        result4 = NumericalTools.numDigits(N);
        System.out.println("numDigits result = " + result4);

        result5 = NumericalTools.getDigits(N);
        System.out.println("getDigits result = " + result5);
        
        //result = NumericalTools.getKaprekar(N,numDigits);
        //System.out.printf("Kaprekar(%1d) = %1d\n", N, result);

    }
}
