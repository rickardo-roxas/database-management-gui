package edu.slu.prog2.midgroup08;

import edu.slu.prog2.pregroup08.Fraction;
import edu.slu.prog2.pregroup08.NoDenominatorException;
import edu.slu.prog2.pregroup08.NoNumeratorException;

import javax.swing.*;
import java.util.InputMismatchException;

/**
Fraction calculator that allows users to perform basic arithmetic operations on 
fractions (i.e., addition, subtraction, multiplication, and division). 
The program uses a Fraction class to represent fractions, and it includes methods for reducing fractions and converting them to decimal form.

The program starts by introducing the user to the program and then 
displays a menu of options for performing various operations on fractions. 
The user can choose to input values for two fractions, add or subtract the two fractions, multiply or divide them, reduce either fraction or both fractions, or exit the program.

The program uses a switch statement to handle the user's input and performs the appropriate operation based on the user's choice. 
It also includes methods for displaying the results of the operations in both fraction and decimal form, as well as showing the solution to the user.
*/

public class FractionTester {
    static String inputString = ""; // static object for input
    static String outputString = ""; // static object for output
    static double output = 0.0; // static object of decimal output

    /**
     * Main entry point of the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(); // instantiates fraction1 with default attribute values
        Fraction fraction2 = new Fraction(); // instantiates fraction2 with default attribute values
        String choice = ""; // choice returned from showMenu method
        int userChoice = 0; // String choice converted to using convertChoices method

        showIntroduction(); // invokes a method that introduces the user to the program

        do {
            choice = showMenu(); // invokes showMenu method that returns a String choice
            userChoice = convertChoices(choice); // converts String choice to int using String.valueOf
            showUserChoice(userChoice); // prints the current user choice in the console

            switch (userChoice) {
                case 1 -> // Value for Fraction1
                        fraction1 = fraction1(); // instantiates a new Fraction as fraction1

                case 2 -> // Value for Fraction1
                        fraction2 = fraction2(); // instantiates a new Fraction as fraction2

                case 3 -> { // Add Fraction1 and Fraction 2
                    outputString = fraction1.add(fraction2).toString(); // fraction form
                    displayFraction(outputString, "Sum in Simplified Fraction Form");
                    output = fraction1.add(fraction2).toDouble(); // decimal form
                    displayDecimal(output, "Sum in Decimal Form");
                    showSolution(fraction1, fraction2, "+", "Sum", outputString, output);
                } // end of case 3
                case 4 -> { // Subtract Fraction1 and Fraction 2
                    outputString = fraction1.subtract(fraction2).toString(); // fraction form
                    displayFraction(outputString, "Difference in Simplified Fraction Form");
                    output = fraction1.subtract(fraction2).toDouble(); // decimal form
                    displayDecimal(output, "Difference in Decimal Form");
                    showSolution(fraction1, fraction2, "-", "Difference", outputString, output);
                } // end of case 4

                case 5 -> { // Multiply Fraction1 and Fraction 2
                    outputString = fraction1.multiplyBy(fraction2).toString(); // fraction form
                    displayFraction(outputString, "Product in Simplified Fraction Form");
                    output = fraction1.multiplyBy(fraction2).toDouble(); // decimal form
                    displayDecimal(output, "Product in Simplified Form");
                    showSolution(fraction1, fraction2, "x", "Product", outputString, output);
                } // end of case 5

                case 6 -> { // Divide Fraction1 and Fraction 2
                    outputString = fraction1.divideBy(fraction2).toString(); // fraction form
                    displayFraction(outputString, "Quotient in Simplified Fraction Form");
                    output = fraction2.multiplyBy(fraction2).toDouble(); // decimal form
                    displayDecimal(output, "Quotient in Decimal Form");
                    showSolution(fraction1, fraction2, "/", "Quotient", outputString, output);
                } // end of case 6

                case 7 -> { // Reduce certain Fractions
                    choice = showMenuReduce();
                    userChoice = convertChoices(choice);
                    if (userChoice == 1) { // reduce Fraction1 only
                        outputString = fraction1.reduce().toString(); // fraction form
                        displayFraction(outputString, "Reduced Fraction 1 in Simplified Fraction Form");
                        output = fraction1.reduce().toDouble(); // decimal form
                        displayDecimal(output, "Reduced Fraction 1 in Decimal Form");
                    } else if (userChoice == 2) { // reduce Fraction2 only
                        outputString = fraction2.reduce().toString(); // fraction form of Fraction2
                        displayFraction(outputString, "Reduced Fraction 2 in Simplified Fraction Form");
                        output = fraction2.reduce().toDouble();
                        displayDecimal(output, "Reduced Fraction 2 in Decimal Form");
                    } else { // reduce both fractions
                        outputString = fraction1.reduce().toString(); // fraction form
                        displayFraction(outputString, "Reduced Fraction 1 in Simplified Fraction Form");
                        output = fraction1.reduce().toDouble(); // decimal form
                        displayDecimal(output, "Reduced Fraction 1 in Decimal Form");
                        outputString = fraction2.reduce().toString(); // fraction form of Fraction2
                        displayFraction(outputString, "Reduced Fraction 2 in Simplified Fraction Form");
                        output = fraction2.reduce().toDouble();
                        displayDecimal(output, "Reduced Fraction 2 in Decimal Form");
                    } // end of if-else
                } // end of case 7

                case 8 -> { // Exit the program
                    showOutro(); // a simple "Thank you message"
                    System.exit(0);
                } // end of case 8

                default -> fraction1 = fraction1(); // default case is inputting value of Fraction 1
            } // end of switch-case
        } while (userChoice < 8);
    } // end of main method

    /**
     * Instantiates a new Fraction named fraction1
     * @return fraction1
     */
    public static Fraction fraction1() {
        Fraction fraction1;
        fraction1 = readFraction("Fraction 1");
        return fraction1;
    } // end of fraction1 method

    /**
     * Instantiates a new Fraction named fraction2
     * @return fraction2
     */
    public static Fraction fraction2() {
        Fraction fraction2;
        fraction2 = readFraction("Fraction 2");
        return fraction2;
    } // end of fraction2 method

    /**
     * Reads and accepts the state of instantiated Fraction attributes
     * @param promptMessage Fraction object (Fraction1 or Fraction2)
     * @return new Fraction object
     */
    protected static Fraction readFraction(String promptMessage) {
        Fraction fraction = new Fraction(); // instantiates Fraction with default values
        int numerator = 0; // holds the value of numerator of Fraction
        int denominator = 0; // holds the value of denominator of Fraction

        try {
            numerator = readNumerator("Numerator for " + promptMessage);
            fraction.setNumerator(numerator); // mutates numerator with user given integer
            denominator = readDenominator("Denominator for " + promptMessage);
            fraction.setDenominator(denominator); // mutates denominator with user given integer
        } catch (NoNumeratorException | NoDenominatorException noNumerator) { // no values given
            fraction = new Fraction(); // instantiates new Fraction with default values
        } finally {
            System.out.println(promptMessage + ": " + fraction); // displays fraction in the console
        } // end of try-catch
        return fraction; // new Fraction with user given attributes
    } // end of readFraction method

    /**
     * Reads and accepts user input of numerator of a given Fraction
     * Throws an exception when input is not an integer.
     * @param promptMessage required user input of numerator
     * @return user input of numerator
     */
    protected static int readNumerator(String promptMessage) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        boolean validNumerator = false;
        int numerator = 0;

        while (!validNumerator) {
            try {
                inputString = JOptionPane.showInputDialog(null, promptMessage + ": ",
                        "Fraction Calculator" , JOptionPane.PLAIN_MESSAGE);
                numerator = Integer.parseInt(inputString);
                validNumerator = true;

                // these program statements do not work as expected
            } catch (InputMismatchException exception) { // exception if input is not an integer
                outputString = "Invalid Input. Numerator must be an integer.";
                JOptionPane.showMessageDialog(null, outputString,
                        "Fraction Calculator" , JOptionPane.ERROR_MESSAGE);
                validNumerator = false;
            } // end of try-catch
        } // end of while
        return numerator;
    } // end of readNumerator method

    /**
     * Reads and Accepts user input of denominator of a given Fraction
     * Throws an exception when input is not an integer.
     * @param promptMessage required user input of denominator
     * @return user input of denominator
     */
    protected static int readDenominator(String promptMessage) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        boolean validDenominator = false;
        int denominator = 0;

        while (!validDenominator) {
            try {
                inputString = JOptionPane.showInputDialog(null, promptMessage + ": ",
                        "Fraction Calculator" , JOptionPane.PLAIN_MESSAGE);
                denominator = Integer.parseInt(inputString);
                // this part was created on 3 March 2023
                if (denominator == 0) {
                    outputString = "Invalid denominator. Having a denominator of 0 will make the fraction invalid.";
                    JOptionPane.showMessageDialog(null, outputString,
                            "Fraction Calculator" , JOptionPane.ERROR_MESSAGE);
                    validDenominator = false;
                } else
                    validDenominator = true;
                // these program statements do not work as expected
            } catch (InputMismatchException exception) { // exception if input is not an integer
                outputString = "Invalid Input. Denominator must be an integer.";
                JOptionPane.showMessageDialog(null, outputString,
                        "Fraction Calculator" , JOptionPane.ERROR_MESSAGE);
                validDenominator = false;
            } // end of try-catch
        } // end of while
        return denominator;
    } // end of readDenominator method

    /**
     * Displays the fraction
     * @param fraction given Fraction
     * @param promptMessage type of output
     */
    protected static void displayFraction(String fraction, String promptMessage) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, promptMessage + ": \n " + fraction,
                "Fraction Calculator", JOptionPane.INFORMATION_MESSAGE);
    } // end of showFraction method

    /**
     * Displays the decimal
     * @param decimal given Fraction converted to decimal
     * @param promptMessage type of output
     */
    protected static void displayDecimal(double decimal, String promptMessage) {
        JDialog.setDefaultLookAndFeelDecorated(true);
        JOptionPane.showMessageDialog(null, promptMessage + ": \n" + decimal,
                "Fraction Calculator", JOptionPane.INFORMATION_MESSAGE);
    } // end of displayDecimal method

    /**
     * Introduces the user to the program
     */
    static void showIntroduction() {
        JDialog.setDefaultLookAndFeelDecorated(true);

        // first page
        outputString = """
                 Welcome to our Fraction Calculator by Team 8
                ------------------------------------------------------------------------------------------------- \s
                 Programmers:\s
                 -> LACANILAO, Marvin Patrick D.\s
                 -> DE TORRES, John Rey I.\s
                 -> DELIZO, John Marco\s
                 -> LIMBOC, Trixie Mae W.
                 -> RAGUDOS, Hannah T.\s
                 -> ROXAS, Johan Rickardo A.\s
                -------------------------------------------------------------------------------------------------\s
                 9301 CS 122 - Computer Programming 2\s
                 AY 2022-2023\s""";
        JOptionPane.showMessageDialog(null, outputString);

        // second page
        outputString = """
                This program will ask for your following inputs:\s
                 Fraction 1:\s
                 -> Numerator\s
                 -> Denominator\s
                 Fraction 2:\s
                 -> Numerator\s
                 -> Denominator\s
                 This program will compute the following:\s
                 -> Sum of Fraction 1 and Fraction 2\s
                 -> Difference of Fraction 1 and Fraction 2\s
                 -> Product of Fraction 1 and Fraction 2\s
                 -> Quotient of Fraction 1 and Fraction 2\s""";
        JOptionPane.showMessageDialog(null, outputString);
    } // end of showIntroduction method

    /**
     * Displays a "Thank You" message upon exit of application.
     */
    public static void showOutro() {
        JDialog.setDefaultLookAndFeelDecorated(true);
        outputString = "Thank you for using the Fraction Calculator!";
        JOptionPane.showMessageDialog(null, outputString, "Fraction Calculator" ,
                JOptionPane.INFORMATION_MESSAGE);
    } // end of showOutro method

    /**
     * Displays the menu of possible user options.
     * Options are enumerated.
     * userChoices can be accessed using a dropdown menu.
     * userChoice[1] is the default Option.
     * @return Option string
     */
    public static String showMenu() {
        JDialog.setDefaultLookAndFeelDecorated(true);
        String[] options = {"1","2","3","4","5","6","7","8"};
        int[] userChoices = {1,2,3,4,5,6,7,8};
        outputString = """
                1. Enter the value of Fraction 1
                2. Enter the value of Fraction 2
                3. Add Fractions
                4. Subtract Fractions
                5. Multiply Fractions
                6. Divide Fractions
                7. Reduce a fraction
                8. Quit""";
        inputString = (String) JOptionPane.showInputDialog(null,
                outputString, "Fraction Calculator",
                JOptionPane.QUESTION_MESSAGE, null, options, userChoices[1]);
        return inputString;
    } // end of showMenu method

    /**
     * Displays the menu of possible user options when Reduce a Fraction is invoked
     * Options are enumerated.
     * userChoices can be accessed using a dropdown menu.
     * userChoice[1] is the default Option.
     * @return Option string
     */
    public static String showMenuReduce() {
        JDialog.setDefaultLookAndFeelDecorated(true);
        String[] options = {"1","2","3"};
        String[] userChoices = {"Reduce Fraction1","Reduce Fraction2","Reduce Fraction1 and Fraction2"};
        outputString = """
                1. Reduce Fraction1 in its Simplest Form
                2. Reduce Fraction2 in its Simplest Form
                3. Reduce Fraction1 and Fraction2 in their Simplest Form""";
        inputString = (String) JOptionPane.showInputDialog(null,
                outputString, "Fraction Calculator",
                JOptionPane.QUESTION_MESSAGE, null, options, userChoices[1]);
        return inputString;
    } // end of showMenuReduce method

    /**
     * Converts the userChoice of array to an integer to be used in the main method.
     * @param givenChoice choice (String)
     * @return choice (integer)
     */
    protected static int convertChoices(String givenChoice) {
        int choice = 0;
        choice = Integer.parseInt(givenChoice);
        return choice;
    } // end of convertChoices method

    /**
     * Displays the solution in the console during arithmetic operations.
     */
    protected static void showSolution(Fraction operand1, Fraction operand2, String operation, String promptMessage,
                                       String answerFraction, double answerDecimal) {
        System.out.printf("%-10s %-10s %-10s %n" , "Fraction 1" , "" , "Fraction 2");
        System.out.printf("%-10s %-10s %-10s %n" , operand1.toString() , operation , operand2.toString());
        System.out.printf("%-10s %n" , promptMessage);
        System.out.printf("%-10s %-10s %-10f %n" , answerFraction , "or" , answerDecimal);
    } // end of showSolution method

    protected static void showUserChoice(int userChoice) {
        System.out.println("User choice: " + userChoice);

    } // end of showUserChoice method
} // end of class FractionTester
