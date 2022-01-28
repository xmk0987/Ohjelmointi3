import java.io.*;
import java.util.*;
import java.lang.String;


public class Course {
    private String course_name = "";
    private String course_code = "";
    private int credits = 0;

    Course(String code, String name, int credits){
        this.course_code = code;
        this.course_name = name;
        this.credits = credits;
    }

    String getCode(){
        return this.course_code;
    }

    String getName(){
        return this.course_name;
    }

    int getCredits(){
        return this.credits;
    }


}
