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

/**
 * The Course class provides a blueprint for creating a Course object. The class has the conventional accessor, mutator,
 * and toString methods.
 */
public class Course {
    private int year; // Year of Course (e.g. Year 1)
    private int term; // Term of Course (the semester)
    private String courseNumber; // Course Number of Course (e.g. CS 111)
    private String descriptiveTitle; // Descriptive title of Course (e.g. "Intro. to Computing)
    private double units; // Number of units of Course (e.g. 3 Units)
    private String grade; // grade of Student for respective Course

    /**
     * Constructs an object of Course with default values.
     */
    public Course() {
        year = 1;
        term = 1;
        courseNumber = "CS 111";
        descriptiveTitle = "Introduction to Computing";
        units = 2;
        grade = "Not Yet Taken";
    } // end of Course default constructor

    /**
     * Constructs an object of Course with user-defined values.
     * @param year given year
     * @param term given term
     * @param courseNumber given courseNumber
     * @param descriptiveTitle given descriptiveTitle
     * @param units given units
     */
    public Course(int year, int term, String courseNumber, String descriptiveTitle, double units) {
        this.year = year;
        this.term = term;
        this.courseNumber = courseNumber;
        this.descriptiveTitle = descriptiveTitle;
        this.units = units;
    } // end of Course constructor

    /**
     * Constructs an object of Course with user-defined values.
     * @param year given year
     * @param term given term
     * @param courseNumber given courseNumber
     * @param descriptiveTitle given descriptiveTitle
     * @param units given units
     * @param grade given grade
     */
    public Course(int year, int term, String courseNumber, String descriptiveTitle, double units, String grade) {
        this.year = year;
        this.term = term;
        this.courseNumber = courseNumber;
        this.descriptiveTitle = descriptiveTitle;
        this.units = units;
        this.grade = grade;
    } // end of Course constructor with Grade attribute

    /**
     * Mutator/Setter method for the year attribute.
     * @param year - given year
     */
    public void setYear(int year) {
        this.year = year;
    } // end of setYear mutator method

    /**
     * Mutator/Setter method for the term attribute.
     * @param term - given term
     */
    public void setTerm(int term) {
        this.term = term;
    } // end of setTerm method mutator method

    /**
     * Mutator/Setter method for the courseNumber attribute.
     * @param courseNumber given courseNumber
     */
    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    } // end of setCourseNumber mutator method

    /**
     * Mutator/Setter method for the descriptiveTitle attribute.
     * @param descriptiveTitle given descriptiveTitle
     */
    public void setDescriptiveTitle(String descriptiveTitle) {
        this.descriptiveTitle = descriptiveTitle;
    } // end of descriptiveTitle mutator method

    /**
     * Mutator/Setter method for the units attribute.
     * @param units given units
     */
    public void setUnits(int units) {
        this.units = units;
    } // end of setUnits mutator method

    public void setGrade(double grade) {
        this.grade = String.valueOf(grade);
        if (grade > 99)
            this.grade = String.valueOf(99);
        if (grade < 65)
            this.grade = "Failed";
    } // end of setGrade mutator method

    /**
     * Accessor/Getter method for year
     * @return state/value of the year attribute
     */
    public int getYear() {
        return this.year;
    } // end of getYear accessor method

    /**
     * Accessor/Getter method for term
     * @return state/value of the term attribute
     */
    public int getTerm() {
        return this.term;
    } // end of getTerm accessor method

    /**
     * Accessor/Getter method for courseNumber
     *
     * @return state/value of the courseNumber attribute
     */
    public String getCourseNumber() {
        return this.courseNumber;
    } // end of getCourseNumber accessor method

    /**
     * Accessor/Getter method for descriptiveTitle
     * @return state/value of the descriptiveTitle attribute
     */
    public String getDescriptiveTitle() {
        return this.descriptiveTitle;
    } // end of getDescriptiveTitle accessor method

    /**
     * Accessor/Getter method for units
     * @return state/value of units attribute
     */
    public double getUnits() {
        return this.units;
    } // end of getUnits accessor method

    /**
     * Accessor/Getter method for grade
     * @return state/value of grade attribute
     */
    public String getGrade() {
        return this.grade;
    } // end of getGrade accessor method

    /**
     * Concatenates that state of Course attributes
     * @return comma-separated values
     */
    public String toString() {
        return year + "," + term + "," + courseNumber + "," + descriptiveTitle + "," + units + "," + grade;
    } // end of toString method

    /**
     * Concatenates the state of Course attributes.
     * @return formatted values
     */
    public String toStringFormatted() {
        if (grade ==  null)
            grade = "Not Yet Taken";
        return String.format("%-15s\t%-120s\t%-5.1f\t%-20s\t%n", courseNumber, descriptiveTitle, units, grade);
    } // end of toStringFormatted method

    /**
     * Concatenates the state of Course attributes without the grade attribute.
     * @return formatted values
     */
    public String toStringFormattedNoGrades() {
        return String.format("%-15s\t%-120s\t%-5.1f\t%n" , courseNumber, descriptiveTitle, units);
    } // end of toStringFormattedNoGrades method
} // end of class Course
