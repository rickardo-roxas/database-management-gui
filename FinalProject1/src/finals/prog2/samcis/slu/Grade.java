package finals.prog2.samcis.slu;

public class Grade {
    private double grade;

    /**
     * Constructs an object of Grade with default values.
     */
    public Grade() {
        grade = 99;
    } // end of Grade default constructor

    /**
     * Constructs an object of Grade with user-defined values
     * @param grade given grade
     */
    public Grade(double grade) {
        this.grade = grade;
    } // end of Grade constructor

    /**
     * Mutator/Setter method for the grade attribute.
     * @param grade given grade
     */
    public void setGrade(double grade) {
        this.grade = grade;
    } // end of setGrade mutator method

    /**
     * Accessor/Getter method for the grade attribute.
     * @return state/value of the grade attribute
     */
    public double getGrade() {
        return grade;
    } // end of getGrade accessor method
} // end of class Grade

