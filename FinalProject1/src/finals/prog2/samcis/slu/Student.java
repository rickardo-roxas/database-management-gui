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

 Class representing a student.
 */
public class Student {
    private String lastName; // The last name of the student
    private String firstName; // The first name of the student
    private int idNumber; // The ID number of the student
    private int age; // The age of the student
    private char gender; // The gender of the student (M or F)
    private String courseProgram; // The course program of the student
    private byte yearLevel; // The year level of the student

    /**
     * Constructs an object of Student with default values.
     */
    public Student() {
        lastName = "Pascual";
        firstName = "Scheherazade";
        idNumber = 2233444;
        age = 19;
        gender = 'M';
        courseProgram = "BS Computer Science";
        yearLevel = 1;
    } // end of Student default constructor

    /**
     * Constructs an object of Student with user-defined values.
     *
     * @param lastName      The last name of the student
     * @param firstName     The first name of the student
     * @param idNumber      The ID number of the student
     * @param age           The age of the student
     * @param gender        The gender of the student (M or F)
     * @param courseProgram The course program of the student
     * @param yearLevel     The year level of the student
     */
    public Student(String lastName, String firstName, int idNumber, int age, char gender, String courseProgram, byte yearLevel) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.idNumber = idNumber;
        this.age = age;
        this.gender = gender;
        this.courseProgram = courseProgram;
        this.yearLevel = yearLevel;
    } // end of Student constructor

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
     * Mutator method for the gender attribute.
     * @param gender The new gender of the student (M or F)
     */
    public void setGender(char gender) {
        this.gender = gender;
    } // end of setGender mutator method

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
} // end of Student Class
