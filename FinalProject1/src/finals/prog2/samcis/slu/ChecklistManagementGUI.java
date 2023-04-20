package finals.prog2.samcis.slu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class ChecklistManagementGUI extends JFrame implements ActionListener {

    private JButton showSubjectsBtn;
    private JButton showGradesBtn;
    private JButton enterGradesBtn;
    private JButton editCourseBtn;
    private JButton quitBtn;
    private JTextArea textArea;
    private JComboBox<Integer> termComboBox;
    private JComboBox<Integer> yearComboBox;

    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    public ChecklistManagementGUI() {
        super("My Checklist Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create buttons
        showSubjectsBtn = new JButton("Show subjects for each school term");
        showGradesBtn = new JButton("Show subjects with grades for each term");
        enterGradesBtn = new JButton("Enter grades for subjects recently finished");
        editCourseBtn = new JButton("Edit a course");
        quitBtn = new JButton("Quit");

        // Create combo boxes
        termComboBox = new JComboBox<>();
        yearComboBox = new JComboBox<>();

        // Create text area
        textArea = new JTextArea(20, 50);

        // Add buttons, combo boxes, and text area to panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        JPanel topPanel = new JPanel();
        topPanel.add(showSubjectsBtn);
        topPanel.add(showGradesBtn);
        topPanel.add(enterGradesBtn);
        topPanel.add(editCourseBtn);
        topPanel.add(quitBtn);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("Select Year:"));
        bottomPanel.add(yearComboBox);
        bottomPanel.add(new JLabel("Select Term:"));
        bottomPanel.add(termComboBox);
        bottomPanel.add(new JScrollPane(textArea));
        panel.add(topPanel);
        panel.add(bottomPanel);
        add(panel);

        // Add action listeners to buttons
        showSubjectsBtn.addActionListener(this);
        showGradesBtn.addActionListener(this);
        enterGradesBtn.addActionListener(this);
        editCourseBtn.addActionListener(this);
        quitBtn.addActionListener(this);

        // Initialize combo boxes
        for (int i = 1; i <= 4; i++) {
            yearComboBox.addItem(i);
        }
        for (int i = 1; i <= 3; i++) {
            termComboBox.addItem(i);
        }

        // Initialize courses and students
        try {
            courses = populateCourse();
            students = populateStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Main entry point of the program
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ChecklistManagementGUI checklistManagement = new ChecklistManagementGUI();
        checklistManagement.pack();
        checklistManagement.setVisible(true);
    } // end of main method

    /**
     * Populates ArrayList of Course from curriculum file.
     *
     * @return Populated Course ArrayList
     * @throws FileNotFoundException
     */
    public ArrayList<Course> populateCourse() throws IOException {
        ArrayList<Course> courses = new ArrayList<>();
        BufferedReader inputStream;

        try {
            inputStream = new BufferedReader(new FileReader("BSCSCurriculumData.txt"));

            while (inputStream.ready()) {
                String line = inputStream.readLine();
                String[] tokens = line.split("\t");
                String courseCode = tokens[0];
                String courseTitle = tokens[1];
                int units = Integer.parseInt(tokens[2]);
                int year = Integer.parseInt(tokens[3]);
                int term = Integer.parseInt(tokens[4]);

                Course course = new Course();
                course.setYear((byte) year);
                course.setTerm((byte) term);
                course.setCourseNumber(courseCode);
                course.setDescriptiveTitle(courseTitle);
                course.setUnits((byte) units);

                courses.add(course);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return courses;
    } // end of populateCourse method

    /**
     * Populates ArrayList of Student from student file.
     *
     * @return Populated Student ArrayList
     * @throws FileNotFoundException
     */
    public ArrayList<Student> populateStudents() throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        BufferedReader inputStream;

        try {
            inputStream = new BufferedReader(new FileReader("students.txt"));

            while (inputStream.ready()) {
                String line = inputStream.readLine();
                String[] tokens = line.split("\t");

                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                int year = Integer.parseInt(tokens[2]);

                Student student = new Student();
                student.setIdNumber(id);
                student.setLastName(name);
                student.setYearLevel((byte) year);

                students.add(student);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        return students;
    } // end of populateStudents method

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == showSubjectsBtn) {
            // Get the selected year and term
            int selectedYear = (int) yearComboBox.getSelectedItem();
            int selectedTerm = (int) termComboBox.getSelectedItem();

            // Loop through the courses and display the courses that match the selected year and term
            textArea.setText("");
            for (Course course : courses) {
                if (course.getYear() == selectedYear && course.getTerm() == selectedTerm) {
                    textArea.append(course.getCourseNumber() + "\t" + course.getDescriptiveTitle() + "\n");
                }
            }
        } else if (e.getSource() == showGradesBtn) {
            // Get the selected year and term
            int selectedYear = (int) yearComboBox.getSelectedItem();
            int selectedTerm = (int) termComboBox.getSelectedItem();

            // Loop through the courses and display the courses that match the selected year and term
            textArea.setText("");
            for (Course course : courses) {
                if (course.getYear() == selectedYear && course.getTerm() == selectedTerm) {
                    textArea.append(course.getCourseNumber() + "\t" + course.getDescriptiveTitle() + "\n");

                    // Loop through the students and display the grade for each student in the selected course
                    for (Student student : students) {
                        Grade grade = student.getGrade();
                        if (grade != null) {
                            textArea.append("\t" + student.getLastName() + ": " + grade.getGrade() + "\n");
                        }
                    }
                }
            }
        } else if (e.getSource() == enterGradesBtn) {
            // Get the selected year and term
            int selectedYear = (int) yearComboBox.getSelectedItem();
            int selectedTerm = (int) termComboBox.getSelectedItem();

            // Loop through the courses and display the courses that match the selected year and term
            textArea.setText("");
            for (Course course : courses) {
                if (course.getYear() == selectedYear && course.getTerm() == selectedTerm) {
                    textArea.append(course.getCourseNumber() + "\t" + course.getDescriptiveTitle() + "\n");

                    // Loop through the students and prompt the user to enter a grade for each student in the selected course
                    for (Student student : students) {
                        if (student.getYearLevel() == selectedYear) {
                            String gradeString = JOptionPane.showInputDialog("Enter grade for " + student.getLastName() + ":");
                            if (gradeString != null && !gradeString.isEmpty()) {
                                try {
                                    double gradeValue = Double.parseDouble(gradeString);
                                    Grade grade = new Grade();
                                    student.addGrade(grade);
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Invalid grade value entered.");
                                }
                            }
                        }
                    }
                }
            }
        } else if (e.getSource() == editCourseBtn) {
            String courseCode = JOptionPane.showInputDialog("Enter course code to edit:");
            if (courseCode != null && !courseCode.isEmpty()) {
                Course course = null;
                for (Course c : courses) {
                    if (c.getCourseNumber().equals(courseCode)) {
                        course = c;
                        break;
                    }
                }
                if (course != null) {
                    String newTitle = JOptionPane.showInputDialog("Enter new title for " + courseCode + ":");
                    if (newTitle != null && !newTitle.isEmpty()) {
                        course.setDescriptiveTitle(newTitle);
                        JOptionPane.showMessageDialog(null, "Course title updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No course title entered. Course title not updated.");
                    }
                }
            }
        } else if (e.getSource() == quitBtn) {
            System.exit(0);
        }
    }
}
