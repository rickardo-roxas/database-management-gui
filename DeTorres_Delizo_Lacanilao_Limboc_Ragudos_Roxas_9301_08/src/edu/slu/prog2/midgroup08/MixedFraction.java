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

    public void setWholeNumber(int wholeNumber) {
        this.wholeNumber = wholeNumber;
    } // end of setWholeNumber mutator method

    public void setFractionPart(Fraction fraction) {

    } // end of setFractionPart mutator method

    public int getWholeNumber() {
        return wholeNumber;
    } // end of getWholeNumber accessor method

    public Fraction getFractionPart() {
        return
    }
} // end of class MixedFraction
