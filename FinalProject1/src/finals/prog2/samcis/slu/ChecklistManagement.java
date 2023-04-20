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

/**
 * The ChecklistManagement class is under construction...
 */
public class ChecklistManagement {
    /**
     * Main entry point of the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ChecklistManagement checklistManagement;
        try {
            checklistManagement = new ChecklistManagement();
            checklistManagement.run();
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
     * @return Populated Course ArrayList
     * @throws FileNotFoundException TO DO...
     */
    public ArrayList<Course> populateCourse() throws IOException {
        ArrayList<Course> courses = new ArrayList<>();
        BufferedReader inputStream;

        try {
            inputStream = new BufferedReader(new FileReader("BSCSCurriculumData1.txt"));

            while (inputStream.readLine() != null) {
                String course = inputStream.readLine();
                String[] courseData = course.split(",");

                byte courseYear = Byte.parseByte(courseData[0]);
                byte courseTerm = Byte.parseByte(courseData[1]);
                String courseNumber = courseData[2];
                String courseDescriptiveTitle = courseData[3];
                byte units = Byte.parseByte(courseData[4]);

                Course newCourse = new Course(courseYear, courseTerm, courseNumber, courseDescriptiveTitle, units);
                courses.add(newCourse);
            } // end of while
            inputStream.close(); // Closes inputStream when readLine == null
        } catch (IOException exception1) {
            exception1.getMessage();
        } finally {
            System.out.println("TO DO...");
        } // end of try-catch
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
