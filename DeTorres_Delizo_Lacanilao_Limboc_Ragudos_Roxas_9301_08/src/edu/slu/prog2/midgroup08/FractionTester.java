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
 * The FractionTester class.
 * // to - do
 */
package edu.slu.prog2.midgroup08;

import javax.swing.*;
import java.lang.*;
import java.util.Scanner;

public class FractionTester extends GUIFractionCalculator {
    static String inputString = ""; // static object of String for user input
    static Scanner keyboard = new Scanner(System.in); // static Scanner object of keyboard
    /**
     * Main entry point of the program.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        readFraction();
    } // end of main method

    public static MixedFraction fraction1() {
        MixedFraction fraction1;
        fraction1 = readFraction();
        return fraction1;
    } // end of fraction1 method

    public static MixedFraction fraction2() {
        MixedFraction fraction2;
        fraction2 = readFraction();
        return fraction2;
    } // end of fraction2 method

    /**
     * Reads and accepts user input of MixedFraction.
     * @return Mixed Fraction with user given whole number, numerator, and denominator.
     */
    public static MixedFraction readFraction() {

    } // end of readFraction method
} // end of class FractionTester
