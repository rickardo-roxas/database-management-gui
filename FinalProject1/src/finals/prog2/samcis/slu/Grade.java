package finals.prog2.samcis.slu;

public class Grade {
    private Course course;
    private Student student;
    private double grade;

    public Grade(Course course, Student student, double grade) {
        this.course = course;
        this.student = student;
        this.grade = grade;
    }


    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
