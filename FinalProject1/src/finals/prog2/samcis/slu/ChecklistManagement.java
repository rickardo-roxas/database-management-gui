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
        populateCourse();
        // TO DO...
    } // end of run method

    /**
     * Populates ArrayList of Course from a file.
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

            } // end of while
            inputStream.close();
        } catch (IOException exception1) {
            exception1.getMessage();
        } finally {
            System.out.println("TO DO...");
        } // end of try-catch
        return courses;
    } // end of populateCourse method
} // end of class ChecklistManagement
