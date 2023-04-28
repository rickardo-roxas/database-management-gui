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
import java.util.HashMap;

/**

 Class representing a student.
 */
public class Student {
    private String lastName; // The last name of the student
    private String firstName; // The first name of the student
    private int idNumber; // The ID number of the student
    private int age; // The age of the student
    private String courseProgram; // The course program of the student
    private byte yearLevel; // The year level of the student
    private HashMap<Course, Grade> grades; // A HashMap of the student's grades for each course
    /**
     * Constructs an object of Student with default values.
     */
    public Student() {
        lastName = "Pascual";
        firstName = "Scheherazade";
        idNumber = 2233444;
        age = 19;
        courseProgram = "BS Computer Science";
        yearLevel = 1;
        grades = new HashMap<Course, Grade>();
    } // end of Student default constructor

    /**
     * Constructs an object of Student with user-defined values.
     *
     * @param lastName      The last name of the student
     * @param firstName     The first name of the student
     * @param idNumber      The ID number of the student
     * @param age           The age of the student
     * @param courseProgram The course program of the student
     * @param yearLevel     The year level of the student
     */
    public Student(String lastName, String firstName, int idNumber, int age, String courseProgram, byte yearLevel) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.idNumber = idNumber;
        this.age = age;
        this.courseProgram = courseProgram;
        this.yearLevel = yearLevel;
    } // end of Student constructor

    /**

     Accessor method for the HashMap of grades.
     @return The HashMap of the student's grades for each course
     */
    public HashMap<Course, Grade> getGrades() {
        return grades;
    } // end of getGrades accessor method
    /**

 Mutator method for a grade of a specific course.
 @param course The course to update the grade for
 @param grade The new grade for the specified course
 */

    /**
     * Mutator method for the last name attribute.
     * @param lastName The new last name of the student
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    } // end of setLastName mutator method

    /**
     * Mutator method for the first name attribute.
     * @param firstName The new first name of the student
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } // end of setFirstName mutator method

    /**
     * Mutator method for the ID number attribute.
     * @param idNumber The new ID number attribute of the student
     */
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    } // end of setIdNumber mutator method

    /**
     * Mutator method for the age attribute.
     * @param age The new age of the student
     */
    public void setAge(int age) {
        this.age = age;
    } // end of setAge mutator method

    /**
     * Mutator method for the course program attribute.
     * @param courseProgram The new course program of the student
     */
    public void setCourseProgram(String courseProgram) {
        this.courseProgram = courseProgram;
    } // end of setCourseProgram mutator method

    /**
     * Mutator method for the year level attribute.
     * @param yearLevel The new year level of the student
     */
    public void setYearLevel(byte yearLevel) {
        this.yearLevel = yearLevel;
    } // end of setYearLevel mutator method

    /**
     * Accessor method for the last name attribute.
     * @return The last name of the student
     */
    public String getLastName() {
        return lastName;
    } // end of getLastName accessor method

    /**
     * Accessor method for the first name attribute.
     * @return The first name of the student
     */
    public String getFirstName() {
        return firstName;
    } // end of getFirstName accessor method

    /**
     * Accessor method for the ID number attribute.
     * @return The ID number of the student
     */
    public int getIdNumber() {
        return idNumber;
    } // end of getIdNumber accessor method

    /**
     * Accessor method for the age attribute.
     * @return The age of the student
     */
    public int getAge() {
        return age;
    } // end of getAge accessor method

    /**
     * Accessor method for the course program attribute.
     * @return The course program of the student
     */
    public String getCourseProgram() {
        return courseProgram;
    } // end of getCourseProgram accessor method

    /**
     * Accessor method for the year level attribute.
     * @return The year level of the student
     */
    public byte getYearLevel() {
        return yearLevel;
    } // end of getYearLevel accessor method

    /**
     * Accessor method for the grade attribute.
     * @return The grade of the student
     */
    public Grade getGrade(Course course) {
        return grades.get(course);
    } // end of getGrade accessor method
     // end of getYearLevel accessor method

    /**
     * Returns a string representation of the Student object.
     * @return A string representation of the Student object
     */
    public String toString() {
        return firstName + " " + lastName + ", ID number: " + idNumber + ", age: " + age
                + ", course program: " + courseProgram + ", year level: " + yearLevel;
    }// end of toString method
} // end of Student Class

