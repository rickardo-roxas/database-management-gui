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
 * The FractionCalculatorGUI
 * <p>
 *     This class represents the graphical user interface for a
 *     simple fraction calculator. It extends the JFrame class and
 *     implements the ActionListener interface for event handling.
 * </p>
 */

package edu.slu.prog2.midgroup08;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FractionCalculatorGUI extends JFrame implements ActionListener {

    // GUI Components
    private JTextField fraction1Field, fraction2Field, resultField;
    private JLabel fraction1Label, fraction2Label, resultLabel;
    private JButton addButton, subtractButton, multiplyButton, divideButton, clearButton, exitButton;

    /**
     * Creates a new FractionCalculatorGUI object with the specified dimensions.
     */
    public FractionCalculatorGUI() {
        // set frame properties
        setTitle("Fraction Calculator");
        setSize(420, 530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        // set background color and icon
        getContentPane().setBackground(Color.decode("#FFF8DC"));
        Image icon = Toolkit.getDefaultToolkit().getImage("logo-gui.png");
        setIconImage(icon);


        // GUI Components : Labels
        Font labelFont = new Font("Arial", Font.BOLD, 20);
        fraction1Label = new JLabel("Enter Fraction 1:");
        fraction1Label.setFont(labelFont);
        fraction2Label = new JLabel("Enter Fraction 2:");
        fraction2Label.setFont(labelFont);
        resultLabel = new JLabel("Result:");
        resultLabel.setFont(labelFont);

        // set input Fields
        Font inputFont = new Font("Arial", Font.PLAIN, 18);
        fraction1Field = new JTextField();
        fraction1Field.setFont(inputFont);
        fraction2Field = new JTextField();
        fraction2Field.setFont(inputFont);
        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setFont(inputFont);
        resultField.setBackground(Color.WHITE);

        // set buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        addButton = new JButton("ADD");
        addButton.setFont(buttonFont);
        addButton.setBackground(Color.decode("#00FF7F"));
        addButton.setForeground(Color.WHITE);
        subtractButton = new JButton("SUBTRACT");
        subtractButton.setFont(buttonFont);
        subtractButton.setBackground(Color.decode("#F08080"));
        subtractButton.setForeground(Color.WHITE);
        multiplyButton = new JButton("MULTIPLY");
        multiplyButton.setFont(buttonFont);
        multiplyButton.setBackground(Color.decode("#1E90FF"));
        multiplyButton.setForeground(Color.WHITE);
        divideButton = new JButton("DIVIDE");
        divideButton.setFont(buttonFont);
        divideButton.setBackground(Color.decode("#BA55D3"));
        divideButton.setForeground(Color.WHITE);
        clearButton = new JButton("CLEAR");
        clearButton.setFont(buttonFont);
        clearButton.setBackground(Color.decode("#FFC107"));
        clearButton.setForeground(Color.WHITE);
        exitButton = new JButton("EXIT");
        exitButton.setFont(buttonFont);
        exitButton.setBackground(Color.decode("#607D8B"));
        exitButton.setForeground(Color.WHITE);

        // Layout
        setLayout(new GridLayout(7, 2, 5, 5));

        // Adding the components to the frame
        add(fraction1Label);
        add(fraction1Field);
        add(fraction2Label);
        add(fraction2Field);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(resultLabel);
        add(resultField);
        add(clearButton);
        add(exitButton);

        // Add action listeners to the buttons
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);
        fraction1Field.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When the Enter key is pressed, give focus to the fraction2Field
                fraction2Field.requestFocusInWindow();
            }
        });
    } // end of FractionCalculatorGUI constructor

    /**
     * This method performs the appropriate operation based on the button that was clicked.
     @param e The ActionEvent object representing the button click event.
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Perform addition
            MixedFraction fraction1 = parseFraction(fraction1Field.getText.().trim());
            MixedFraction fraction2 = parseFraction(fraction2Field.getText().trim());
            MixedFraction result = fraction1.add(fraction2);
            resultField.setText(result.toString());
        } else if (e.getSource() == subtractButton) {
            // Perform subtraction
            MixedFraction fraction1 = parseFraction(fraction1Field.getText().trim());
            MixedFraction fraction2 = parseFraction(fraction2Field.getText().trim());
            MixedFraction result = fraction1.subtract(fraction2);
            resultField.setText(result.toString());
        } else if (e.getSource() == multiplyButton) {
            // Perform multiplication
            MixedFraction fraction1 = parseFraction(fraction1Field.getText().trim());
            MixedFraction fraction2 = parseFraction(fraction2Field.getText().trim());
            MixedFraction result = fraction1.multiplyBy(fraction2);
            resultField.setText(result.toString());
        } else if (e.getSource() == divideButton) {
            // Perform division
            MixedFraction fraction1 = parseFraction(fraction1Field.getText().trim());
            MixedFraction fraction2 = parseFraction(fraction2Field.getText().trim());
            MixedFraction result = fraction1.divideBy(fraction2);
            resultField.setText(result.toString());
        } else if (e.getSource() == clearButton) {
            // Clear the input fields and result field
            fraction1Field.setText("");
            fraction2Field.setText("");
            resultField.setText("");
        } else if (e.getSource() == exitButton) {
            // Exit the program
            System.exit(0);
        }
    } // end of actionPerformed

    /**
     * This method parses a string representation of a fraction into a MixedFraction object.
     * The input string can either be a simple fraction in the form "numerator/denominator"
     * or a mixed fraction in the form "wholeNumber numerator/denominator".
     @param fractionString the string representation of the fraction to be parsed
     @return a MixedFraction object that represents the parsed fraction
     */
    private MixedFraction parseFraction(String fractionString) throws NumberFormatException {
        // Parse a string into a fraction
        String[] parts = fractionString.split(" ");
        try {
            if (parts.length == 1) {
                // Simple fraction
                // Split the numerator and denominator and parse them as integers
                String[] nums = parts[0].split("/");
                int numerator = Integer.parseInt(nums[0]);
                int denominator = Integer.parseInt(nums[1]);
                return new MixedFraction(0, numerator, denominator);
            } else {
                // Mixed fraction
                // Parse the whole number, numerator, and denominator as integers
                int wholeNumber = Integer.parseInt(parts[0]);
                String[] nums = parts[1].split("/");
                int numerator = Integer.parseInt(nums[0]);
                int denominator = Integer.parseInt(nums[1]);
                return new MixedFraction(wholeNumber, numerator, denominator);
            }
        } catch (NumberFormatException exception 1) {
            return new MixedFraction();
        }
    } // end of MixedFraction

    /**
     * The main method of the FractionCalculator program.
     * This method creates an instance of the FractionCalculatorGUI class and displays the GUI to the user.
     * @param args
     */
    public static void main(String[] args) {
        // Create a new instance of the FractionCalculatorGUI class
        FractionCalculatorGUI calculator = new FractionCalculatorGUI();
        // Set the visibility of the calculator to true, so that it is displayed to the user
        calculator.setVisible(true);
    } // end of main method
} // end of FractionCalculatorGUI class

