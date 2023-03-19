package edu.slu.prog2.midgroup08;

import java.awt.*;
import javax.swing.*;

public class MixedFractionCalculatorGUI extends JPanel {
    private final JTextField secondNumerator;
    private final JTextField secondWholePart;
    private final JTextField firstNumerator;
    private final JTextField firstWholePart;
    private final JTextField firstDenominator;
    private final JTextField secondDenominator;
    private final JTextField fracResult;

    public MixedFractionCalculatorGUI () {
        //construct components
        JButton addB = new JButton("Add");
        JButton subtractB = new JButton("Subtract");
        JButton multiplyB = new JButton("Multiply");
        JLabel fraction1 = new JLabel("Enter the First Fraction:");
        JLabel fraction2 = new JLabel("Enter the Second Fraction:");
        secondNumerator = new JTextField(5);
        secondWholePart = new JTextField(5);
        firstNumerator = new JTextField(5);
        firstWholePart = new JTextField(5);
        JButton divideB = new JButton("Divide");
        JLabel fracResultLabel = new JLabel("Result:");
        JButton clearB = new JButton("Clear");
        JButton exitB = new JButton("Exit");
        firstDenominator = new JTextField(5);
        secondDenominator = new JTextField(5);
        fracResult = new JTextField(5);

        //adjust size and set layout
        setPreferredSize(new Dimension(410, 511));
        setLayout(null);

        //add components
        add(addB);
        add(subtractB);
        add(multiplyB);
        add(fraction1);
        add(fraction2);
        add(secondNumerator);
        add(secondWholePart);
        add(firstNumerator);
        add(firstWholePart);
        add(divideB);
        add(fracResultLabel);
        add(clearB);
        add(exitB);
        add(firstDenominator);
        add(secondDenominator);
        add(fracResult);

        //set component bounds (only needed by Absolute Positioning)
        addB.setBounds(15, 270, 85, 60);
        subtractB.setBounds(110, 270, 85, 60);
        multiplyB.setBounds(205, 270, 85, 60);
        fraction1.setBounds(10, 70, 150, 25);
        fraction2.setBounds(10, 195, 160, 25);
        secondNumerator.setBounds(290, 175, 100, 25);
        secondWholePart.setBounds(175, 195, 100, 25);
        firstNumerator.setBounds(290, 50, 100, 25);
        firstWholePart.setBounds(175, 70, 100, 25);
        divideB.setBounds(300, 270, 90, 60);
        fracResultLabel.setBounds(115, 375, 100, 25);
        clearB.setBounds(15, 435, 100, 25);
        exitB.setBounds(290, 435, 100, 25);
        firstDenominator.setBounds(290, 90, 100, 25);
        secondDenominator.setBounds(290, 215, 100, 25);
        fracResult.setBounds(175, 360, 95, 60);

        //add action listeners
        addB.addActionListener(e -> {
            int f1num = Integer.parseInt(firstNumerator.getText());
            int f1den = Integer.parseInt(firstDenominator.getText());
            int f1whole = Integer.parseInt(firstWholePart.getText());

            int f2num = Integer.parseInt(secondNumerator.getText());
            int f2den = Integer.parseInt(secondDenominator.getText());
            int f2whole = Integer.parseInt(secondWholePart.getText());

            MixedFraction f1 = new MixedFraction(f1whole, f1num, f1den);
            MixedFraction f2 = new MixedFraction(f2whole, f2num, f2den);

            MixedFraction result = f1.add(f2);

            fracResult.setText(result.toString());
        });

        subtractB.addActionListener(e -> {
            int f1num = Integer.parseInt(firstNumerator.getText());
            int f1den = Integer.parseInt(firstDenominator.getText());
            int f1whole = Integer.parseInt(firstWholePart.getText());

            int f2num = Integer.parseInt(secondNumerator.getText());
            int f2den = Integer.parseInt(secondDenominator.getText());
            int f2whole = Integer.parseInt(secondWholePart.getText());

            MixedFraction f1 = new MixedFraction(f1whole, f1num, f1den);
            MixedFraction f2 = new MixedFraction(f2whole, f2num, f2den);

            MixedFraction result = f1.subtract(f2);

            fracResult.setText(result.toString());
        });

        multiplyB.addActionListener(e -> {
            int f1num = Integer.parseInt(firstNumerator.getText());
            int f1den = Integer.parseInt(firstDenominator.getText());
            int f1whole = Integer.parseInt(firstWholePart.getText());

            int f2num = Integer.parseInt(secondNumerator.getText());
            int f2den = Integer.parseInt(secondDenominator.getText());
            int f2whole = Integer.parseInt(secondWholePart.getText());

            MixedFraction f1 = new MixedFraction(f1whole, f1num, f1den);
            MixedFraction f2 = new MixedFraction(f2whole, f2num, f2den);

            MixedFraction result = f1.multiplyBy(f2);

            fracResult.setText(result.toString());
        });


        divideB.addActionListener(e -> {
            int f1num = Integer.parseInt(firstNumerator.getText());
            int f1den = Integer.parseInt(firstDenominator.getText());
            int f1whole = Integer.parseInt(firstWholePart.getText());

            int f2num = Integer.parseInt(secondNumerator.getText());
            int f2den = Integer.parseInt(secondDenominator.getText());
            int f2whole = Integer.parseInt(secondWholePart.getText());

            MixedFraction f1 = new MixedFraction(f1whole, f1num, f1den);
            MixedFraction f2 = new MixedFraction(f2whole, f2num, f2den);

            MixedFraction result = f1.divideBy(f2);

            fracResult.setText(result.toString());
        });

        clearB.addActionListener(e -> {
            firstWholePart.setText(" ");
            secondWholePart.setText(" ");
            firstNumerator.setText("");
            firstDenominator.setText("");
            secondNumerator.setText("");
            secondDenominator.setText("");
            fracResult.setText("");
        });

        exitB.addActionListener(e -> System.exit(0));

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fraction Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MixedFractionCalculatorGUI());
        frame.pack();
        frame.setVisible(true);
    }
}
