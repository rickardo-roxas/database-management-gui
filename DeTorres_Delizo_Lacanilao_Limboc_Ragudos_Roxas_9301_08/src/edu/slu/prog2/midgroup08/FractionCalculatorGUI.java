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
import edu.slu.prog2.pregroup08.Fraction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FractionCalculatorGUI extends JFrame implements ActionListener {

    private JTextField fraction1Field, fraction2Field, resultField;
    private JLabel fraction1Label, fraction2Label, resultLabel;
    private JButton addButton, subtractButton, multiplyButton, divideButton, clearButton, exitButton;

    public FractionCalculatorGUI() {
        setTitle("Fraction Calculator");
        setSize(420, 530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.decode("#E5E5E5"));
        Image icon = Toolkit.getDefaultToolkit().getImage("");
        setIconImage(icon);




        // Create the labels
        Font labelFont = new Font("Arial", Font.BOLD, 20);
        fraction1Label = new JLabel("Enter Fraction 1:");
        fraction1Label.setFont(labelFont);
        fraction2Label = new JLabel("Enter Fraction 2:");
        fraction2Label.setFont(labelFont);
        resultLabel = new JLabel("Result:");
        resultLabel.setFont(labelFont);

        // Create the input fields
        Font inputFont = new Font("Arial", Font.PLAIN, 18);
        fraction1Field = new JTextField();
        fraction1Field.setFont(inputFont);
        fraction2Field = new JTextField();
        fraction2Field.setFont(inputFont);
        resultField = new JTextField();
        resultField.setEditable(false);
        resultField.setFont(inputFont);

        // Create the buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        addButton = new JButton("ADD");
        addButton.setFont(buttonFont);
        addButton.setBackground(Color.decode("#4CAF50"));
        addButton.setForeground(Color.WHITE);
        subtractButton = new JButton("SUBTRACT");
        subtractButton.setFont(buttonFont);
        subtractButton.setBackground(Color.decode("#f44336"));
        subtractButton.setForeground(Color.WHITE);
        multiplyButton = new JButton("MULTIPLY");
        multiplyButton.setFont(buttonFont);
        multiplyButton.setBackground(Color.decode("#2196F3"));
        multiplyButton.setForeground(Color.WHITE);
        divideButton = new JButton("DIVIDE");
        divideButton.setFont(buttonFont);
        divideButton.setBackground(Color.decode("#9C27B0"));
        divideButton.setForeground(Color.WHITE);
        clearButton = new JButton("CLEAR");
        clearButton.setFont(buttonFont);
        clearButton.setBackground(Color.decode("#FFC107"));
        clearButton.setForeground(Color.WHITE);
        exitButton = new JButton("EXIT");
        exitButton.setFont(buttonFont);
        exitButton.setBackground(Color.decode("#607D8B"));
        exitButton.setForeground(Color.WHITE);

        // Set the layout
        setLayout(new GridLayout(7, 2, 5, 5));

        // Add the components to the frame
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
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Perform addition
            MixedFraction fraction1 = parseFraction(fraction1Field.getText());
            MixedFraction fraction2 = parseFraction(fraction2Field.getText());
            MixedFraction result = fraction1.add(fraction2);
            resultField.setText(result.toString());
        } else if (e.getSource() == subtractButton) {
            // Perform subtraction
            MixedFraction fraction1 = parseFraction(fraction1Field.getText());
            MixedFraction fraction2 = parseFraction(fraction2Field.getText());
            MixedFraction result = fraction1.subtract(fraction2);
            resultField.setText(result.toString());
        } else if (e.getSource() == multiplyButton) {
            // Perform multiplication
            MixedFraction fraction1 = parseFraction(fraction1Field.getText());
            MixedFraction fraction2 = parseFraction(fraction2Field.getText());
            MixedFraction result = fraction1.multiplyBy(fraction2);
            resultField.setText(result.toString());
        } else if (e.getSource() == divideButton) {
            // Perform division
            MixedFraction fraction1 = parseFraction(fraction1Field.getText());
            MixedFraction fraction2 = parseFraction(fraction2Field.getText());
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
    }

    private MixedFraction parseFraction(String fractionString) {
        // Parse a string into a fraction
        String[] parts = fractionString.split(" ");
        if (parts.length == 1) {
            // Simple fraction
            String[] nums = parts[0].split("/");
            int numerator = Integer.parseInt(nums[0]);
            int denominator = Integer.parseInt(nums[1]);
            Fraction fraction = new Fraction(numerator, denominator);
            return new MixedFraction(fraction);
        } else {
            // Mixed fraction
            int wholeNumber = Integer.parseInt(parts[0]);
            String[] nums = parts[1].split("/");
            int numerator = Integer.parseInt(nums[0]);
            int denominator = Integer.parseInt(nums[1]);
            return new MixedFraction(wholeNumber, numerator, denominator);
        }
    }

    public static void main(String[] args) {
        FractionCalculatorGUI calculator = new FractionCalculatorGUI();
        calculator.setVisible(true);
    }
}

