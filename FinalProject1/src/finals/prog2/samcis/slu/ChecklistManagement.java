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
import javax.swing.*;
import java.awt.*;


public class ChecklistManagement extends JFrame {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<Grade> grades = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

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

    private void run() throws Exception {
        populateCourse();

    } // end of run method

    private void populateCourse() throws FileNotFoundException {
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
    } // end of populateCourse method

    private void populateGUIComponents() {
        // Add JFrame stuff here
        // Invoke in run method
        // For shorter code
    }
} // end of class ChecklistManagement