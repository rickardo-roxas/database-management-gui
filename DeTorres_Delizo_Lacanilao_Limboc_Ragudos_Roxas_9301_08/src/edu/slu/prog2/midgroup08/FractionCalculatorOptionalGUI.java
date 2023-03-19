package edu.slu.prog2.midgroup08;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import edu.slu.prog2.pregroup08.Fraction;

public class FractionCalculatorOptionalGUI extends JPanel {
    private final JLabel fracResult;
    private JButton addB;
    private JButton subtractB;
    private JButton multiplyB;
    private JButton divideB;
    private JLabel Fraction1;
    private JLabel Fraction2;
    private JTextField firstNumerator;
    private JTextField secondNumerator;
    private JLabel separator1;
    private JLabel separator2;
    private JTextField firstDenominator;
    private JTextField secondDenominator;
    private JTextField result;
    private JButton clearB;
    private JButton exitB;

    public FractionCalculatorOptionalGUI() {
        //construct components
        addB = new JButton("Add");
        subtractB = new JButton("Subtract");
        multiplyB = new JButton("Multiply");
        divideB = new JButton("Divide");
        fracResult = new JLabel ("Result:");
        Fraction1 = new JLabel("Enter the First Fraction:");
        Fraction2 = new JLabel("Enter the Second Fraction:");
        firstNumerator = new JTextField(5);
        secondNumerator = new JTextField(5);
        separator1 = new JLabel("/");
        separator2 = new JLabel("/");
        firstDenominator = new JTextField(5);
        secondDenominator = new JTextField(5);
        result = new JTextField(5);
        clearB = new JButton("Clear");
        exitB = new JButton("Exit");

        //adjust size and set layout
        setPreferredSize(new Dimension(424, 272));
        setLayout(null);

        //add components
        add(addB);
        add(subtractB);
        add(multiplyB);
        add(divideB);
        add(fracResult);
        add(Fraction1);
        add(Fraction2);
        add(firstNumerator);
        add(secondNumerator);
        add(separator1);
        add(separator2);
        add(firstDenominator);
        add(secondDenominator);
        add(result);
        add(clearB);
        add(exitB);

        //set component bounds (only needed by Absolute Positioning)
        addB.setBounds(15, 95, 90, 60);
        subtractB.setBounds(115, 95, 90, 60);
        multiplyB.setBounds(215, 95, 90, 60);
        divideB.setBounds(315, 95, 95, 60);
        fracResult.setBounds(15, 180, 100, 25);
        Fraction1.setBounds(15, 15, 150, 25);
        Fraction2.setBounds(15, 55, 160, 25);
        firstNumerator.setBounds(175, 15, 100, 25);
        secondNumerator.setBounds(175, 55, 100, 25);
        separator1.setBounds(290, 15, 20, 25);
        separator2.setBounds(290, 55, 100, 25);
        firstDenominator.setBounds(310, 15, 100, 25);
        secondDenominator.setBounds(310, 55, 100, 25);
        result.setBounds(65, 170, 345, 50);
        clearB.setBounds(65, 230, 100, 25);
        exitB.setBounds(310, 230, 100, 25);

        //add action listeners
        addB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(firstNumerator.getText());
                int den1 = Integer.parseInt(firstDenominator.getText());
                int num2 = Integer.parseInt(secondNumerator.getText());
                int den2 = Integer.parseInt(secondDenominator.getText());
                Fraction f1 = new Fraction(num1, den1);
                Fraction f2 = new Fraction(num2, den2);
                //perform addition operation
                Fraction resultFraction = f1.add(f2);
                result.setText(resultFraction.toString());
            }
        });
        subtractB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(firstNumerator.getText());
                int den1 = Integer.parseInt(firstDenominator.getText());
                int num2 = Integer.parseInt(secondNumerator.getText());
                int den2 = Integer.parseInt(secondDenominator.getText());
                Fraction f1 = new Fraction(num1, den1);
                Fraction f2 = new Fraction(num2, den2);
                //perform subtraction operation
                Fraction resultFraction = f1.subtract(f2);
                result.setText(resultFraction.toString());
            }
        });

        multiplyB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(firstNumerator.getText());
                int den1 = Integer.parseInt(firstDenominator.getText());
                int num2 = Integer.parseInt(secondNumerator.getText());
                int den2 = Integer.parseInt(secondDenominator.getText());
                Fraction f1 = new Fraction(num1, den1);
                Fraction f2 = new Fraction(num2, den2);
                //perform multiplication operation
                Fraction resultFraction = f1.multiplyBy(f2);
                result.setText(resultFraction.toString());
            }
        });

        divideB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(firstNumerator.getText());
                int den1 = Integer.parseInt(firstDenominator.getText());
                int num2 = Integer.parseInt(secondNumerator.getText());
                int den2 = Integer.parseInt(secondDenominator.getText());
                Fraction f1 = new Fraction(num1, den1);
                Fraction f2 = new Fraction(num2, den2);
                //perform division operation
                Fraction resultFraction = f1.divideBy(f2);
                result.setText(resultFraction.toString());
            }
        });

        clearB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //clear all text fields
                firstNumerator.setText("");
                secondNumerator.setText("");
                firstDenominator.setText("");
                secondDenominator.setText("");
                result.setText("");
            }
        });

        exitB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //exit the program
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Fraction Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new FractionCalculatorOptionalGUI());
        frame.pack();
        frame.setVisible(true);
    }
}
