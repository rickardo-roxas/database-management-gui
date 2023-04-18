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
 * The Course class.
 * This class was made by:
 * <p>
 *     ROXAS, Johan Rickardo A. - 2233375
 * </p>
 */
package finals.prog2.samcis.slu;

public class Course {
    private int year;
    private int term;
    private String courseNumber;
    private String descriptiveTitle;
    private int units;

    public Course() {
        year = 1;
        term = 1;
        courseNumber = "CS 111";
        descriptiveTitle = "Introduction to Computing";
        units = 2;
    } // end of Course constructor

    public Course(int year, int term, String courseNumber, String descriptiveTitle, int units) {

    }
} // end of class Course
