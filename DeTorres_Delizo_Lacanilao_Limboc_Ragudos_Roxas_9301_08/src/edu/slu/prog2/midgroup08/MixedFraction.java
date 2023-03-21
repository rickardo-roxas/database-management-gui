/**
 * Group 8
 * Class Code and Course Number: 9301 - CS 122
 * Schedule: TF 9:00 - 10:30 AM
 * <p>
 *     LACANILAO, Marvin Patrick D. - 2230153
 *     DE TORRES, John Rey I. - 2234944
 *     DELIZO, John Marco - 2234758
 *     LIMBOC, Trixie Mae W. - 2233674
 *     RAGUDOS, Hannah T.- 2233361
 *     ROXAS, Johan Rickardo A. - 2233375
 * </p>
 * The MixedFraction class.
 * This class was made by:
 * <p>
 *     LIMBOC, Trixie Mae W. - 2233674
 *     RAGUDOS, Hannah T.- 2233361
 *     ROXAS, Johan Rickardo A. - 2233375
 * </p>
 */
package edu.slu.prog2.midgroup08;

import edu.slu.prog2.pregroup08.Fraction;

public class MixedFraction extends Fraction {
    private int wholeNumber; // holds the whole number for MixedFraction

    /**
     * Constructs a default MixedFraction with whole number = 0
     */
    public MixedFraction() {
        super();
        wholeNumber = 0;
    } // end of MixedFraction default constructor

    /**
     * Constructs a MixedFraction with a given whole number and given Fraction
     * @param wholeNumber Given whole number
     * @param fraction Given Fraction
     */
    public MixedFraction(int wholeNumber, Fraction fraction) {
        super(fraction.numerator, fraction.denominator);
        this.wholeNumber = wholeNumber;
    } // end of MixedFraction constructor

    /**
     * Constructs a MixedFraction with a given whole number and given numerator and given denominator.
     * @param wholeNumber given whole number
     * @param numerator given numerator
     * @param denominator given denominator
     */
    public MixedFraction(int wholeNumber, int numerator, int denominator) {
        this.wholeNumber = wholeNumber;
        this.numerator = numerator;
        this.denominator = denominator;
    } // end of MixedFraction constructor

    /**
     * Constructs a MixedFraction with a given Fraction
     * @param fraction Fraction with numerator and denominator
     */
    public MixedFraction(Fraction fraction) {
        super(fraction.numerator, fraction.denominator);
    } // end of MixedFraction constructor

    /**
     * Mutator method for the whole number attribute.
     * Sets the value of the whole number of MixedFraction to given whole number
     * @param wholeNumber given whole number.
     */
    public void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    } // end of setWholeNumber mutator method

    /**
     * Mutator method for Fraction.
     * Sets the value of the numerator and denominator of Fraction.
     * @param fraction given Fraction
     */
    public void setFractionPart(Fraction fraction) {
        super.setNumerator(fraction.numerator); // invokes setNumerator of the parent class
        super.setDenominator(fraction.denominator); // invokes setDenominator of the parent class
    } // end of setFractionPart mutator method

    /**
     * Accessor method for the whole number attribute.
     * Returns the value of the whole number of MixedFraction.
     * @return value/state of whole number.
     */
    public int getWholeNumber() {
        return wholeNumber;
    } // end of getWholeNumber accessor method

    /**
     * Accessor method for Fraction.
     * Returns the respective value of numerator and denominator of Fraction.
     * @return value/state of whole number
     */
    public Fraction getFractionPart() {
        Fraction fraction = new Fraction();
        fraction.numerator = getNumerator();
        fraction.denominator = getDenominator();
        return fraction;
    } // end of getFractionPart accessor method

    /**
     * Converts the MixedFraction to an improper fraction in the form:
     * <p>
     *     wholeNumber numerator/denominator = numerator/denominator.
     * </p>
     * Formula:
     * <p>
     *     numerator = (whole number * denominator) + numerator
     * </p>
     * @return improper from Fraction of MixedFraction
     */
    public Fraction toFraction() {
        // Get the whole number, numerator, and denominator of the mixed fraction
        int wholeNumber = getWholeNumber();
        int numerator = getNumerator();
        int denominator = getDenominator();

        // Calculate the numerator of the improper fraction
        numerator = (wholeNumber * denominator) + numerator;

        // Create a new Fraction object with the calculated numerator and denominator
        Fraction improperFraction = new Fraction(numerator, denominator);

        // Return the new Fraction object
        return improperFraction;
    } // end of toFraction method

    /**
     * Concatenates the attributes of MixedFraction to String.
     * String form:
     * <p>
     *     wholeNumber numerator/denominator
     * </p>
     * This method was made by ROXAS, Johan Rickardo - 2233375
     * @return mixed number
     */
    public String toString() {
        if (getWholeNumber() == 0 && getNumerator() == 0 && getDenominator() == 1)
            return "0";
        else if (getWholeNumber() == 0 && getNumerator() != 0 && getDenominator() == 1)
            return String.valueOf(getNumerator());
        else if (getWholeNumber() != 0 && getNumerator() == 0 && getDenominator() == 1)
            return String.valueOf(getWholeNumber());
        else if (getWholeNumber() != 0 && getNumerator() != 0 && getDenominator() == 1)
            return String.valueOf((getWholeNumber() + getDenominator()));
        else if (getWholeNumber() == 0 && getNumerator() != 0 && getDenominator() != 0)
            return getNumerator() + "/" + getDenominator();
        else if (getWholeNumber() != 0 && getNumerator() != 0 && getDenominator() == 0)
            return "Undefined (denominator is 0)";
        return getWholeNumber() + " " + getNumerator() + "/" + getDenominator();
    } // end of overridden toString method

    /**
     * Converts MixedFraction to decimal.
     * <p>
     *     The whole number is set as it is.
     *     The numerator is divided by the denominator.
     *     The whole number is added to the quotient of the numerator and denominator.
     * </p>
     * @return MixedFraction as decimal
     */
    public double toDouble() {
        int wholeNumber = this.wholeNumber;
        double decimal = (double) getNumerator() / getDenominator();
        return (double) wholeNumber + decimal;
    } // end of overridden toDouble method

    /**
     * Adds the Fraction1 addend and Fraction2 addend.
     * Method from Fraction class.
     * @param addend Fraction 2
     * @return simplified sum of Fraction1 and Fraction2
     */
    @Override
    public Fraction add(Fraction addend) {
        return super.add(addend);
    } // end of add method

    /**
     * Adds the MixedFraction addend to the MixedFraction addend.
     * MixedFraction1 and MixedFraction2 are converted to improper fractions.
     * Invokes the Override add method from Fraction class.
     * @param addend MixedFraction 2
     * @return sum in mixed number form.
     */
    public MixedFraction add(MixedFraction addend) {
        Fraction fraction1 = this.toFraction(); // converts MixedFraction1 to improper fraction
        Fraction fraction2 = addend.toFraction(); // converts MixedFraction2 to improper fraction
        Fraction sum = fraction1.add(fraction2); // invokes add method from Fraction class
        return sum.toMixedFraction(); // converts sum to mixed number
    } // end of overridden add method

    /**
     * Subtracts Fraction1 and Fraction2 using the subtract method from Fraction class
     * Method from Fraction class.
     * @param subtrahend Fraction 2
     * @return simplified/reduced difference of Fraction1 and Fraction2
     */
    @Override
    public Fraction subtract(Fraction subtrahend) {
        return super.subtract(subtrahend);
    } // end of subtract method

    /**
     * Subtracts the MixedFraction minuend to the MixedFraction subtrahend.
     * MixedFraction1 and MixedFraction2 are converted to improper fractions.
     * Invokes the Override subtract method from Fraction class.
     * @param subtrahend MixedFraction2.
     * @return difference in mixed number form.
     */
    public MixedFraction subtract(MixedFraction subtrahend) {
        Fraction fraction1 = this.toFraction(); // converts MixedFraction1 to improper fraction
        Fraction fraction2 = subtrahend.toFraction(); // converts MixedFraction2 to improper fraction
        Fraction difference = fraction1.subtract(fraction2); // invokes add method from Fraction class
        return difference.toMixedFraction(); // converts difference to mixed number
    } // end of overridden subtract method

    /**
     * Multiplies the Fraction multiplier by the Fraction multiplicand.
     * Method from Fraction class.
     * @param multiplicand Fraction 2
     * @return simplified product of Fraction1 and Fraction2
     */
    @Override
    public Fraction multiplyBy(Fraction multiplicand) {
        return super.multiplyBy(multiplicand);
    } // end of multiplyBy method

    /**
     * Multiplies the MixedFraction multiplier to the MixedFraction multiplicand.
     * MixedFraction1 and MixedFraction2 are converted to improper fractions.
     * Invokes the Override multiplyBy method from Fraction class.
     * @param multiplicand MixedFraction2.
     * @return product in mixed number form.
     */
    public MixedFraction multiplyBy(MixedFraction multiplicand) {
        Fraction fraction1 = this.toFraction(); // converts MixedFraction1 to improper fraction
        Fraction fraction2 = multiplicand.toFraction(); // converts MixedFraction2 to improper fraction
        Fraction product = fraction1.multiplyBy(fraction2); // invokes add method from Fraction class
        return product.toMixedFraction(); // converts difference to mixed number
    } // end of multiplyBy overridden method

    /**
     * Divides the Fraction dividend by the Fraction divisor.
     * Method from Fraction class.
     * @param dividend Fraction 2
     * @return simplified quotient of Fraction 1 and Fraction 2.
     */
    @Override
    public Fraction divideBy(Fraction dividend) {
        return super.divideBy(dividend);
    } // end of divideBy method

    /**
     * Divides the MixedFraction divisor to the MixedFraction dividend.
     * MixedFraction1 and MixedFraction2 are converted to improper fractions.
     * Invokes the Override divideBy method from Fraction class.
     * @param dividend MixedFraction2
     * @return quotient in mixed number form.
     */
    public MixedFraction divideBy(MixedFraction dividend) {
        Fraction fraction1 = this.toFraction(); // converts MixedFraction1 to improper fraction
        Fraction fraction2 = dividend.toFraction(); // converts MixedFraction2 to improper fraction
        Fraction quotient = fraction1.divideBy(fraction2); // invokes divideBy method from Fraction class
        return quotient.toMixedFraction(); // converts quotient to mixed number
    } // end of overridden divideBy method
} // end of class MixedFraction
