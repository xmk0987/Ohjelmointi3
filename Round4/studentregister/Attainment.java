import java.io.*;
import java.util.*;
import java.lang.String;


public class Attainment {
    private String courseCode = "";
    private String studentNumber = "";
    private int grade = 0;

    Attainment(String courseCode, String studentNumber, int grade){
        this.courseCode = courseCode;
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    String getCourseCode(){
        return this.courseCode;
    }

    String getStudentNumber(){
        return this.studentNumber;
    }

    int getGrade(){
        return this.grade;
    }


}
