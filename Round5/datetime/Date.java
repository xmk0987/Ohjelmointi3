import java.io.*;
import java.util.*;
import java.lang.String;

public class Date {
    private int day = 0;
    private int month = 0;
    private int year = 0;

    Date(int year, int month, int day) throws DateException {
        this.day = day;
        this.month = month;
        this.year = year;


        if (month > 12 || month < 1 || day > 31 || day < 1 ){
            throw new DateException(String.format("Illegal date %02d.%02d.%d",day,month,year  ));
        }
    }

    public int getYear(){
        return this.year;
    }

    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public String toString(){
        return String.format("%02d.%02d.%d", day, month, year);
    }
}
