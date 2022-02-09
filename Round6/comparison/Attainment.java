import java.io.*;
import java.util.*;
import java.lang.String;

public class Attainment implements Comparable<Attainment> {
    private String studentNumber = "";
    private String courseCode = "";
    private int grade = 0;


    @Override
    public int compareTo(Attainment att){
        int cmp = getStudentNumber().compareTo(att.getStudentNumber());
        if (cmp == 0){
            cmp = getCourseCode().compareTo(att.getCourseCode());
        }
        return cmp;

    }

    public Attainment(String courseCode, String studentNumber, int grade){
        this.courseCode = courseCode;
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    public String getCourseCode(){
        return this.courseCode;
    }

    public String getStudentNumber(){
        return this.studentNumber;
    }

    public int getGrade(){
        return this.grade;
    }

    public String toString(){
        return String.format("%s %s %d%n", this.courseCode, this.studentNumber, this.grade);
    }

    public static final Comparator<Attainment> CODE_STUDENT_CMP = new Comparator<Attainment>() {
        @Override
        public int compare(Attainment o1, Attainment o2) {
            int cmp = o1.getCourseCode().compareTo(o2.getCourseCode());
            if(cmp == 0){
                cmp = o1.getStudentNumber().compareTo(o2.getStudentNumber());
            }
            return cmp;
        }
    };


    public static final Comparator<Attainment> CODE_GRADE_CMP = new Comparator<Attainment>() {
        @Override
        public int compare(Attainment o1, Attainment o2) {
            int cmp = o1.getCourseCode().compareTo(o2.getCourseCode());

            if(cmp == 0){
                cmp = Integer.compare(o2.getGrade(), o1.getGrade());
            }
            return cmp;
        }
    };






}
