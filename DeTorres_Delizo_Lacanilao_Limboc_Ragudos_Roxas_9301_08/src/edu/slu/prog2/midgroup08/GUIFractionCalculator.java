/**
 * Team 8
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
 * GUI Template.
 */
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
    } // end of GUIFractionCalculator

    public static void main(String[] args) {
        GUIFractionCalculator calculator = new GUIFractionCalculator();
    }
}
