/**
 * Group 08
 * Class Code and Course Number: 9301 - CS 122
 * Schedule: TF 9:00 - 10:30 AM
 *     LACANILAO, Marvin Patrick D. -2230153
 *     DE TORRES, John Rey I. -2234944
 *     DELIZO, John Marco -2234758
 *     LIMBOC, Trixie Mae W. - 2233674
 *     RAGUDOS, Hannah T.- 2233361
 *     ROXAS, Johan Rickardo A. - 2233375
 * </p>
 * The MixedFraction class.
 * This class was made by:
 * <p>
 *     LIMBOC, Trixie Mae W. - 2233674
 *     RAGUDOS, Hannah T.- 2233361
 */

package edu.slu.prog2.midgroup08;

import edu.slu.prog2.pregroup08.Fraction;

public class MixedFraction extends Fraction {

    // object field
    private int wholeNumber; // holds the whole number for MixedFraction class

    /**
     * Construct a default mixed fraction with whole = 0
     */
    public MixedFraction() {
        super();
        wholeNumber = 0; // numerator and denominator are already from Fraction class
    }

    /**
     * Constructs a mixed fraction with a given whole number part and fraction part
     * @param wholeNumber The whole number of the mixed fraction
     * @param fraction The fraction part of the mixed fraction
     */
    public MixedFraction(int wholeNumber, Fraction fraction) {
        setNumerator(fraction.getNumerator());
        setDenominator(fraction.getDenominator());
        this.wholeNumber = wholeNumber;
    }

    /**
     * Constructs a Mixed Fraction using the explicit whole, numerator, and denominator values
     * @param wholeNumber The whole number of the mixed fraction
     * @param numerator The numerator of the mixed fraction
     * @param denominator The denominator of the mixed fraction
     * @throws IllegalArgumentException if wholeNumber is negative or if numerator and denominator have different signs
     */
    public MixedFraction(int wholeNumber, int numerator, int denominator) throws IllegalArgumentException {
        super(numerator, denominator);
        if (wholeNumber < 0) {
            throw new IllegalArgumentException("Whole number must be non-negative.");
        }
        if ((numerator >= 0 && denominator < 0) || (numerator < 0 && denominator >= 0)) {
            throw new IllegalArgumentException("Numerator and denominator must have the same sign.");
        }
        this.wholeNumber = wholeNumber;
    } // end of MixedFraction constructor

    /**
     * Constructs a Mixed Fraction using an explicit fraction value
     * @param fraction The value of the mixed fraction without a whole number
     */
    public MixedFraction(Fraction fraction) {
        super(fraction.getNumerator(), fraction.getDenominator());
        this.wholeNumber = 0;
    } // end of MixedFraction default constructor


    /**
     * Setter/Mutator Method
     * Sets the value of the whole of this mixed fraction to whole
     * @param wholeNumber The whole number to be assigned
     */
    public void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    } // end of setWholeNumber mutator method

    /**
     * Setter/Mutator Method
     * Sets the value of the numerator and denominator to fraction part
     * @param fraction The fraction to be assigned
     */
    public void setFractionPart(Fraction fraction) {
        super.setNumerator(fraction.getNumerator());
        super.setDenominator(fraction.getDenominator());
    } // end of setFractionPart mutator method


    /**
     * Accessor/Getter Method
     * @return The value of the whole of this mixed fraction
     */
    public int getWholeNumber() {
        return wholeNumber;
    } // end of getWholeNumber accessor method

    /**
     * Accessor/Getter Method
     * @return The fraction part of this mixed fraction
     */
    public Fraction getFractionPart() {
        Fraction value = new Fraction();
        value.setNumerator(getNumerator());
        value.setDenominator(getDenominator());
        return value;
    } // end of getFractionPart accessor method

    /**
     * Accessor/Getter Method
     * @return The value of the fraction part of this mixed fraction
     */
    public Fraction toFraction() {
        Fraction value = new Fraction();
        value.setNumerator(getWholeNumber() * getDenominator() + getNumerator());
        value.setDenominator(getDenominator());
        return value;
    } // end of toFraction accessor method


    /**
     * Converts the given improper fraction string to a mixed fraction string.
     * @param mixedFraction the improper fraction string to be converted to a mixed fraction string
     * @return the resulting mixed fraction string
     * @throws IllegalArgumentException if the given string is not a valid improper fraction
     */
    public static String convertToImproper(String mixedFraction) throws IllegalArgumentException {
        String[] parts = mixedFraction.split("/");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid fraction: " + mixedFraction);
        }
        try {
            int wholeNumber = Integer.parseInt(parts[0]);
            int numerator = Integer.parseInt(parts[1]);
            int denominator = 1;
            if (wholeNumber < 0) {
                numerator *= -1;
            }
            numerator += (Math.abs(wholeNumber) * denominator);
            return numerator + "/" + denominator;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid fraction: " + mixedFraction, e);
        }
    } // end of convertToImproper method

    /**
     * Converts the given improper fraction string to a mixed fraction string.
     * @param improperFraction the improper fraction string to be converted to a mixed fraction string
     * @return the resulting mixed fraction string
     * @throws IllegalArgumentException if the given string is not a valid improper fraction or if the denominator is zero
     */
    public static String convertToMixedNumbers(String improperFraction) throws IllegalArgumentException {
        String[] parts = improperFraction.split("/");  // split the fraction into numerator and denominator
        if (parts.length != 2) {  // check that the fraction is in the correct format
            throw new IllegalArgumentException("Invalid fraction format: " + improperFraction);
        }
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);

        if (denominator == 0) {  // check for division by zero
            throw new IllegalArgumentException("Cannot divide by zero.");
        }

        int wholeNumber = numerator / denominator;
        int remainder = numerator % denominator;

        if (remainder == 0) {  // check for whole number fraction
            return Integer.toString(wholeNumber);
        } else {
            return wholeNumber + " " + Math.abs(remainder) + "/" + denominator;
        }
    } // end of convertToMixedNumbers method

    /**
     * Adds the Fraction1 addend and Fraction2 addend.
     * Method overridden from FractionArithmetic.
     * @param addend Fraction 2
     * @return simplified sum of Fraction 1 and Fraction 2.
     */
    @Override
    public Fraction add(Fraction addend) {
        return super.add(addend);
    } // end of overridden add method

    /**
     * Adds a MixedFraction object and a Fraction object and returns a new MixedFraction object as the sum.
     * @param addend the MixedFraction object to be added
     * @return the sum of the two numbers as a new MixedFraction object
     */
    public MixedFraction add(MixedFraction addend) {
        MixedFraction result = new MixedFraction(); //creating a new object
        result.setWholeNumber(getWholeNumber() + addend.getWholeNumber());
        Fraction fPart;
        fPart = getFractionPart().add(addend.getFractionPart());
        result.setDenominator(fPart.getDenominator());
        result.setNumerator(fPart.getNumerator());
        return result;
    } // end of add method

    /**
     * Overrides the subtract method of the Fraction class to subtract a given
     * Fraction object from this Fraction object.
     * @param subtrahend the Fraction object to subtract from this object
     * @return the result of the subtraction as a Fraction object
     */
    @Override
    public Fraction subtract(Fraction subtrahend) {
        return super.subtract(subtrahend);
    } // end of overridden subtract method

    /**
     * Subtracts a MixedFraction object and a Fraction object from this MixedFraction
     * object, and returns the result as a new MixedFraction object.
     * @param subtrahend the MixedFraction object to subtract from this MixedFraction object
     * @return the result of the subtraction as a new MixedFraction object
     */
    public MixedFraction subtract(MixedFraction subtrahend) {
        MixedFraction result = new MixedFraction(); //creating a new object
        Fraction fraction1 = toFraction();
        Fraction fraction2 = subtrahend.toFraction();
        result.setNumerator(fraction1.getNumerator() * fraction2.getDenominator() -
                fraction1.getDenominator() * fraction2.getNumerator());
        result.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());
        result.setWholeNumber(result.getNumerator() / result.getDenominator());
        result.setNumerator(result.getNumerator() - result.getWholeNumber() *
                result.getDenominator());
        result.setNumerator(Math.abs(result.getNumerator()));
        return result;
    } // end of subtract method

    /**
     * Overrides the multiplyBy method in Fraction class to return a Fraction object that is the
     * product of this Fraction and a given multiplicand.
     * @param multiplicand the fraction to multiply this fraction by
     * @return a Fraction object that is the product of this Fraction and the given multiplicand
     */
    @Override
    public Fraction multiplyBy(Fraction multiplicand) {
        return super.multiplyBy(multiplicand);
    } // end of overridden multiplyBy method

    /**
     * Multiplies two MixedFraction objects and returns the result as a MixedFraction object.
     * Assumes valid input with non-negative whole number, and positive numerator and denominator values.
     * @param multiplier the first MixedFraction to multiply
     * @return the product of the two MixedFraction objects as a new MixedFraction object
     */
    public MixedFraction multiplyBy (MixedFraction multiplier) {
        MixedFraction result = new MixedFraction(); //creating a new object
        Fraction fraction1 = toFraction();
        Fraction fraction2 = multiplier.toFraction();
        result.setNumerator(fraction1.getNumerator() * fraction2.getNumerator());
        result.setDenominator(fraction1.getDenominator() * fraction2.getDenominator());
        result.setWholeNumber(result.getNumerator() / result.getDenominator());
        result.setFractionPart(new Fraction(result.getNumerator() -
                result.getWholeNumber() * result.getDenominator(), result.getDenominator()).reduce());
        return result;
    } // end of multiplyBy method

    /**
     * Overrides the divideBy method of the parent class, and returns the result of dividing
     * this Fraction object by the given dividend Fraction object.
     * @param dividend the Fraction object to divide this object by
     * @return the result of dividing this object by the given dividend object
     */
    @Override
    public Fraction divideBy(Fraction dividend) {
        return super.divideBy(dividend);
    } // end of overridden divideBy method

    /**
     * Divides two MixedFraction objects and returns the result as a MixedFraction object.
     * Assumes valid input with non-negative whole number, and positive numerator and denominator values.
     * @param divisor  the first MixedFraction to divide
     * @return the quotient of the two MixedFraction objects as a new MixedFraction object
     */
    public MixedFraction divideBy(MixedFraction divisor) {
        MixedFraction result = new MixedFraction(); //creating a new object
        Fraction fraction1 = toFraction();
        Fraction fraction2 = divisor.toFraction();
        result.setNumerator(fraction1.getNumerator() * fraction2.getDenominator());
        result.setDenominator(fraction1.getDenominator() * fraction2.getNumerator());
        result.setWholeNumber(result.getNumerator() / result.getDenominator());
        result.setFractionPart(new Fraction(result.getNumerator() -
                result.getWholeNumber() * result.getDenominator(), result.getDenominator()).reduce());
        return result;
    } // end of divideBy method

    /**
     * Overrides the reduce method of the superclass Fraction, and returns a reduced Fraction object.
     * @return a reduced Fraction object
     */
    @Override
    public Fraction reduce() {
        return super.reduce();

    } // end of overridden reduce method

    /**
     * Computes the Mixed Fraction by multiplying the whole number with the denominator and
     * adding its product to the numerator.
     * Converts the mixed fraction to decimal form
     *
     * @return mixed fraction converted to decimal
     */
    public double toDouble() {
        Fraction result = toFraction(); //get the fraction part
        return result.toDouble();
        } // end of toDouble method


    /**
     * Concatenates the whole number, numerator, and denominator of Fraction.
     * Returns a string representation of this mixed fraction.
     * @return a string representation of this mixed fraction
     */
    @Override
    public String toString() {
        String result;
        if (getNumerator() == 0) {
            result = Integer.toString(wholeNumber);
        } else if (Math.abs(wholeNumber) > 0) {
            result = wholeNumber + "_" + getFractionPart().toString();
        } else {
            result = super.toString();
        }

        // wholeNumEval type of code


        /* This code block is checking if the fraction is an improper fraction (where the numerator is greater than or equal to the denominator), and if so, it converts it into a mixed fraction format. It does this by calculating the whole number portion of the mixed fraction and the new numerator (the remainder) after dividing the numerator by the denominator. It then creates a new MixedFraction object using the new numerator and the original denominator, and converts it to a string to be concatenated with the whole number portion and an underscore. */
        if (getNumerator() >= getDenominator()) {
            int wholeNum = getNumerator() / getDenominator();
            int newNum = getNumerator() % getDenominator();
            result = wholeNum + "_" + new MixedFraction(new Fraction(newNum, getDenominator())).toString();
        }
        return result;
    } // end of toString method
} // end of class MixedFraction

