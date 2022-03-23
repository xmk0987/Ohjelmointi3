package fi.tuni.prog3.junitattainment;
import java.io.*;
import java.util.*;
import java.lang.String;


public class Attainment implements Comparable<Attainment>{
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

    public Attainment(String courseCode, String studentNumber, int grade)throws IllegalArgumentException{
        if(courseCode == null|| studentNumber == null || 5 < grade || grade < 0){
            throw new IllegalArgumentException();
        }

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
        return String.format("%s %s %d", this.courseCode, this.studentNumber, this.grade);
    }




}
