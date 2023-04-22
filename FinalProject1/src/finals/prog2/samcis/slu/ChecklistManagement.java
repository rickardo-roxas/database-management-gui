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
 */
package finals.prog2.samcis.slu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;


public class ChecklistManagement extends JFrame implements ActionListener {
    // GUI Components

    // Labels
    private JLabel loginLabel;

    // Buttons
    private JButton quitButton;
    private JButton loginButton;
    private JButton createButton;

    // Text Fields
    private JTextField loginTextField;


    // ArrayLists
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Grade> grades = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    // BufferedReader objects
    private BufferedReader inputStream;

    /**
     * Main entry point of the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ChecklistManagement checklistManagement;
        try {
            checklistManagement = new ChecklistManagement();
            checklistManagement.run();
            checklistManagement.pack();
            checklistManagement.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        } // end of try-catch
        System.exit(0);
    } // end of main method

    /**
     * Controls the execution of the program
     * @throws Exception To-Do...
     */
    private void run() throws Exception {
        try {
            try {
                loginFormComponents();
                populateCourse();
            } catch (FileNotFoundException exception) {
                exception.getMessage();
            } // end of try-catch
        } catch (Exception exception) {
            exception.printStackTrace();
        } // end of try-catch
    } // end of run method

    /**
     * Populates ArrayList of courses using the data of the BSCS Curriculum
     * @throws FileNotFoundException TO-DO...
     */
    private void populateCourse() throws FileNotFoundException {
        try {
            inputStream = new BufferedReader(new FileReader("BSCSCurriculumData1.txt"));

            while (inputStream.readLine() != null) {
                String course = inputStream.readLine();
                String[] courseData = course.split(",");

                int courseYear = Byte.parseByte(courseData[0]);
                int courseTerm = Byte.parseByte(courseData[1]);
                String courseNumber = courseData[2];
                String courseDescriptiveTitle = courseData[3];
                int units = Byte.parseByte(courseData[4]);

                Course newCourse = new Course(courseYear, courseTerm, courseNumber, courseDescriptiveTitle, units);
                courses.add(newCourse);

                System.out.println(courses);
            } // end of while
            inputStream.close(); // Closes inputStream when readLine == null
        } catch (IOException exception1) {
            exception1.getMessage();
        } finally {
            System.out.println("TO DO...");
        } // end of try-catch
    } // end of populateCourse method

    private void populateGUIComponents() {
        // Add JFrame stuff here
        // Invoke in run method
        // For shorter code
    }

    /**
     * Shows the UI when a student is logging in the program.
     */
    private void loginFormComponents() {
        setTitle("Student Login Form");

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(2,1));

        loginLabel = new JLabel("Enter your SLU ID Number");
        loginButton = new JButton("Login");
        loginTextField = new JTextField();
        loginTextField.setDocument(new JTextFieldLimit(7)); // Limits input to 7 characters
        quitButton = new JButton("Quit");

        loginPanel.add(loginLabel);
        loginPanel.add(loginButton);
        loginPanel.add(quitButton);
        add(loginPanel);

        loginButton.addActionListener(this);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    } // end of loginFormComponents

    /**
     * Creates student record when no record has been found.
     */
    private void createRecordComponents() {
        setTitle("Student Login Form");

        JPanel recordPanel = new JPanel();
        recordPanel.setLayout(new GridLayout(2,1));

        loginLabel = new JLabel("No student record found. Default record has been created.");
        createButton = new JButton("Next");
        quitButton = new JButton("Quit");

        recordPanel.add(loginLabel);
        recordPanel.add(createButton);
        recordPanel.add(quitButton);
        add(recordPanel);

        createButton.addActionListener(this);

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    } // end of makeRecordComponents method

    /**
     * Implemented method for actionPerformed for JButtons
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        // Login Button
        if (e.getSource() == loginButton) {
            loginFormComponents();

            try {
                int studentID = 0000000;

                if (!loginTextField.getText().equals("")) {
                    studentID = Integer.parseInt(loginLabel.getText());
                    try {
                        inputStream = new BufferedReader(new FileReader(String.valueOf(studentID)));
                    } catch (FileNotFoundException exception) {
                        createRecordComponents();
                    } // end of try-catch
                } else
                    loginTextField.setText("Please enter a valid SLU ID Number");
            } catch (NumberFormatException exception1) {
                loginTextField.setText(exception1.getMessage());
            } // end of try-catch
        } // end of if -> loginButton

        // Create Record
        if (e.getSource() == createButton) {
            // signUpFormComponents();
        } // end of if -> createButton

        if (e.getSource() == quitButton) {
            System.exit(0);
        } // end of if -> quitButton
    } // end of actionPerformed method
} // end of class ChecklistManagement

/**
 * Class that limits user input from JTextField using a given offset value.
 */
class JTextFieldLimit extends PlainDocument {
    private final int limit;

    /**
     * Constructs JTextFieldLimit object with user-defined values.
     * @param limit input limit
     */
    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    } // end of JTextFieldLimit constructor

    /**
     * Implemented method for text field limit
     * @param offset the starting offset &gt;= 0
     * @param string the string to insert; does nothing with null/empty strings
     * @param attributeSet the attributes for the inserted content
     * @throws BadLocationException if reference does not exist
     */
    public void insertString(int offset, String string, AttributeSet attributeSet) throws BadLocationException {
        if (string == null)
            return;
        if ((getLength() + string.length()) <= limit)
            super.insertString(offset, string, attributeSet);
    } // end of insertString method
} // end of JTextFieldLimit class
