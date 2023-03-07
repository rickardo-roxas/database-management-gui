/**
 * Group 9
 * Class code and course number: 9301B - CS 122
 * Schedule: TF 9:00 - 10:30 AM
 * <p>
 *     RABANG, Gebreyl Isaac P.
 *     RAGUDOS, Hannah T.
 *     RAMOS, Jerwin Kyle R.
 *     ROQUE, Rey Daniel L.
 *     ROXAS, Johan Rickardo A.
 * </p>
 * The NoNumeratorException exception.
 * An exception that throws when a Fraction's numerator is null.
 * The default constructed Fraction will be instantiated.
 */
package fraction;

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
