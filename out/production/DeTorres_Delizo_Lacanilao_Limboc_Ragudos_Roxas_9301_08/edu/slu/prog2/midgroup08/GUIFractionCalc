package edu.slu.prog2.midgroup08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIFractionCalc extends JFrame {

    private JLabel title;
    private JLabel fraction1Label, fraction2Label, fraction1WholeNumberLabel, fraction2WholeNumberLabel,
            fraction2DenLabel, fraction1DenLabel, fraction2NumLabel, fraction1NumLabel;
    private JTextField textFieldF1WN, textFieldF1Num, textFieldF1Den, textFieldF2WN, textFieldF2Num, textFieldF2Den;
    private JButton addButton, subtractButton, multiplyButton, divideButton, clearButton, exitButton;


    public GUIFractionCalc(){
        // labels
        title = new JLabel("Mixed Fraction Calculator ");
        fraction1Label = new JLabel("Enter Fraction 1: ");
        fraction2Label = new JLabel("Enter Fraction 2: ");
        fraction1WholeNumberLabel = new JLabel("WHOLE NUMBER");
        fraction1NumLabel = new JLabel("NUMERATOR");

        // Text fields


        // buttons

        addButton = new JButton("ADD");
        addHandler = new AddButtonHandler();
        addButton.addActionListener(addHandler);
        subtractButton = new JButton("SUBTRACT");
        subtractHandler = new SubtractButtonHandler();
        subtractButton.addActionListener(subtractHandler);
        multiplyButton = new JButton("MULTIPLY");
        multiplyHandler = new MultiplyButtonHandler();
        multiplyButton.addActionListener(multiplyHandler);
        divideButton = new JButton("DIVIDE");
        divideHandler = new DivideButtonHandler();
        divideButton.addActionListener(divideHandler);
        clearButton = new JButton("CLEAR");
        clearHandler = new ClearButtonHandler();
        clearButton.addActionListener(clearHandler);
        exitButton = new JButton("EXIT");
        exitHandler = new ExitButtonHandler();
        exitButton.addActionListener(exitHandler);





        JFrame Calculator = new JFrame();
        Calculator.setLayout(null);
        Calculator.setBounds(300,200,420,420);
        Calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Calculator.setTitle("Fraction Calculator");
        Container pane = Calculator.getContentPane();
        pane.setLayout(null);
        title.setBounds(10,10,150,20);
        pane.add(title);
        fraction1Label.setBounds(20,20,150,20);
        pane.add(fraction1Label);










        Calculator.setVisible(true);
    }

    private class AddButtonHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public static void main(String[] args) {
        GUIFractionCalc calculator = new GUIFractionCalc();
    }
}

