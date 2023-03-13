// Duplicate class to clean up MixedFraction class

package edu.slu.prog2.midgroup08;

import edu.slu.prog2.pregroup08.Fraction;

public class MixedFractionClean extends Fraction {
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
} // end of class MixedFraction
