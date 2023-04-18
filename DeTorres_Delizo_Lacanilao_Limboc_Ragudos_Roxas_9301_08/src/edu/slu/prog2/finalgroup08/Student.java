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
 * The Student class.
 * <p>
 *      This reference class provides a blueprint for creating a Student object
 *      that can store and manage the courses and grades of a student. The class
 *      has several methods that allow adding, editing, and removing courses and
 *      grades, as well as getting different types of information such as all
 *      courses taken, courses taken in a specific term, grades for courses taken
 *      in a specific term, and the GPA of the student.
 * </p>
 */
package edu.slu.prog2.finalgroup08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student<T> {

    private String studentID;
    private String firstName;
    private String lastName;
    private Map<String, ArrayList<T>> termCourses = new HashMap<>(); // store courses for each term
    private Map<String, ArrayList<Integer>> termGrades = new HashMap<>(); // store grades for each term
    private ArrayList<T> allCourses = new ArrayList<>(); // store all courses taken by the student
    private ArrayList<Integer> allGrades = new ArrayList<>(); // store all grades of the student

    // constructor
    public Student(String studentID, String firstName, String lastName) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // getters and setters for the student's information
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // add a course for a specific term
    public void addCourse(String term, T course) {
        if (termCourses.containsKey(term)) {
            termCourses.get(term).add(course);
        } else {
            ArrayList<T> courses = new ArrayList<>();
            courses.add(course);
            termCourses.put(term, courses);
        }
        allCourses.add(course);
    }

    // add a grade for a specific course and term
    public void addGrade(String term, T course, int grade) {
        if (termGrades.containsKey(term)) {
            int index = termCourses.get(term).indexOf(course);
            termGrades.get(term).set(index, grade);
        } else {
            ArrayList<Integer> grades = new ArrayList<>();
            grades.add(grade);
            termGrades.put(term, grades);
        }
        allGrades.add(grade);
    }

    // get all courses taken by the student
    public ArrayList<T> getAllCourses() {
        return allCourses;
    }

    // get all grades of the student
    public ArrayList<Integer> getAllGrades() {
        return allGrades;
    }

    // get courses taken in a specific term
    public ArrayList<T> getCoursesByTerm(String term) {
        return termCourses.get(term);
    }

    // get grades for courses taken in a specific term
    public ArrayList<Integer> getGradesByTerm(String term) {
        return termGrades.get(term);
    }

    // get GPA of the student
    public double getGPA() {
        double sum = 0.0;
        for (int grade : allGrades) {
            sum += grade;
        }
        return sum / allGrades.size();
    }

    // edit a course information
    public void editCourse(T oldCourse, T newCourse) {
        int index = allCourses.indexOf(oldCourse);
        allCourses.set(index, newCourse);
        for (ArrayList<T> termCourses : termCourses.values()) {
            if (termCourses.contains(oldCourse)) {
                int termIndex = termCourses.indexOf(oldCourse);
                termCourses.set(termIndex, newCourse);
            }
        }
    }

    // remove the course from the records for the current term
    public void removeCourse(T course) {
        for (String term : termCourses.keySet()) {
            ArrayList<T> courses = termCourses.get(term);
            if (courses.contains(course)) {
                int index = courses.indexOf(course);
                courses.remove(index);
                ArrayList<Integer> grades = termGrades.get(term);
                grades.remove(index);
            }
        }
        allCourses.remove(course);
        allGrades.remove((Integer) termGrades.get("Transferred Courses").get(allCourses.indexOf(course)));
// remove the course from the records of transferred courses if it exists there
        if (termCourses.containsKey("Transferred Courses") && termCourses.get("Transferred Courses").contains(course)) {
            termCourses.get("Transferred Courses").remove(course);
            termGrades.get("Transferred Courses").remove((Integer) allGrades.get(allCourses.indexOf(course)));
        }
    }

    // handle a course taken from another program
    public void handleShifterCourse(T course, String program) {
        // add the course to the records
        addCourse("Transferred Courses", course);

        // print the equivalent course for the current program
        System.out.println("Equivalent course for program " + program + ": ");
        // TODO: add code to get the equivalent course for the current program
    }

    // add an elective course
    public void addElectiveCourse(T course) {
        // add the course to the records
        addCourse("Elective Courses", course);
    }

    // display courses for each term
    public void displayCoursesByTerm() {
        for (String term : termCourses.keySet()) {
            System.out.println("Term: " + term);
            System.out.println("Courses: " + termCourses.get(term));
        }
    }

    // display courses with grades for each term
    public void displayCoursesWithGradesByTerm() {
        for (String term : termCourses.keySet()) {
            System.out.println("Term: " + term);
            ArrayList<T> courses = termCourses.get(term);
            ArrayList<Integer> grades = termGrades.get(term);
            for (int i = 0; i < courses.size(); i++) {
                System.out.println(courses.get(i) + " Grade: " + grades.get(i));
            }
        }
    }

    // display an arranged list of the courses taken following descending order based on grades
    public void displayCoursesByGrades() {
        ArrayList<T> sortedCourses = new ArrayList<>(allCourses);
        ArrayList<Integer> sortedGrades = new ArrayList<>(allGrades);
        for (int i = 0; i < sortedGrades.size() - 1; i++) {
            for (int j = i + 1; j < sortedGrades.size(); j++) {
                if (sortedGrades.get(i) < sortedGrades.get(j)) {
                    // swap grades
                    int tempGrade = sortedGrades.get(i);
                    sortedGrades.set(i, sortedGrades.get(j));
                    sortedGrades.set(j, tempGrade);
                    // swap courses
                    T tempCourse = sortedCourses.get(i);
                    sortedCourses.set(i, sortedCourses.get(j));
                    sortedCourses.set(j, tempCourse);
                }
            }
        }
        System.out.println("Courses by grades:");
        for (int i = 0; i < sortedCourses.size(); i++) {
            System.out.println(sortedCourses.get(i) + " Grade: " + sortedGrades.get(i));
        }
    }
}
