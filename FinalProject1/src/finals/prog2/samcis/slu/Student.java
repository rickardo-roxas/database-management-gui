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
    private String lastName;
    private String firstName;
    private int idNumber;
    private int age;
    private char gender;
    private String courseProgram;
    private byte yearLevel;

    /**
     * Constructs an object of Student with default values.
     */
    public Student() {
        lastName = "Doe";
        firstName = "John";
        idNumber = 0;
        age = 18;
        gender = 'M';
        courseProgram = "BS Computer Science";
        yearLevel = 1;
    }

    /**
     * Constructs an object of Student with user-defined values.
     *
     * @param lastName      the last name of the student
     * @param firstName     the first name of the student
     * @param idNumber      the ID number of the student
     * @param age           the age of the student
     * @param gender        the gender of the student (M or F)
     * @param courseProgram the course program of the student
     * @param yearLevel     the year level of the student
     */
    public Student(String lastName, String firstName, int idNumber, int age, char gender, String courseProgram, byte yearLevel) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.idNumber = idNumber;
        this.age = age;
        this.gender = gender;
        this.courseProgram = courseProgram;
        this.yearLevel = yearLevel;
    }
}
