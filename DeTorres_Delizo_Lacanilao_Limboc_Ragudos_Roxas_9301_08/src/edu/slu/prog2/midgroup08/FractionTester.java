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

import static edu.slu.prog2.pregroup08.FractionArithmetic.showIntroduction;

public class FractionTester {
    static String inputString = ""; // static object of String for user input
    static Scanner keyboard = new Scanner(System.in); // static Scanner object of keyboard
    /**
     * Main entry point of the program.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        showIntroduction(); // introduces the user to the program
        runGUI();
    } // end of main method

    /** This method is responsible for running the GUIFractionCalculator.
     * It creates an instance of the GUIFractionCalculator and calls its constructor to create the GUI.
     * There are no input parameters, and the method does not return anything.
     */
    public static void runGUI() {
        GUIFractionCalculator guiFractionCalculator = new GUIFractionCalculator();
    } // end of runGUI method

    /**
     * This method reads and accepts user input of a mixed fraction and returns it.
     * @return MixedFraction object with user-given whole number, numerator, and denominator.
     */
    public static MixedFraction fraction1() {
        MixedFraction fraction1;
        fraction1 = readFraction();
        return fraction1;
    } // end of fraction1 method

    /**
     * This method reads and accepts user input of a mixed fraction and returns it.
     * @return MixedFraction object with user-given whole number, numerator, and denominator.
     */
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
        int wholeNumber;
        int numerator;
        int denominator;
        System.out.println("Enter a fraction (in the format w n/d): ");
        inputString = keyboard.nextLine();

        try {
            String[] parts = inputString.split(" ");
            wholeNumber = Integer.parseInt(parts[0]);
            String[] parts2 = parts[1].split("/");
            numerator = Integer.parseInt(parts2[0]);
            denominator = Integer.parseInt(parts2[1]);
            return new MixedFraction(wholeNumber, numerator, denominator);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("Invalid input. Please try again.");
            return readFraction();
        }
    }

    /**
     * Converts a mixed fraction to an improper fraction.
     * @param mixedFraction the mixed fraction to convert
     * @return the improper fraction as a string
     * @throws IllegalArgumentException if the input is not in the correct format
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
            throw new IllegalArgumentException("Invalid fraction: " + mixedFraction);
        }
    }

    /**
     * Converts an improper fraction to a mixed number.
     * @param improperFraction the improper fraction to convert
     * @return the mixed number as a string
     * @throws IllegalArgumentException if the input is not in the correct format
     */
    public static String convertToMixedNumbers(String improperFraction) throws IllegalArgumentException {
        String[] parts = improperFraction.split("/");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid fraction: " + improperFraction);
        }
        try {
            int numerator = Integer.parseInt(parts[0]);
            int denominator = Integer.parseInt(parts[1]);
            int wholeNumber = numerator / denominator;
            numerator = Math.abs(numerator % denominator);
            if (wholeNumber == 0) {
                return numerator + "/" + denominator;
            } else {
                return wholeNumber + " " + numerator + "/" + denominator;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid fraction: " + improperFraction);
        }
    } // end of readFraction method
} // end of class FractionTester
