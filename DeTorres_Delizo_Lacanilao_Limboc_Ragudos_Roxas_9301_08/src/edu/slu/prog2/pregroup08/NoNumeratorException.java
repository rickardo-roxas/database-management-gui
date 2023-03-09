/**
 * Group 9
 * Class code and course number: 9301B - CS 122
 * Schedule: TF 9:00 - 10:30 AM
 * <p>
 *     LACANILAO, Marvin Patrick D. -2230153
 *     DE TORRES, John Rey I. -2234944
 *     DELIZO, John Marco -2234758
 *     LIMBOC, Trixie Mae W. - 2233674
 *     RAGUDOS, Hannah T.- 2233361
 *     ROXAS, Johan Rickardo A. - 2233375
 * </p>
 * The NoNumeratorException exception.
 * An exception that throws when a Fraction's numerator is null.
 * The default constructed Fraction will be instantiated.
 */
package edu.slu.prog2.pregroup08;

import javax.swing.*;
public class NoNumeratorException extends RuntimeException {
    private NoNumeratorException() {
        String outputString = "";

        // exception message
        outputString = "NoNumeratorException occurred. Default fraction value 0/1 will be used";
        JOptionPane.showMessageDialog(null, outputString);
        // additional message
        outputString = "You may still change it using the main menu";
        JOptionPane.showMessageDialog(null, outputString);
    } // end of NoNumeratorException method
} // end of exception NoNumeratorException
