// implements a rational number custom datatype, or class.
// DESIGN NOTES from 1/6 class meeting:
// A. FIELDS: (always private)
//    a numerator and a denominator, both integers
//    we will store the sign (positive or negative)
//    in the numerator, and the denominator will ALWAYS be positive
// B. CONSTRUCTORS: (public)
//    A default that will create the Fraction representation of zero
//    One that takes as input a numerator and a denominator (ROBUST!)
//    One that takes as input an integer 
//    One that takes another Fraction as input
//   NOTE: constructors will ALWAYS put the Fraction in simplest form, and
//   will force the sign (+ or -) to be stored in the numerator field
//   We will also force all constructors to farm out the work to the robust
//   (aka workhorse) constructor above
// C. methods (mix of public and private)
//    public toString(): override of inherited method from Object
//    arithmetic methods, all public:
//      add, subtract, multiply, and divide
//    getters for both fields (public)
//    private helpers:
//      simplify
//      gcd
//      lcd
//    comparison methods, including equals...

public class Fraction implements Comparable<Fraction> {
    // instance fields go here
    private int num, denom;

    // constructors go here
    public Fraction() {
        // this.num = 0; //
        this.denom = 1;
        // if you don't initialize an instance field it gets a default value (0)

    }

    // precondition: D is non-zero
    public Fraction(int N, int D) {
        // iof d is negative we want N to flip
        if (D < 0) {
            N = -N;
            D = -D;
        }
        num = N;
        denom = D;
        simplify();

    }

    private void simplify() {
        // simplify should look for the greastes tcommon factor
        // of the two numbers (num and denom) and then divide both
        // by that factor and make that the two new num and denom
        // the greatest common divsor is 1
        // 1. find the gcd of [num] and denom and store in variabe D
        int D = gcd(Math.abs(num), denom);
        // 2. set num to num/D and denom to denom/D
        num /= D;
        denom /= D;

    }

    // put a comment in the beginning
    // that tells what it's going to do
    // get in habit of writing commentary
    private int gcd(int N, int D) { // would not get java docked because it's private
        int A = Math.max(N, D);
        int B = Math.min(N, D);

        int R = A % B;
        if (R == 0) {
            return B;
        }

        return gcd(R, B);
    }

    public Fraction(int n) {
        this(n, 1);
    }

    public int getNumerator() {
        return num;
    }

    public int getDenominator() {
        return denom;
    }

    public Fraction multiply(Fraction f) {
        int newnum = this.getNumerator() * f.getNumerator();
        int newden = this.getDenominator() * f.getDenominator();
        return new Fraction(newnum, newden);

    }

    public Fraction divide(Fraction f) {
        int newnum = this.getNumerator() * f.getDenominator();
        int newden = this.getDenominator() / f.getNumerator();
        return new Fraction(newnum, newden);
    }

    public Fraction add(Fraction f) {
        int L = lcd(this.num, f.denom);
        int numb = ((this.num * L / this.denom) + f.num * L / f.denom);
        int denomb = L;
        return new Fraction(numb, denomb);

    }

    public Fraction add(int N){
        return this.add(new Fraction(N));
    }

    public Fraction subtract(int N){
        return this.subtract(new Fraction(N));
    }

    public Fraction subtract(Fraction f) {
        int L = lcd(this.num, f.denom);
        int numb = ((this.num * L / this.denom) - f.num * L / f.denom);
        int denomb = L;
        return new Fraction(numb, denomb);

    }

    private int lcd(int D1, int D2) {
        return (D1 * D2) / gcd(D1, D2);
    }

    // a class does not HAVE to have instance constructor method//can be inherited

    // methods go here
    public boolean lessThan(Fraction other){
        return compareTo(other) < 0;
    }

    public boolean leq(Fraction other){
        return this.compareTo(other) <= 0;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Fraction){
            Fraction other = (Fraction) o;
            return compareTo(other) == 0;
        }
        return false;
    }

    @Override
    public int compareTo(Fraction other){
        return num * other.denom - denom * other.num;
    }

    @Override
    public String toString() {
        String result;
        if (denom == 1) {
            result = num + "";
        } else {
            result = String.format("%1d/%1d", num, denom);
        }
        return result;

    }

}

// gcd prep
// if N < D{
// int tempN = D;
// N = D;
// D = tempN;
// }
// while (D != 0) {
// int temp = D;
// D = N % D;
// N = temp;
// }
// return N;

// public static void main(String[] args) {
// int num1 = 56;
// int num2 = 98;
// int gCd = gcd(num1, num2);
// System.out.println("The GCD of " + num1 + " and " + num2 + " is: " + gCd);