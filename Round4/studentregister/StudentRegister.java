import java.io.*;
import java.util.*;
import java.lang.String;


public class StudentRegister {
    private final ArrayList<Student> students = new ArrayList<>();
    private final ArrayList<Course> courses = new ArrayList<>();
    private final ArrayList<Attainment> attainments = new ArrayList<>();



    StudentRegister(){

    }

    public ArrayList<Student> getStudents(){
        students.sort((a,b) -> a.getName().compareTo(b.getName()));
        // students.sort((Student a, Student b)-> a.getName().compareTo(b.getName());
        //Collections.sort(students, (Student a, Student b)-> a.getName().compareTo(b.getName()));
        return students;


    }

    public ArrayList<Course> getCourses(){
        courses.sort((a,b) -> a.getName().compareTo(b.getName()));
        // students.sort((Student a, Student b)-> a.getName().compareTo(b.getName());
        //Collections.sort(courses, (Course a, Course b)-> a.getName().compareTo(b.getName()));
        return courses;


    }


    public void addStudent(Student student){
        if(!students.contains(student)){
            students.add(student);
        }
    }

    public void addCourse(Course course){
        if(!courses.contains(course)){
            courses.add(course);
        }

    }

    public void addAttainment(Attainment att){
        if(!attainments.contains(att)){
            attainments.add(att);
        }
    }



    public void printStudentAttainments(String studentNumber, String order){
        if(order == "by name"){
            courses.sort((a,b) -> a.getName().compareTo(b.getName()));
            printStudentAttainments(studentNumber);
        }
        if(order == "by code"){
            courses.sort((a,b) -> a.getCode().compareTo(b.getCode()));
            printStudentAttainments(studentNumber);
        }
        
    }

    public void printStudentAttainments(String studentNumber){
        List<String> name_check = new ArrayList<>();
        for(Student s : students){
            if (s.getStudentNumber() == studentNumber){
                name_check.add(studentNumber);
            }
        }
        if (name_check.size() < 1){
            System.out.format("Unknown student number: %s%n",studentNumber);
        }
        for (Student s : students){
            if (s.getStudentNumber() == studentNumber){
                System.out.format("%s (%s):%n", s.getName(), s.getStudentNumber());
                for (Attainment att : attainments){
                    if(att.getStudentNumber() == studentNumber){
                        for (Course c: courses){
                            if (att.getCourseCode() == c.getCode()){
                                System.out.format("%s %s: %d%n", c.getCode(), c.getName(), att.getGrade());
                            }
                        }
                    }
                }
            }
        }

        for (Attainment att : attainments){
            if(att.getStudentNumber() == studentNumber){
                System.out.println("Testi");
            }
        }





    }













}
