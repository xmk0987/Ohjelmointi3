
import java.io.*;
import java.util.*;
import java.lang.String;

public class Student {

    private String name = "";
    private String studentNumber = "";

    Student(String name, String studentNumber){
        this.name = name;
        this.studentNumber = studentNumber;
    }

    String getName(){
        return this.name;
    }

    String getStudentNumber(){
        return this.studentNumber;
    }



}
