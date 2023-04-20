package finals.prog2.samcis.slu;

public class Grade extends Course {
    private double grade;

    public Grade() {
        super();
        grade = 75;
    }

    public Grade(int grade) {
        // TO-DO
    }

    public void setGrade(double gradeValue) {
        this.grade = gradeValue;
    } // end of setGradeValue mutator method

    public double getGrade() {
        return this.grade;
    } // end of getGradeValue accessor method
} // end of Grade class
