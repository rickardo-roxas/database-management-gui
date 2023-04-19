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

import java.util.ArrayList;

public class Course <Course> {
    private byte year; // Year of Course (e.g. Year 1)
    private byte term; // Term of Course (the semester)
    private String courseNumber; // Course Number of Course (e.g. CS 111)
    private String descriptiveTitle; // Descriptive title of Course (e.g. "Intro. to Computing)
    private byte units; // Number of units of Course (e.g. 3 Units)
    private ArrayList<Course> allCourses = new ArrayList<>(); // stores all Courses in an array list

    /**
     * Constructs an object of Course with default values.
     */
    public Course() {
        year = 1;
        term = 1;
        courseNumber = "CS 111";
        descriptiveTitle = "Introduction to Computing";
        units = 2;
    } // end of Course default constructor

    /**
     * Constructs an object of Course with user-defined values.
     * @param year given year
     * @param term given term
     * @param courseNumber given courseNumber
     * @param descriptiveTitle given descriptiveTitle
     * @param units given units
     */
    public Course(byte year, byte term, String courseNumber, String descriptiveTitle, byte units) {
        this.year = year;
        this.term = term;
        this.courseNumber = courseNumber;
        this.descriptiveTitle = descriptiveTitle;
        this.units = units;
    } // end of Course constructor

    public void setYear(byte year) {
        this.year = year;
    } // end of setYear mutator method

    public void setTerm(byte term) {
        this.term = term;
    } // end of setTerm method mutator method

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    } // end of setCourseNumber mutator method

    public void setDescriptiveTitle(String descriptiveTitle) {
        this.descriptiveTitle = descriptiveTitle;
    } // end of descriptiveTitle mutator method

    public void setUnits(byte units) {
        this.units = units;
    } // end of setUnits mutator method

    public byte getYear() {
        return this.year;
    } // end of getYear accessor method

} // end of class Course
