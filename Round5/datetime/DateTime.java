import java.io.*;
import java.util.*;
import java.lang.String;

public class DateTime extends Date{
    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    DateTime(int year, int month, int day, int hour, int minute, int second)throws DateException{
        super (year, month, day);
        this.hour = hour;
        this.minute = minute;
        this.second = second;


        if (0 > hour || hour>23 || 0 > minute || 59 < minute ||0 > second || 59 < second){
            throw new DateException(String.format("Illegal time %02d:%02d:%02d", hour, minute, second ));
        }


    }

    int getHour(){
        return this.hour;
    }

    int getMinute(){
        return this.minute;
    }

    int getSecond(){
        return this.second;
    }

    public String toString(){
        return super.toString() + String.format(" %02d:%02d:%02d", hour, minute, second);
    }



}
