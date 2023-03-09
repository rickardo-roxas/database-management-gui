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

package prog2.midgroup08;

import prog2.pregroup08.Fraction;

public class MixedFraction extends Fraction {

    // object field
    private int wholeNumber; // holds the whole number for MixedFraction

    /**
     * Construct a default mixed fraction with whole = 0
     */

    public MixedFraction(Fraction fraction) {
        super(fraction.getNumerator(), fraction.getDenominator());
        wholeNumber = 0; // numerator and denominator are already from Fraction class
    } // end of MixedFraction default constructor

    /**
     * Construct a mixed fraction with a given whole number part and fraction part
     * @param wholeNumber The whole number of the mixed fraction
     * @param fraction The fraction part of the mixed fraction
     */
    public MixedFraction(int wholeNumber, Fraction fraction) {
        super(fraction.getNumerator(), fraction.getDenominator());
        this.wholeNumber = wholeNumber;
    } // end of MixedFraction default constructor

    public MixedFraction(int wholeNumber, int numerator, int denominator) {
    }

    /**
     * Setter/Mutator Method
     * Sets the value of the whole of this mixed fraction to whole
     * @param wholeNum The whole number to be assigned
     */
    public void setWholeNumber(int wholeNum) {
        wholeNumber = wholeNum;
    } // end of setWholeNumber mutator method


    /**
     * Accessor/Getter Method
     * @return The value of the whole of this mixed fraction
     */
    public int getWholeNumber() {
        return wholeNumber;
    } // end of getWholeNumber accessor method

    /*
     * Accessor/Getter Method
     * return The fraction part of this mixed fraction

    public Fraction getFractionPart(int wholeNumVal) {
        Fraction result = new Fraction(wholeNumVal);
        result.setNumerator(getNumerator());
        result.setDenominator(getDenominator());
        return result;
    }
    /*
     * Accessor/Getter Method
     * return The value of the fraction part of this mixed fraction

    public Fraction toFraction(int wholeNumVal) {
        Fraction result = new Fraction(wholeNumVal);
        result.setNumerator(getWhole() * getDenominator() + getNumerator());
        result.setDenominator(getDenominator());
        return result;

        */
    /*
     * Setter/Mutator Method
     * Sets the value of the numerator and denominator to fraction part
     * fraction The fraction to be assigned

    public void setFractionPart(Fraction fraction) {
        super.setNumerator(fraction.getNumerator());
        super.setDenominator(fraction.getDenominator());
        */

    /**
     * Concatenates the whole number, numerator, and denominator of Fraction.
     * Stringifies the mixed fraction
     * @return fraction as String
     */
    public String toString() {
        return getWholeNumber() + " " + getNumerator() + "/" + getDenominator();
    } // end of toString method

    /**
     * Computes the Mixed Fraction by multiplying the whole number with the denominator and
     * adding its product to the numerator.
     * Converts the mixed fraction to decimal form
     * @return mixed fraction converted to decimal
     */
    public double toDouble() {
        return (double) (getNumerator() / getDenominator()) + getWholeNumber();
    } // end of toDouble method

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
     * This method was made on 4 March 2023 by ROXAS, Johan Rickardo.
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
     * @param fractionAddend the Fraction object to be added
     * @return the sum of the two numbers as a new MixedFraction object
     */
    protected MixedFraction add(MixedFraction addend, Fraction fractionAddend) {
        int sumWholeNumber = this.wholeNumber + addend.getWholeNumber();
        Fraction sumFraction = add(fractionAddend);
        MixedFraction sum = new MixedFraction(sumWholeNumber, sumFraction);
        return sum;
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
     * @param fractionSubtrahend the Fraction object to subtract from this MixedFraction object
     * @return the result of the subtraction as a new MixedFraction object
     */
    protected MixedFraction subtract(MixedFraction subtrahend, Fraction fractionSubtrahend) {
        int differenceWholeNumber = this.wholeNumber - subtrahend.getWholeNumber();
        Fraction differenceFraction = subtract(fractionSubtrahend);
        MixedFraction difference = new MixedFraction(differenceWholeNumber, differenceFraction);
        return difference;
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
     * @param multiplicand the second MixedFraction to multiply
     * @return the product of the two MixedFraction objects as a new MixedFraction object
     */
    protected MixedFraction multiplyBy(MixedFraction multiplier, MixedFraction multiplicand) {
        Fraction multiplierFraction = convertToImproper(multiplier);
        Fraction multiplicandFraction = convertToImproper(multiplicand);
        multiplierFraction.
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
     * Overrides the reduce method of the superclass Fraction, and returns a reduced Fraction object.
     * @return a reduced Fraction object
     */
    @Override
    public Fraction reduce() {
        return super.reduce();

    } // end of overridden reduce method
} // end of class MixedFraction


    /*
    protected MixedFraction divideBy(MixedFraction dividend, Fraction fractionDividend) {
        int quotientWholeNumber = this
    }
    */

    /*
    /**
     * Adds two mixed fractions
     * other An addend mixed fraction
     * return The sum of this mixed fraction and another mixed fraction

    public MixedFraction add(MixedFraction other) {
        MixedFraction result = new MixedFraction(wholeNumVal); //creating a new object
        result.setWholeNumber(getWholeNumber() + other.getWholeNumber());
        Fraction fPart;
        fPart = get().add(other.getFractionPart(wholeNumVal));
        result.setDenominator(fPart.getDenominator());
        result.setNumerator(fPart.getNumerator());
        return result;
    }
    */
    /*
     * Subtracts two mixed fractions
     * other The subtrahend mixed fraction
     * return The difference of this mixed fraction and another mixed fraction

    public MixedFraction subtract(MixedFraction other) {
        MixedFraction result = new MixedFraction(wholeNumVal); //creating a new object
        Fraction f1 = toFraction(wholeNumVal);
        Fraction f2 = other.toFraction(wholeNumVal);
        result.setNumerator(f1.getNumerator() * f2.getDenominator() -
                f1.getDenominator() * f2.getNumerator());
        result.setDenominator(f1.getDenominator() * f2.getDenominator());
        result.setWholePart(result.getNumerator() / result.getDenominator());
        result.setNumerator(result.getNumerator() - result.getWhole() *
                result.getDenominator());
        result.setNumerator(Math.abs(result.getNumerator()));
        return result;
    }
    */
    /*
     * Multiplies two mixed fractions
     * other The multiplier mixed fraction
     * return The product of this mixed fraction and another mixed fraction

    public MixedFraction multiplyBy(MixedFraction other, int wholeNumVal) {
        MixedFraction result = new MixedFraction(wholeNumVal); // creating a new objec
        Fraction f1 = toFraction(wholeNumVal);
        Fraction f2 = other.toFraction(wholeNumVal);
        result.setNumerator(f1.getNumerator() * f2.getNumerator());
        result.setDenominator(f1.getDenominator() * f2.getDenominator());
        result.setWholePart(result.getNumerator() / result.getDenominator());
        result.setFractionPart(new Fraction(result.getNumerator() -
                result.getWhole() * result.getDenominator(), result.getDenominator()).reduce());
        return result;
    }
    */
    /*
     * Divides two mixed fractions
     * other The divisor mixed fraction
     * return The quotient of this mixed fraction and another mixed fraction
     *
    public MixedFraction divideBy(MixedFraction other, int wholeNumVal) {
        MixedFraction result = new MixedFraction(wholeNumVal); //creating a new object
        Fraction f1 = toFraction(wholeNumVal);
        Fraction f2 = other.toFraction(wholeNumVal);
        result.setNumerator(f1.getNumerator() * f2.getDenominator());
        result.setDenominator(f1.getDenominator() * f2.getNumerator());
        result.setWholePart(result.getNumerator() / result.getDenominator());
        result.setFractionPart(new Fraction(result.getNumerator() - result.getWhole() *
                result.getDenominator(), result.getDenominator()).reduce(wholeNumVal));
        return result;
    }
    */
