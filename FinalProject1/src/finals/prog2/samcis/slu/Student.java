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
 Class respresenting a Student.It has a default constructor and a user-defined constructor for setting attribute values.
 Provides mutator and accessor methods for updating and retrieving attribute values.It also includes a toString method
 for returning a string representation of the object.
 */
public class Student {
    private String lastName; // The last name of the student
    private String firstName; // The first name of the student
    private int idNumber; // The ID number of the student
    private int age; // The age of the student
    private String courseProgram; // The course program of the student
    /**
     * Constructs an object of Student with default values.
     */
    public Student() {
        lastName = "Pascual";
        firstName = "Scheherazade";
        idNumber = 2233444;
        age = 19;
        courseProgram = "BS Computer Science";
    } // end of Student default constructor

    /**
     * Constructs an object of Student with user-defined values.
     *
     * @param lastName      The last name of the student
     * @param firstName     The first name of the student
     * @param idNumber      The ID number of the student
     * @param age           The age of the student
     * @param courseProgram The course program of the student
     */
    public Student(String lastName, String firstName, int idNumber, int age, String courseProgram) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.idNumber = idNumber;
        this.age = age;
        this.courseProgram = courseProgram;
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
     * Mutator method for the course program attribute.
     * @param courseProgram The new course program of the student
     */
    public void setCourseProgram(String courseProgram) {
        this.courseProgram = courseProgram;
    } // end of setCourseProgram mutator method

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
     * Returns a string representation of the Student object.
     * @return A string representation of the Student object
     */
    public String toString() {
        return "Name: " + firstName + " " + lastName + ", ID Number: " + idNumber + ", Age: " + age
                + ", Program: " + courseProgram;
    }// end of toString method
} // end of Student Class

