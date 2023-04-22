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

import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class ChecklistManagement extends JFrame implements ActionListener {

    private final JButton showSubjectsBtn;
    private final JButton showGradesBtn;
    private final JButton enterGradesBtn;
    private final JButton editCourseBtn;
    private final JButton quitBtn;
    private final JTextArea textArea;
    private final JComboBox<Integer> termComboBox;
    private final JComboBox<Integer> yearComboBox;

    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    public ChecklistManagement() {
        super("My Checklist Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create buttons
        showSubjectsBtn = new JButton("Show subjects for each school term");
        showGradesBtn = new JButton("Show subjects with grades for each term");
        enterGradesBtn = new JButton("Enter grades for subjects recently finished");
        editCourseBtn = new JButton("Edit a course");
        quitBtn = new JButton("Quit");

        // Create combo boxes
        termComboBox = new JComboBox<>();
        yearComboBox = new JComboBox<>();

        // Create text area
        textArea = new JTextArea(20, 50);

        // Add buttons, combo boxes, and text area to panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        JPanel topPanel = new JPanel();
        topPanel.add(showSubjectsBtn);
        topPanel.add(showGradesBtn);
        topPanel.add(enterGradesBtn);
        topPanel.add(editCourseBtn);
        topPanel.add(quitBtn);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("Select Year:"));
        bottomPanel.add(yearComboBox);
        bottomPanel.add(new JLabel("Select Term:"));
        bottomPanel.add(termComboBox);
        bottomPanel.add(new JScrollPane(textArea));
        panel.add(topPanel);
        panel.add(bottomPanel);
        add(panel);

        // Add action listeners to buttons
        showSubjectsBtn.addActionListener(this);
        showGradesBtn.addActionListener(this);
        enterGradesBtn.addActionListener(this);
        editCourseBtn.addActionListener(this);
        quitBtn.addActionListener(this);

        // Initialize combo boxes
        for (int i = 1; i <= 4; i++) {
            yearComboBox.addItem(i);
        }
        for (int i = 1; i <= 3; i++) {
            termComboBox.addItem(i);
        }

        // Initialize courses and students
        try {
            courses = populateCourse();
            students = populateStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main entry point of the program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ChecklistManagement checklistManagement;

        try {
            checklistManagement = new ChecklistManagement();
            checklistManagement.pack();
            checklistManagement.setVisible(true);
        } catch (Exception exception) {
            exception.printStackTrace();
        } // end of try-catch
        System.exit(0);
    } // end of main method

    /**
     * Controls the execution of the program.
     * @throws Exception TO DO...
     */
    public void run() throws Exception {
        ArrayList<Course> courseArrayList;
        ArrayList<Student> studentArrayList;
        try {
            courseArrayList = new ArrayList<>(populateCourse());
            studentArrayList = new ArrayList<>(populateStudent());

            // TO DO...
        } catch (Exception exception1) {
            System.out.println("TO DO...");
        } finally {
            System.out.println("TO DO...");
        } // end of try-catch
    } // end of run method

    /**
     * Populates ArrayList of Course from curriculum file.
     *
     * @return Populated Course ArrayList
     * @throws FileNotFoundException
     */
    public ArrayList<Course> populateCourse() throws IOException {
        ArrayList<Course> courses = new ArrayList<>();
        BufferedReader inputStream;

        try {
            inputStream = new BufferedReader(new FileReader("BSCSCurriculumData.txt"));

            while (inputStream.ready()) {
                String line = inputStream.readLine();
                String[] tokens = line.split("\t");
                String courseCode = tokens[0];
                String courseTitle = tokens[1];
                int units = Integer.parseInt(tokens[2]);
                int year = Integer.parseInt(tokens[3]);
                int term = Integer.parseInt(tokens[4]);

                Course course = new Course();
                course.setYear((byte) year);
                course.setTerm((byte) term);
                course.setCourseNumber(courseCode);
                course.setDescriptiveTitle(courseTitle);
                course.setUnits((byte) units);

                courses.add(course);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return courses;
    } // end of populateCourse method

    /**
     * Populates ArrayList of Student from user input.
     * @return Populated Student ArrayList
     */
    public ArrayList<Student> populateStudent() {
        ArrayList<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the number of students to input
        try {
            System.out.print("Enter the number of students: ");
            int numStudents = scanner.nextInt();
            scanner.nextLine();

            // Loop through the number of students and prompt the user to input each student's information
            for (int i = 0; i < numStudents; i++) {
                System.out.printf("\nStudent %d:\n", i + 1);

                // Prompt the user for the student's last name
                System.out.print("Last name: ");
                String lastName = scanner.nextLine();

                // Prompt the user for the student's first name
                System.out.print("First name: ");
                String firstName = scanner.nextLine();

                // Prompt the user for the student's ID number
                System.out.print("ID number: ");
                int idNumber = scanner.nextInt();
                scanner.nextLine();

                // Prompt the user for the student's age
                System.out.print("Age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                // Prompt the user for the student's gender and check if it's valid
                System.out.print("Gender (M/F): ");
                char gender = scanner.nextLine().charAt(0);
                if (gender != 'M' && gender != 'F') {
                    throw new IllegalArgumentException("Invalid gender. Must be 'M' or 'F'.");
                }

                // Prompt the user for the student's course program
                System.out.print("Course program: ");
                String courseProgram = scanner.nextLine();

                // Prompt the user for the student's year level and check if it's valid
                System.out.print("Year level: ");
                byte yearLevel = scanner.nextByte();
                scanner.nextLine();
                if (yearLevel < 1 || yearLevel > 5) {
                    throw new IllegalArgumentException("Invalid year level. Must be between 1 and 5 inclusive.");
                }

                // Create a new Student object with the inputted information and add it to the ArrayList
                Student student = new Student(lastName, firstName, idNumber, age, gender, courseProgram, yearLevel);
                students.add(student);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Must be an integer.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
        return students;
    } // end of populateStudent method
} // end of class ChecklistManagement