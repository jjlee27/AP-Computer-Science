
/**
 * Collection of numerical tools that permits an
 * exploration of some interesting properties of
 * the integers.
 * 
 * author: Jason Lee
 * date: 10/07/24
 */

import java.util.Arrays;
import java.util.ArrayList;

public class NumericalTools {

    /**
     * returns the Kaprekar number of N, which is defined as follows:
     * a. if N has fewer than L digits, we "pad" N with enough leading
     * 0's until is has L digits
     * b. create a new number, alpha, that is formed by rearranging
     * the digits of the padded version of N in DESCENDING order
     * c. create another new number, beta, that is formed by rearranging
     * the digits of the padded version of N in ASCENDING order
     * d. return (alpha - beta)
     * <br>
     * precondition: 0 <= N < 10^L
     * 
     * @param N the original number
     * @return the Kaprekar number of N
     */
    public static int getKaprekar(int N, int L) throws IllegalArgumentException {
        if (!(0 <= N && N < Math.pow(10, L))) {
            String errorMessage = String.format("ERROR: %1d not in interval [0, %1d]", N, (int) Math.pow(10, L));
            throw new IllegalArgumentException(errorMessage);
        }
        return getAlpha(N, L) - getBeta(N, L);
    }

    /**
     * iterates N up to maxIterations times, using L as
     * the number of digits to consider. Iterates maxIterations
     * times as long as no point is reached where
     * getKaprekar(X, L) returns X, in which case it stops and
     * returns X.
     * <br>
     * precondition: 0 <= N < 10^L, maxIterations > 0
     * 
     * @param N             the number to iterate
     * @param L             the number of digits to consider
     * @param maxIterations the maximum number of iterations
     * @return the number that N iterates to under the Kaprekar scheme
     */
    public static int kIterate(int N, int L, int maxIterations) {
        // 1. create a int called newN and set it to the
        // Kaprekar number of N using L digits
        int newN = getKaprekar(N, L);

        // 2. create a variable called numIterations and set it to one
        int numIterations = 1;

        // 3. while the number of iterations is less than maxIterations
        // AND N is not equal to newN (the number does not iterate into itself)
        while (numIterations < maxIterations && N != newN) {
            // 3a. set N to newN
            N = newN;

            // 3b. set newN to the Kaprekar number of N using L digits
            newN = getKaprekar(N, L);
            // 3c. increment numIterations by one
            numIterations++;
        }

        // 4. return newN
        return newN;
    }

    /**
     * returns the number of digits in integer N
     * 
     * @param N the number whose digits we are counting
     * @return the number of digits in N
     */
    public static int numDigits(int N) {
        // 1. set N to its own absolute value
        N = Math.abs(N);

        // 2. create the string version of N, called strN
        String strN = Integer.toString(N);

        // 3. return the length of strN
        return strN.length();
    }

    // returns an ArrayList of the digits of N
    // Examples:
    // getDigits(17) returns {1,7}
    // getDigits(307) returns {3,0,7}
    // precondition: N >= 0
    public static ArrayList<Integer> getDigits(int N) {
        // 1. create a String array called digitArray and
        // set it to the string version of N split into an array
        // Hint: use the split method of the String class
        String[] digitArray = Integer.toString(N).split("");

        // 2. create an empty array-list of Integers called digits
        ArrayList<Integer> digits = new ArrayList<>();

        // 3. for each string n in digitArray
        // 3a. add to digits the Integer version of n
        for (String n : digitArray) {
            digits.add(Integer.parseInt(n));
        }

        // 4. return digits
        return digits;
    }

    // returns the number represented by the rearrangement of
    // the digits of N as specified below:
    // a. if N has fewer than L digits, we pad it with leading 0's
    // b. we then rearrange the digits in DESCENDING order
    // Examples:
    // getAlpha(324,4) returns 4320
    // getAlpha(123,4) returns 3210
    // getAlpha(1002, 4) returns 2100
    // precondition: 0 <= N < 10^L
    public static int getAlpha(int N, int L) {
        // 1. create an array-list of Integers called digitList
        // and set it to the list of digits of N (use getDigits)
        ArrayList<Integer> digitList = getDigits(N);
        // *** pad the digitList with 0's if needed ***

        // 2. while the size of the digitList is less than L
        while (digitList.size() < L) {
            // 2a. add a 0 to the list
            digitList.add(0);
        }

        // 3. create an array (not an array-list) of ints called
        // digits of length L
        int[] digits = new int[L];

        // 4. for each entry in digits
        // 4a. set it to the corresponding value in digitList
        for (int i = 0; i < L; i++) {
            digits[i] = digitList.get(i);
        }

        // 5. sort digits (use Arrays.sort)
        Arrays.sort(digits);

        // 6. create a string called num and set to the empty string
        String num = "";

        // 7. for i from (L-1) to 0
        for (int i = L - 1; i >= 0; i--) {
            // 7a. concatenate digits[i] onto num
            num = num + digits[i];
        }

        // 8. return the integer version of num
        return Integer.parseInt(num.toString());
    }

    // returns the number represented by the rearrangement of
    // the digits of N as specified below:
    // a. if N has fewer than L digits, we pad it with leading 0's
    // b. then we rearrange the digits in ASCENDING order
    // Examples:
    // getBeta(324,4) returns 234
    // getBeta(213,4) returns 123
    // getBeta(1002, 4) returns 12
    // precondition: 0 <= N < 10^L
    public static int getBeta(int N, int L) {
        // 1. create an array-list of Integers called digitList
        // and set it to the list of digits of N (use getDigits)
        ArrayList<Integer> digitList = getDigits(N);

        // *** pad the digitList with 0's if needed ***
        // 2. while the size of the digitList is less than L
        while (digitList.size() < L) {
            // 2a. add a 0 to the list
            digitList.add(0);
        }

        // 3. create an array (not an array-list) of ints called
        // digits of length L
        int[] digits = new int[L];

        // 4. for each entry in digits

        for (int i = 0; i < L; i++) {
            // 4a. set it to the corresponding value in digitList
            digits[i] = digitList.get(i);
        }
        // 5. sort digits (use Arrays.sort)
        Arrays.sort(digits);

        // 6. create a string called num and set to the empty string
        String num = "";

        // 7. for i from 0 to L
        for (int i = 0; i < L; i++) {
            // 7a. concatenate digits[i] onto num
            num = num + digits[i];
        }

        // 8. return the integer version of num
        return Integer.parseInt(num.toString());
    }
}
