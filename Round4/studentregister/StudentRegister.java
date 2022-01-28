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
        students.sort(Comparator.comparing(Student::getName));
        return students;


    }

    public ArrayList<Course> getCourses(){
        courses.sort(Comparator.comparing(Course::getName));
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
        if(order.equals("by name")){
            courses.sort(Comparator.comparing(Course::getName));
            for (Student s : students){
                if (s.getStudentNumber().equals(studentNumber)){
                    System.out.format("%s (%s):%n", s.getName(), s.getStudentNumber());
                    for (Course c: courses){
                        for(Attainment att : attainments){
                            if(att.getStudentNumber().equals(studentNumber)){

                                if (att.getCourseCode().equals(c.getCode())){
                                    System.out.format("  %s %s: %d%n", c.getCode(), c.getName(), att.getGrade());
                                }

                            }
                        }
                    }
                }
            }
        }
        if(order.equals("by code")){
            courses.sort(Comparator.comparing(Course::getCode));
            for (Student s : students){
                if (s.getStudentNumber().equals(studentNumber)){
                    System.out.format("%s (%s):%n", s.getName(), s.getStudentNumber());
                    for (Course c: courses){
                        for(Attainment att : attainments){
                            if(att.getStudentNumber().equals(studentNumber)){

                                if (att.getCourseCode().equals(c.getCode())){
                                    System.out.format("  %s %s: %d%n", c.getCode(), c.getName(), att.getGrade());
                                }

                            }
                        }
                    }
                }
            }
        }


    }



    public void printStudentAttainments(String studentNumber){
        List<String> name_check = new ArrayList<>();
        for(Student s : students){
            if (s.getStudentNumber().equals(studentNumber)){
                name_check.add(studentNumber);
            }
        }
        if (name_check.size() < 1){
            System.out.format("Unknown student number: %s%n",studentNumber);
        }
        for (Student s : students){
            if (s.getStudentNumber().equals(studentNumber)){
                System.out.format("%s (%s):%n", s.getName(), s.getStudentNumber());

                    for(Attainment att : attainments){
                        if(att.getStudentNumber().equals(studentNumber)){
                            for (Course c: courses){
                                if (att.getCourseCode().equals(c.getCode())){
                                    System.out.format("  %s %s: %d%n", c.getCode(), c.getName(), att.getGrade());
                                }
                            }



                        }
                    }

            }
        }






    }













}
