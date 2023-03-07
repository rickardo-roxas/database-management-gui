/**
 * Group 9
 * Class code and course number: 9301B - CS 122
 * Schedule: TF 9:00 - 10:30 AM
 * <p>
 *     RABANG, Gebreyl Isaac P.
 *     RAGUDOS, Hannah T.
 *     RAMOS, Jerwin Kyle R.
 *     ROQUE, Rey Daniel L.
 *     ROXAS, Johan Rickardo A.
 * </p>
 * The Fraction class.
 * A template for a fraction that has the form numerator/denominator.
 */
package fraction;

public class Fraction {
    public int numerator; // holds the numerator for Fraction
    public int denominator; // holds the denominator for Fraction

    /**
     * Default constructor of Fraction class.
     * <p>
     *     Default numerator = 0;
     *     Default denominator = 1;
     *     Default Fraction = 0/1
     * </p>
     */
    public Fraction() {
        numerator = 0;
        denominator = 1;
    } // end of Fraction default constructor

    /**
     * Constructor of the Fraction class.
     * Assigns the state of Fraction attributes during Fraction instantiation
     * @param numerator given numerator
     * @param denominator given denominator
     */
    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    } // end of Fraction constructor

    /**
     * Mutator method for the numerator attribute.
     * Sets the value of the numerator of Fraction to n.
     * @param num given numerator
     **/
    public void setNumerator(int num) {
        numerator = num;
    } // end of setNumerator mutator method

    /**
     * Accessor method for the numerator attribute.
     * Returns the value of the numerator of Fraction.
     * @return value/state of numerator.
     */
    public int getNumerator() {
        return numerator;
    } // end of getNumerator accessor method

    /**
     * Mutator method for the denominator attribute.
     * Sets the value of the denominator of Fraction to d.
     * @param den given denominator.
     */
    public void setDenominator(int den) {
        denominator = den;
    } // end of setDenominator mutator method

    /**
     * Accessor method for the denominator attribute.
     * Returns the value of the denominator of Fraction.
     * @return value/state of denominator.
     */
    public int getDenominator() {
        return denominator;
    } // end of getDenominator accessor method

    /**
     * Concatenates the numerator and denominator of Fraction.
     * @return fraction as String
     */
    public String toString() {
        return getNumerator() + "/" + getDenominator();
    } // end of toString method

    /**
     * Converts the Fraction by dividing the numerator and denominator.
     * @return reduced fraction converted to decimal
     */
    public double toDouble() {
        return (double) getNumerator() / getDenominator();
    } // end of toDouble method

    /**
     * Computes for the greatest common divisor of two numbers.
     * This method uses the Euclid's Algorithm and iteration:
     * <p>
     *     a: first number
     *     b: second number
     *     c: divisor
     *     GCD = a / b = c
     *      If c = 0
     *          divisor = second number
     *       Else
     *          a = b
     *          b = c
     * </p>
     */
    private int computeGCD(int num1, int num2) {
        int a = num1;
        int b = num2;
        int c = 0;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        } // end of while
        return a;
    } // end of computeGCD method

    /**
     * Adds the Fraction1 addend and Fraction2 addend.
     * @param addend Fraction 2
     * @return simplified sum of Fraction 1 and Fraction 2
     */
    public Fraction add(Fraction addend) {
        int lCM = computeLCM(getDenominator(), addend.getDenominator()); // least common multiple
        int sumDenominator = lCM; // sets denominator as the least common multiple
        int sumNumerator = (lCM / this.denominator) * (this.numerator) +
                (lCM / addend.getDenominator() * addend.getNumerator());//
        Fraction sum = new Fraction(sumNumerator, sumDenominator);
        return sum.reduce(); // reduces the sum Fraction
    } // end of add method

    /**
     * Subtracts the Fraction minuend with the Fraction subtrahend.
     * @param subtrahend Fraction 2
     * @return simplified difference of Fraction 1 and Fraction 2
     */
    protected Fraction subtract(Fraction subtrahend) {
        int lCM = computeLCM(getDenominator(), subtrahend.getDenominator()); // least common multiple
        int differenceDenominator = lCM; // sets denominator of difference as the least common multiple
        int differenceNumerator = (lCM / this.denominator) * (this.numerator) -
                (lCM / subtrahend.getNumerator() * subtrahend.getNumerator());
        Fraction difference = new Fraction(differenceNumerator, differenceDenominator);
        return difference.reduce(); // reduces the difference Fraction
    } // end of subtract method

    /**
     * Multiplies the Fraction multiplier by the Fraction multiplicand.
     * @param multiplicand Fraction 2
     * @return simplified product of Fraction 1 and Fraction 2
     */
    protected Fraction multiplyBy(Fraction multiplicand) {
        int productDenominator = this.denominator * multiplicand.getDenominator();
        int productNumerator = this.numerator * multiplicand.getNumerator();
        Fraction product = new Fraction(productNumerator, productDenominator);
        return product.reduce();
    } // end of multiplyBy method

    /**
     * Divides the Fraction dividend by the Fraction divisor.
     * @param dividend second Fraction
     * @return simplified quotient of Fraction 1 and Fraction 2
     */
    public Fraction divideBy(Fraction dividend) {
        int quotientDenominator = this.denominator * dividend.getNumerator();
        int quotientNumerator = this.numerator * dividend.getDenominator();
        Fraction quotient = new Fraction(quotientNumerator, quotientDenominator);
        return quotient.reduce();
    } // end of divideBy method

    /**
     * Computes the least common multiple of two numerical values.
     * <p>
     *     a: num1
     *     b: num2
     *     c = a * b
     * </p>
     * @param num1 a
     * @param num2 b
     * @return least common multiple (c)
     */
    private int computeLCM(int num1, int num2) {
        int a = num1;
        int b = num2;
        int c = a * b;
        return c;
    } // end of computeLCM method

    /**
     * Reduces the Fraction to its simplest form using its common greatest divisor
     * @return Fraction in its simplest form
     */
    public Fraction reduce() {
        int GCD = computeGCD(numerator, denominator); // computes the greatest common divisor for given Fraction
        int reducedNumerator = numerator / GCD; // reduces the numerator with the greatest common divisor
        int reducedDenominator = denominator / GCD; // reduces the denominator with the greatest common divisor
        return new Fraction(reducedNumerator, reducedDenominator);
    } // end of reduce method
} // end of class Fraction
