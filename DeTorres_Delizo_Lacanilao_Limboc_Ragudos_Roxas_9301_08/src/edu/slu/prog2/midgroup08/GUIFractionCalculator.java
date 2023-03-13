package edu.slu.prog2.midgroup08;

import javax.swing.*;

public class GUIFractionCalculator extends JFrame {
    private JPanel mainPanel;
    private JButton addButton;
    private JButton multiplyButton;
    private JButton deleteButton;
    private JButton subtractButton;
    private JButton divideButton;
    private JButton exitButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JLabel fraction1Label;
    private JLabel fraction2Label;
    private JLabel fraction1WholeNumberLabel;
    private JLabel fraction2WholeNumberLabel;
    private JLabel fraction2DenLabel;
    private JLabel fraction1DenLabel;
    private JLabel fraction2NumLabel;
    private JLabel fraction1NumLabel;

    public GUIFractionCalculator(){
        setVisible(true);
        setResizable(false);
        setContentPane(mainPanel);
        pack();

    }

    public static void main(String[] args) {
        GUIFractionCalculator calculator = new GUIFractionCalculator();
    }
}
