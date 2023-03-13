// Duplicate class to clean up MixedFraction class
/**
 * Group 8
 * Class Code and Course Number: CS 122
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
        MixedFraction mixedFraction = new MixedFraction(); // instantiates new MixedFraction
        Fraction fraction = new Fraction(); // instantiates new Fraction

        int wholeNumber = mixedFraction.getWholeNumber(); // gets the whole number of mixedFraction
        int numerator = mixedFraction.getNumerator(); // gets the numerator of mixedFraction
        int denominator = mixedFraction.getDenominator(); // gets the denominator of mixedFraction

        numerator = (wholeNumber * denominator) + numerator; // computes for the numerator of Fraction
        fraction.setNumerator(numerator); // sets the numerator of Fraction
        fraction.setDenominator(denominator); // sets the denominator of Fraction

        return fraction;
    } // end of toFraction method

    public MixedFraction add(MixedFraction addend) {
        int sumWholeNumber = this.wholeNumber + addend.getWholeNumber();
        //Fraction
        MixedFraction bla = new MixedFraction();
        return bla;
    } // end of overriden add method
} // end of class MixedFraction
