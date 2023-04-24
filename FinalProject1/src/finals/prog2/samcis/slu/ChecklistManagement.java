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


public class ChecklistManagement extends JFrame {
    // GUI Components

    // Labels
    private JLabel loginLabel;
    // Buttons
    private JButton quitButton;
    private JButton loginButton;
    private JButton createButton;
    // Text Fields
    private JTextField loginTextField;
    private JTextArea textArea;
    private JComboBox<Integer> termComboBox;
    private JComboBox<Integer> yearComboBox;

    // ArrayLists
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Grade> grades = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    // BufferedReader objects
    private BufferedReader inputStream;

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
            checklistManagement.setVisible(true);
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

            for (int index = 0; index < courses.size(); index++)
                System.out.println(courses.get(index) + "\n");
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

    private void populateGUIComponents() {
        // Create main frame
        JFrame frame = new JFrame("Checklist Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create header panel
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(56, 79, 141));

        // Add logo to header panel
        ImageIcon logoIcon = new ImageIcon("logo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        headerPanel.add(logoLabel, BorderLayout.WEST);

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
        JButton showSubjectsBtn = new JButton("Show subjects for each school term");
        JButton showGradesBtn = new JButton("Show subjects with grades for each term");
        JButton enterGradesBtn = new JButton("Enter grades for subjects recently finished");
        JButton editCourseBtn = new JButton("Edit Course");
        JButton quitBtn = new JButton("Quit");
        showSubjectsBtn.setPreferredSize(new Dimension(250, 50));
        showGradesBtn.setPreferredSize(new Dimension(250, 50));
        enterGradesBtn.setPreferredSize(new Dimension(250, 50));
        editCourseBtn.setPreferredSize(new Dimension(250, 50));
        quitBtn.setPreferredSize(new Dimension(250, 50));
        buttonsPanel.add(showSubjectsBtn);
        buttonsPanel.add(showGradesBtn);
        buttonsPanel.add(enterGradesBtn);
        buttonsPanel.add(editCourseBtn);
        buttonsPanel.add(quitBtn);

        // Create form panel
        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));

        // Add combo boxes to form panel
        termComboBox = new JComboBox<>();
        yearComboBox = new JComboBox<>();
        termComboBox.setPreferredSize(new Dimension(150, 30));
        yearComboBox.setPreferredSize(new Dimension(150, 30));
        JPanel comboPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        comboPanel.add(new JLabel("Select Year:"));
        comboPanel.add(yearComboBox);
        comboPanel.add(new JLabel("Select Term:"));
        comboPanel.add(termComboBox);
        formPanel.add(comboPanel, BorderLayout.NORTH);

        // Add text area to form panel
        textArea = new JTextArea(20, 50);
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
                for (Course course : courses) {
                    if (course instanceof Course && course.getYear() == selectedYear && course.getTerm() == selectedTerm) {
                        textArea.append(course.getCourseNumber() + "\t" + course.getDescriptiveTitle() + "\t"
                                + course.getUnits() + "\n");
                    }
                }
            }
        });

        showGradesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected year and term
                int selectedYear = (int) yearComboBox.getSelectedItem();
                int selectedTerm = (int) termComboBox.getSelectedItem();

                // Loop through the courses and display the courses that match the selected year and term
                textArea.setText("");
                for (Course course : courses) {
                    if (course instanceof Course && course.getYear() == selectedYear && course.getTerm() == selectedTerm) {
                        textArea.append(course.getCourseNumber() + "\t" + course.getDescriptiveTitle() + "\t"
                                + course.getUnits() + "\n");

                        // Loop through the students and display the grade for each student in the selected course
                        for (Student student : students) {
                            Grade grade = student.getGrades().get(course);
                            if (grade != null) {
                                textArea.append("\t" + student.getLastName() + ": " + grade.getGrade() + "\n");
                            }
                        }
                    }
                }
            }
        });

        enterGradesBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected year and term
                int selectedYear = (int) yearComboBox.getSelectedItem();
                int selectedTerm = (int) termComboBox.getSelectedItem();

                // Loop through the courses and display the courses that match the selected year and term, and allow the user to enter grades for each student in the selected courses
                textArea.setText("");
                for (Course course : courses) {
                    if (course instanceof Course && course.getYear() == selectedYear && course.getTerm() == selectedTerm) {
                        textArea.append(course.getCourseNumber() + "\t" + course.getDescriptiveTitle() + "\t"
                                + course.getUnits() + "\n");
                        // Loop through the students and allow the user to enter or modify the grade for each student in the selected course
                        for (Student student : students) {
                            Grade grade = student.getGrades().get(course);
                            String input = JOptionPane.showInputDialog("Enter grade for " + student.getLastName() + " in " + course.getCourseNumber());
                            if (input != null && !input.isEmpty()) {
                                double gradeValue = Double.parseDouble(input);
                                if (grade == null) {
                                    grade = new Grade(gradeValue);
                                    student.getGrades().put(course, grade);
                                } else {
                                    grade.setGrade(gradeValue);
                                }
                            }
                        }
                    }
                }
            }
        });

        editCourseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected year and term
                int selectedYear = (int) yearComboBox.getSelectedItem();
                int selectedTerm = (int) termComboBox.getSelectedItem();

                // Loop through the courses and display the courses that match the selected year and term
                textArea.setText("");
                for (Course course : courses) {
                    if (course instanceof Course && course.getYear() == selectedYear && course.getTerm() == selectedTerm) {
                        textArea.append(course.getCourseNumber() + "\t" + course.getDescriptiveTitle() + "\t"
                                + course.getUnits() + "\n");
                    }
                }

                // Prompt the user to select a course to edit
                String courseNumber = JOptionPane.showInputDialog(null, "Enter the course number of the course you would like to edit:");

                // Find the course with the given course number and display its details
                for (Course course : courses) {
                    if (course instanceof Course && course.getCourseNumber().equals(courseNumber)) {
                        String input = JOptionPane.showInputDialog("Enter new course number:");
                        if (input != null && !input.isEmpty()) {
                            course.setCourseNumber(input);
                        }

                        input = JOptionPane.showInputDialog("Enter new course title:");
                        if (input != null && !input.isEmpty()) {
                            course.setDescriptiveTitle(input);
                        }

                        // Validate and set the course year
                        while (true) {
                            input = JOptionPane.showInputDialog("Enter new course year (1, 2, 3, or 4):");
                            if (input != null && !input.isEmpty()) {
                                int year = Integer.parseInt(input);
                                if (year >= 1 && year <= 4) {
                                    course.setYear(year);
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid input. Year must be 1, 2, 3, or 4.");
                                }
                            } else {
                                break;
                            }
                        }

                        // Validate and set the course term
                        while (true) {
                            input = JOptionPane.showInputDialog("Enter new course term (1, 2, or 3):");
                            if (input != null && !input.isEmpty()) {
                                int term = Integer.parseInt(input);
                                if (term >= 1 && term <= 3) {
                                    course.setTerm(term);
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid input. Term must be 1, 2, or 3.");
                                }
                            } else {
                                break;
                            }
                        }

                        break;
                    }
                }
            }
        });


        quitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    /**
     * Shows the UI when a student is logging in the program.
     */
    private void loginFormComponents() {
        setTitle("Student Login Form");
        JPanel loginPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
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

        add(loginPanel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentID = 0000000;
                try {
                    studentID = Integer.parseInt(loginTextField.getText());
                } catch (NumberFormatException ex) {
                    loginTextField.setText("Please enter a valid SLU ID Number");
                    return;
                }
                try {
                    inputStream = new BufferedReader(new FileReader(String.valueOf(studentID)));
                } catch (FileNotFoundException ex) {
                    createRecordComponents();
                    return;
                }
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }


    /**
     * Creates student record when no record has been found.
     */
    private void createRecordComponents () {
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
                recordFrame.dispose();
                populateGUIComponents();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recordFrame.dispose();
            }
        });
    } // end of createRecordComponents method
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
