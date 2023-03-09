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
     * Constructs a Mixed Fraction using the explicit whole, numerator and denominator values
     * @param wholeNumber The whole number of the mixed fraction
     * @param numerator The numerator of the mixed fraction
     * @param denominator The denominator of the mixed fraction
     */
    public MixedFraction(int wholeNumber, int numerator, int denominator) {
        super(numerator, denominator);
        this.wholeNumber = wholeNumber;
    } // end of MixedFraction default constructor

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
     * Takes a MixedFraction object and returns an equivalent Fraction object in improper form.
     * Assumes valid input with non-negative whole number, and positive numerator and denominator values.
     * @param mixedFraction the mixed fraction to convert
     * @return an equivalent Fraction object in improper form
     */
    public Fraction convertToImproper(MixedFraction mixedFraction) {
        int wholeNumber = getWholeNumber();
        int numerator = mixedFraction.getNumerator();
        int denominator = mixedFraction.getDenominator();
        numerator = denominator * wholeNumber + numerator;

        return new Fraction(numerator,denominator);
    } // end of convertToImproper method

    /**
     * Converts the given 'Fraction' object to a 'MixedFraction' object.
     * @param improperFraction the 'Fraction' object to be converted to a 'MixedFraction' object
     * @return the resulting 'MixedFraction' object
     */
    public MixedFraction convertToMixedNumbers(Fraction improperFraction) {
        int wholeNumber = 0;
        int numerator = improperFraction.getNumerator();
        int denominator = improperFraction.getDenominator();
        wholeNumber = numerator / denominator;
        numerator = numerator % denominator;
        Fraction fraction = new Fraction(numerator, denominator);
        MixedFraction mixedNumbers = new MixedFraction(wholeNumber, fraction);
        return mixedNumbers;
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
    protected Fraction subtract(Fraction subtrahend) {
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
    protected Fraction multiplyBy(Fraction multiplicand) {
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
         * Stringifies the mixed fraction
         * @return the mixed fraction in String form
         */
        public String toString() {
            if(getWholeNumber() == 0) return super.toString();
            String result = super.toString();
            if(getDenominator() == 1){
                setWholeNumber(getWholeNumber() + getNumerator());
                return " "+getWholeNumber();
            }
            return(getWholeNumber()+" "+super.toString());
        } // end of toString method
} // end of class MixedFraction

