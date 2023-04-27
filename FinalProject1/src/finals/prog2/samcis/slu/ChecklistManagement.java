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
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;


public class ChecklistManagement extends JFrame {
    // GUI Components
    // Text Fields
    private JTextArea textArea;
    private JComboBox<Integer> termComboBox;
    private JComboBox<Integer> yearComboBox;

    // ArrayLists
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    // Input/Output objects
    private BufferedReader inputStream;
    private PrintWriter outputStream;

    /**
     * Main entry point of the program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ChecklistManagement checklistManagement;
        try {
            checklistManagement = new ChecklistManagement();
            checklistManagement.run();
            checklistManagement.pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        } // end of try-catch
    } // end of main method

    /**
     * Controls the execution of the program
     *
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
     *
     * @throws FileNotFoundException TO-DO...
     */

    private void populateCourse() throws FileNotFoundException {
        try {
            inputStream = new BufferedReader(new FileReader("BSCSCurriculumData1.txt"));
            String line;
            while ((line = inputStream.readLine()) != null) {
                String[] courseData = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                int courseYear = Integer.parseInt(courseData[0]);
                int courseTerm = Integer.parseInt(courseData[1]);
                String courseNumber = courseData[2];
                String courseDescriptiveTitle = courseData[3];
                double units = Double.parseDouble(courseData[4]);

                Course newCourse = new Course(courseYear, courseTerm, courseNumber, courseDescriptiveTitle, units);
                courses.add(newCourse);
            } // end of while


        } catch (NumberFormatException e) {
            System.out.println("Invalid byte value: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException exception1) {
            exception1.getMessage();
        } finally {
            try {
                inputStream.close(); // Closes inputStream when readLine == null
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
        } // end of try-catch
    } // end of populateCourse method

    // TO-DO
    // SAVE BUTTON FOR EDIT COURSE AND ENTER GRADES
    // REPLACE QUIT WITH SAVE
    private void populateGUIComponents() {
        // Create main frame
        JFrame frame = new JFrame("Checklist Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(56, 79, 141));

        // Add title label to header panel
        JLabel titleLabel = new JLabel("Checklist Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        // Create main panel
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));

        // Add buttons to buttons panel
        // Create buttons
        JButton showSubjectsBtn = new JButton("Show Subjects");
        showSubjectsBtn.setPreferredSize(new Dimension(180, 50));
        showSubjectsBtn.setFont(new Font("Arial", Font.BOLD, 18));
        showSubjectsBtn.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 128), 2));

        JButton showGradesBtn = new JButton("Show Grades");
        showGradesBtn.setPreferredSize(new Dimension(180, 50));
        showGradesBtn.setFont(new Font("Arial", Font.BOLD, 18));
        showGradesBtn.setBorder(BorderFactory.createLineBorder(new Color(128, 64, 0), 2));

        JButton showFinishedCoursesBtn = new JButton("Show Finished Courses");
        showFinishedCoursesBtn.setPreferredSize(new Dimension(200, 50));
        showFinishedCoursesBtn.setFont(new Font("Arial", Font.BOLD, 15));
        showFinishedCoursesBtn.setBorder(BorderFactory.createLineBorder(new Color(128, 128, 0), 2));

        JButton enterGradesBtn = new JButton("Enter Grades");
        enterGradesBtn.setPreferredSize(new Dimension(180, 50));
        enterGradesBtn.setFont(new Font("Arial", Font.BOLD, 18));
        enterGradesBtn.setBorder(BorderFactory.createLineBorder(new Color(128, 0, 32), 2));

        JButton editRecordsBtn = new JButton("Edit Records");
        editRecordsBtn.setPreferredSize(new Dimension(180, 50));
        editRecordsBtn.setFont(new Font("Arial", Font.BOLD, 18));
        editRecordsBtn.setBorder(BorderFactory.createLineBorder(new Color(128, 0, 128), 2));

        JButton saveBtn = new JButton("Save Records");
        saveBtn.setPreferredSize(new Dimension(180, 50));
        saveBtn.setFont(new Font("Arial", Font.BOLD, 18));
        saveBtn.setBorder(BorderFactory.createLineBorder(new Color(128, 128, 0), 2));

        JButton quitBtn = new JButton("Quit");
        quitBtn.setPreferredSize(new Dimension(180, 50));
        quitBtn.setFont(new Font("Arial", Font.BOLD, 18));
        quitBtn.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0), 2));

        buttonsPanel.add(showSubjectsBtn);
        buttonsPanel.add(showGradesBtn);
        buttonsPanel.add(showFinishedCoursesBtn);
        buttonsPanel.add(enterGradesBtn);
        buttonsPanel.add(editRecordsBtn);
        buttonsPanel.add(saveBtn);
        buttonsPanel.add(quitBtn);

        // Create form panel
        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));

        // Add combo boxes to form panel
        termComboBox = new JComboBox<>();
        yearComboBox = new JComboBox<>();
        termComboBox.setPreferredSize(new Dimension(200, 40));
        yearComboBox.setPreferredSize(new Dimension(200, 40));
        JPanel comboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        comboPanel.add(new JLabel("Select Year:"));
        comboPanel.add(yearComboBox);
        comboPanel.add(new JLabel("Select Term:"));
        comboPanel.add(termComboBox);
        formPanel.add(comboPanel, BorderLayout.NORTH);

        // Add text area to form panel
        textArea = new JTextArea(30, 200);
        Font font = new Font("Lucida Console", Font.PLAIN, 12);
        textArea.setFont(font);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        formPanel.add(scrollPane, BorderLayout.CENTER);

        // Add buttons panel and form panel to main panel
        mainPanel.add(buttonsPanel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Add header panel and main panel to frame
        frame.add(headerPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);

        // Set frame properties
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);


        // Initialize combo boxes
        for (int i = 1; i <= 4; i++) {
            yearComboBox.addItem(i);
        }
        for (int i = 1; i <= 3; i++) {
            termComboBox.addItem(i);
        }

        // Add action listeners to buttons
        showSubjectsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected year and term
                int selectedYear = (int) yearComboBox.getSelectedItem();
                int selectedTerm = (int) termComboBox.getSelectedItem();

                // Loop through the courses and display the courses that match the selected year and term
                textArea.setText("");
                textArea.append(String.format("%-15s\t%-120s\t%-5s\t%n", "Course Number", "Descriptive Title", "Units"));
                textArea.append("-----------------------------------------------------------------------------------------------------------------------------------------------------\n");
                for (Course course : courses)
                    if (course instanceof Course && course.getYear() == selectedYear && course.getTerm() == selectedTerm)
                        textArea.append(course.toStringFormattedNoGrades());
            } // end of actionPerformed method
        }); // end of actionListener for showSubjectsBtn

        showGradesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected year and term
                int selectedYear = (int) yearComboBox.getSelectedItem();
                int selectedTerm = (int) termComboBox.getSelectedItem();

                // Loop through the courses and display the courses that match the selected year and term
                textArea.setText("");
                textArea.append(String.format("%-15s\t%-120s\t%-5s\t%-20s\t%n", "Course Number", "Descriptive Title", "Units", "Grade"));
                textArea.append("---------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                for (Course course : courses)
                    if (course instanceof Course && course.getYear() == selectedYear && course.getTerm() == selectedTerm)
                        textArea.append(course.toStringFormatted());
            } // end of actionPerformed method
        }); // end of actionListener for showGradesBtn

        showFinishedCoursesBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        enterGradesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected year and term
                int selectedYear = (int) yearComboBox.getSelectedItem();
                int selectedTerm = (int) termComboBox.getSelectedItem();

                // Loop through the courses and display the courses that match the selected year and term, and allow the user to enter grades for each student in the selected courses
                textArea.setText("");
                textArea.append(String.format("%-15s\t%-120s\t%-5s\t%-20s\t%n", "Course Number", "Descriptive Title", "Units", "Grade"));
                textArea.append("---------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                for (Course course : courses) {
                    if (course instanceof Course && course.getYear() == selectedYear && course.getTerm() == selectedTerm) {
                        textArea.append(course.toStringFormatted());
                        // Loop through the students and allow the user to enter or modify the grade for each student in the selected course

                        /*
                        for (Student student : students) {
                            Grade grade = student.getGrades().get(course);
                            String input = JOptionPane.showInputDialog(null,"Enter grade for "
                                    + student.getLastName() + " in " + course.getCourseNumber());
                            if (input != null && !input.isEmpty()) {
                                double gradeValue = Double.parseDouble(input);
                                if (grade == null) {
                                    grade = new Grade(gradeValue);
                                    student.getGrades().put(course, grade);
                                } else {
                                    grade.setGrade(gradeValue);
                                } // end of if-else
                            } // end of if
                        } // end of for
                        */
                    } // end of if
                } // end of for

                String courseNumber = JOptionPane.showInputDialog(null,
                        "Enter the course number for grade input.");

                for (Course course: courses) {
                    if (course instanceof Course && course.getCourseNumber().equals(courseNumber)) {
                        try {
                            boolean validInput = false;
                            while (!validInput) {
                                try {
                                    double grade = Double.parseDouble(JOptionPane.showInputDialog("Enter grade:"));
                                    if (grade > 99) {
                                        course.setGrade(99);
                                        validInput = true;
                                    } else if (grade < 0) {
                                        JOptionPane.showMessageDialog(null,
                                                "Invalid grade. Grade cannot be negative. Try Again.");
                                        validInput = false;
                                    } else
                                        course.setGrade(grade);
                                    validInput = true;
                                } catch (NumberFormatException exception) {
                                    JOptionPane.showMessageDialog(null, "Invalid grade input. Try again.");
                                    validInput = false;
                                } // end of try-catch
                            } // end of while
                            break;
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        } // end of try-catch
                    } // end of if
                } // end of for
            } // end of actionPerformed method
        }); // end of addActionListener for enterGradesBtn

        editRecordsBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected year and term
                int selectedYear = (int) yearComboBox.getSelectedItem();
                int selectedTerm = (int) termComboBox.getSelectedItem();

                // Loop through the courses and display the courses that match the selected year and term
                textArea.setText("");
                textArea.append(String.format("%-15s\t%-120s\t%-5s\t%-20s\t%n", "Course Number", "Descriptive Title", "Units", "Grade"));
                textArea.append("---------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                for (Course course : courses) {
                    if (course instanceof Course && course.getYear() == selectedYear && course.getTerm() == selectedTerm) {
                        textArea.append(course.toStringFormatted());
                    } // end of if
                } // end of for

                // Prompt the user to select a course to edit
                String courseNumber = JOptionPane.showInputDialog(null, "Enter the course number of the course you would like to edit:");

                // Find the course with the given course number and display its details
                for (Course course : courses) {
                    if (course instanceof Course && course.getCourseNumber().equals(courseNumber)) {
                        String input = JOptionPane.showInputDialog("Enter new course number:");
                        if (input != null && !input.isEmpty())
                            course.setCourseNumber(input);

                        input = JOptionPane.showInputDialog("Enter new course title:");
                        if (input != null && !input.isEmpty())
                            course.setDescriptiveTitle(input);

                        // Validate and set the course year
                        while (true) {
                            input = JOptionPane.showInputDialog("Enter new course year (1, 2, 3, or 4):");
                            if (input != null && !input.isEmpty()) {
                                int year = Integer.parseInt(input);
                                if (year >= 1 && year <= 4) {
                                    course.setYear(year);
                                    break;
                                } else
                                    JOptionPane.showMessageDialog(null, "Invalid input. Year must be 1, 2, 3, or 4.");
                            } else
                                break;
                        } // end of while

                        // Validate and set the course term
                        while (true) {
                            input = JOptionPane.showInputDialog("Enter new course term (1, 2, or 3):");
                            if (input != null && !input.isEmpty()) {
                                int term = Integer.parseInt(input);
                                if (term >= 1 && term <= 3) {
                                    course.setTerm(term);
                                    break;
                                } else
                                    JOptionPane.showMessageDialog(null, "Invalid input. Term must be 1, 2, or 3.");
                            } else
                                break;
                        } // end of while
                        break;
                    } // end of if
                } // end of for
            } // end of actionPerformed method
        }); // end of actionListener for editRecordsBtn

        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TO DO: save records
            }
        });

        quitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            } // end of actionPerformed method
        }); // end of addActionListener for quitBtn
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    } // end of populateGUIComponents method

    /**
     * Shows the UI when a student is logging in the program.
     */
    private void loginFormComponents() {
        JFrame loginFrame = new JFrame("Student Login Form");
        JPanel loginPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.NORTH;

        // Load the image
        ImageIcon logoIcon = new ImageIcon("slu_school_logo.png");

        // Scale the image to a smaller size
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);

        // Create the JLabel with the scaled image
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        loginPanel.add(logoLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;

        JLabel loginTitleLabel = new JLabel("Student Login");
        loginTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        loginPanel.add(loginTitleLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;

        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(400, 2));
        loginPanel.add(separator, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;

        JLabel loginLabel = new JLabel("Enter your SLU ID Number:");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 14));
        loginPanel.add(loginLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;

        JTextField loginTextField = new JTextField(10);
        loginTextField.setDocument(new JTextFieldLimit(7)); // limit to 7 characters
        loginPanel.add(loginTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(120, 40));
        loginButton.setBackground(Color.BLUE);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginPanel.add(loginButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;

        JButton quitButton = new JButton("Quit");
        quitButton.setPreferredSize(new Dimension(120, 40));
        quitButton.setBackground(Color.RED);
        quitButton.setForeground(Color.WHITE);
        quitButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginPanel.add(quitButton, constraints);
        loginTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButton.doClick();
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentID = 0000000;
                boolean validInput = false;

                while (!validInput) {
                    try {
                        studentID = Integer.parseInt(loginTextField.getText());
                        String inputString = String.valueOf(studentID);

                        if (inputString.length() < 7) {
                            JOptionPane.showMessageDialog(null,
                                    "Invalid ID Number. SLU ID Number contains 7 integers. Try again");
                            loginTextField.setText("");
                            validInput = false;
                        } else
                            validInput = true;
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid ID Number. Try again.");
                        loginTextField.setText("");
                        return;
                    } // end of try-catch
                } // end of while
                try {
                    File studentFile = new File(studentID + ".txt");
                    inputStream = new BufferedReader(new FileReader("Student Records/" + studentFile));
                    inputStream.close();
                    populateGUIComponents();
                } catch (FileNotFoundException ex) {
                    loginFrame.dispose();
                    createRecordComponents(studentID);
                } catch (IOException exception) {
                    exception.printStackTrace();
                } // end of try-catch
            } // end of actionPerformed method
        }); // end of addActionListener for loginButton
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        loginFrame.add(loginPanel);
        loginFrame.pack();
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);
    } // end of loginFormComponents method

    /**
     * Creates student record when no record has been found.
     */
    private void createRecordComponents (int studentID) {
        JFrame recordFrame = new JFrame("Student Record Form");
        recordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel recordPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;

        JLabel loginLabel = new JLabel("No student record found. Default record has been created.");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 14));
        recordPanel.add(loginLabel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.CENTER;

        JButton createButton = new JButton("Create");
        createButton.setPreferredSize(new Dimension(120, 40));
        createButton.setBackground(Color.BLUE);
        createButton.setForeground(Color.WHITE);
        createButton.setFont(new Font("Arial", Font.BOLD, 14));
        recordPanel.add(createButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.CENTER;

        JButton quitButton = new JButton("Quit");
        quitButton.setPreferredSize(new Dimension(120, 40));
        quitButton.setBackground(Color.RED);
        quitButton.setForeground(Color.WHITE);
        quitButton.setFont(new Font("Arial", Font.BOLD, 14));
        recordPanel.add(quitButton, constraints);

        recordFrame.add(recordPanel);
        recordFrame.pack();
        recordFrame.setLocationRelativeTo(null); // center the frame on the screen
        recordFrame.setVisible(true);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    outputStream = new PrintWriter(new FileWriter("Student Records/" + studentID + ".txt"));
                    outputStream.close();
                    recordFrame.dispose();
                    signupFormComponents(studentID);
                } catch (IOException ioException) {
                    ioException.getMessage();
                } // end of try-catch
            } // end of actionPerformed method
        }); // end of actionListener for createButton

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordFrame.dispose();
            }
        });
    } // end of createRecordComponents method

    private void signupFormComponents(int studentID) {
        JFrame signupFrame = new JFrame("Student Signup Form");
        JPanel signupPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 15);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;

        // Load the image
        ImageIcon logoIcon = new ImageIcon("slu_school_logo.png");

        // Scale the image to a smaller size
        Image logoImage = logoIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledLogoIcon = new ImageIcon(logoImage);

        // Create the JLabel with the scaled image
        JLabel logoLabel = new JLabel(scaledLogoIcon);
        signupPanel.add(logoLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;

        JLabel signupTitleLabel = new JLabel("Student Signup");
        signupTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        signupPanel.add(signupTitleLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;

        JSeparator separator = new JSeparator();
        separator.setPreferredSize(new Dimension(450, 2));
        signupPanel.add(separator, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.WEST;

        JLabel idLabel = new JLabel("SLU ID Number:");
        idLabel.setFont(new Font("Arial", Font.BOLD, 14));
        signupPanel.add(idLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.WEST;

        JTextField idTextField = new JTextField(20);
        idTextField.setText(String.valueOf(studentID));
        idTextField.setEditable(false);
        signupPanel.add(idTextField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 1;

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        signupPanel.add(lastNameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.anchor = GridBagConstraints.WEST;

        JTextField lastNameTextField = new JTextField(20);
        signupPanel.add(lastNameTextField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.gridwidth = 1;

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 14));
        signupPanel.add(firstNameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.anchor = GridBagConstraints.WEST;

        JTextField firstNameTextField = new JTextField(20);
        signupPanel.add(firstNameTextField, constraints);

        constraints.gridx = 1;
        constraints.gridy = 8;
        constraints.gridwidth = 1;

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setFont(new Font("Arial", Font.BOLD, 14));
        signupPanel.add(ageLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 9;
        constraints.anchor = GridBagConstraints.WEST;

        JTextField ageTextField = new JTextField(10);
        ageTextField.setDocument(new JTextFieldLimit(2));
        signupPanel.add(ageTextField, constraints);

        constraints.gridx = 2;
        constraints.gridy = 8;
        constraints.gridwidth = 1;

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setFont(new Font("Arial", Font.BOLD, 14));
        signupPanel.add(genderLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 9;
        constraints.anchor = GridBagConstraints.WEST;

        String[] genderOptions = {"Male" , "Female"};
        JComboBox<String> genderComboBox = new JComboBox<>(genderOptions);
        genderComboBox.setEditable(false);
        signupPanel.add(genderComboBox, constraints);

        constraints.gridx = 1;
        constraints.gridy = 10;
        constraints.gridwidth = 1;

        JLabel programLabel = new JLabel("Program:");
        programLabel.setFont(new Font("Arial", Font.BOLD, 14));
        signupPanel.add(programLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 11;
        constraints.anchor = GridBagConstraints.WEST;

        JTextField programTextField = new JTextField(20);
        signupPanel.add(programTextField, constraints);

        constraints.gridx = 2;
        constraints.gridy = 10;
        constraints.gridwidth = 1;

        JLabel yearLabel = new JLabel("Year Level:");
        yearLabel.setFont(new Font("Arial", Font.BOLD, 14));
        signupPanel.add(yearLabel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 11;
        constraints.anchor = GridBagConstraints.WEST;

        Integer[] yearOptions = {1,2,3,4};
        JComboBox<Integer> yearComboBox2 = new JComboBox<>(yearOptions);
        signupPanel.add(yearComboBox2, constraints);

        constraints.gridx = 1;
        constraints.gridy = 13;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;

        JButton signupButton = new JButton("Create Record");
        signupButton.setPreferredSize(new Dimension(150, 40));
        signupButton.setBackground(Color.BLUE);
        signupButton.setForeground(Color.WHITE);
        signupButton.setFont(new Font("Arial", Font.BOLD, 14));
        signupPanel.add(signupButton, constraints);

        constraints.gridx = 1;
        constraints.gridy = 14;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.CENTER;

        JButton quitButton = new JButton("Cancel");
        quitButton.setPreferredSize(new Dimension(120, 40));
        quitButton.setBackground(Color.RED);
        quitButton.setForeground(Color.WHITE);
        quitButton.setFont(new Font("Arial", Font.BOLD, 14));
        signupPanel.add(quitButton, constraints);

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    outputStream = new PrintWriter(new FileWriter("Student Records/" + studentID + ".txt"));
                    String lastName = "";
                    String firstName = "";
                    int idNumber = studentID;
                    int age = 0;
                    char gender = 'x';
                    String courseProgram = "";
                    int yearLevel = 0;

                    try {
                        lastName = lastNameTextField.getText();
                        if (lastNameTextField.getText() == "")
                            JOptionPane.showMessageDialog(null, "No Last Name given. Try again.");
                    } catch (Exception exception1) {
                        exception1.printStackTrace();
                    }

                    try {
                        firstName = firstNameTextField.getText();
                        if (firstNameTextField.getText() == "")
                            JOptionPane.showMessageDialog(null, "No First Name given. Try again.");
                    } catch (Exception exception1) {
                        exception1.printStackTrace();
                    }

                    try {
                        age = Integer.parseInt(ageTextField.getText());
                    } catch (NumberFormatException exception1) {
                        JOptionPane.showMessageDialog(null,"Invalid age. Try again");
                        ageTextField.setText("");
                    }

                    try {
                        String chosenGender = (String) genderComboBox.getSelectedItem();
                        if (chosenGender == "Male")
                            gender = 'M';
                        if (chosenGender == "Female")
                            gender = 'F';
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    try {
                        courseProgram = programTextField.getText();
                    } catch (InputMismatchException exception) {
                        exception.printStackTrace();
                    }

                    try {
                        yearLevel = (int) yearComboBox2.getSelectedItem();
                    } catch (NumberFormatException exception) {
                        exception.printStackTrace();
                    } // end of try-catch

                    students.add(new Student(lastName, firstName, idNumber, age,
                            gender, courseProgram, (byte) yearLevel));

                    outputStream.println(students); // prints Student attributes a

                    for (int index = 0; index < courses.size(); index++){
                        outputStream.println(courses.get(index).toString());
                        outputStream.println();
                    }

                    outputStream.close();

                    populateGUIComponents();
                    signupFrame.dispose();
                } catch (FileNotFoundException exception1) {
                    exception1.getMessage();
                } catch (IOException exception2) {
                    exception2.getMessage();
                } // end of try-catch
            } // end of actionPerformed method
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signupFrame.dispose();
                loginFormComponents(); // invokes login form again on signup cancellation
            }
        });
        signupFrame.add(signupPanel);
        signupFrame.pack();
        signupFrame.setVisible(true);
        signupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signupFrame.setLocationRelativeTo(null);
    } // end of signupFormComponents method
} // end of class ChecklistManagement

/**
 * Class that limits user input from JTextField using a given offset value.
 */
class JTextFieldLimit extends PlainDocument {
    private final int limit;

    /**
     * Constructs JTextFieldLimit object with user-defined values.
     *
     * @param limit input limit
     */
    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    } // end of JTextFieldLimit constructor

    /**
     * Implemented method for text field limit
     *
     * @param offset       the starting offset &gt;= 0
     * @param string       the string to insert; does nothing with null/empty strings
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
