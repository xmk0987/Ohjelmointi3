import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentRegister {
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();
    ArrayList<Attainment> attainments = new ArrayList<>();

    StudentRegister() {

    }

    public ArrayList<Student> getStudents() {
        students.sort(Comparator.comparing(Student::getName));
        return this.students;
    }

    public ArrayList<Course> getCourses() {
        courses.sort(Comparator.comparing(Course::getName));
        return this.courses;
    }

    public void addStudent(Student student) {
        if(!students.contains(student)) {
            students.add(student);
        }
    }

    public void addCourse(Course course) {
        if(!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void addAttainment(Attainment att) {
        if(!attainments.contains(att)) {
            attainments.add(att);
        }
    }

    public void printStudentAttainments(String studentNumber, String order) {
        if(order.equals("by name")) {
            courses.sort(Comparator.comparing(Course::getName));
        }
        if(order.equals("by name")) {
            courses.sort(Comparator.comparing(Course::getCode));
        }
        printStudentAttainments(studentNumber);
    }

    public void printStudentAttainments(String studentNumber) {
        List<String> isStudent = new ArrayList<>();

        for(Attainment att : attainments) {
            if (att.getStudentNumber().equals(studentNumber)) {
                isStudent.add(studentNumber);
            }
        }
        if(isStudent.size() < 1) {
            System.out.printf("Unknown student number: %s\n", studentNumber);
        } else {
            for(Student s : students) {
                if(s.getStudentNumber().equals(studentNumber)) {
                    System.out.printf("%s (%s):\n", s.getName(), studentNumber);
                    for(Course c : courses) {
                        for(Attainment att : attainments) {
                            if(att.getStudentNumber().equals(studentNumber)) {
                                if(att.getCourseCode().equals(c.getCode())) {
                                    System.out.printf("  %s %s: %d\n", c.getCode(), c.getName(), att.getGrade());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
