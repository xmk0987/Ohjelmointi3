import java.io.*;
import java.util.*;
import java.lang.String;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;

public class Date {
    private int day = 0;
    private int month = 0;
    private int year = 0;

    Date(int year, int month, int day) throws DateException {
        this.day = day;
        this.month = month;
        this.year = year;

        String datestring = String.format("%02d.%02d.%d", day, month ,year);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");

        if (year % 4 == 0){
            if (year % 100 == 0){
                if (year % 400 == 0){
                    if (month == 2){
                        if(day > 29){
                            throw new DateException(String.format("Illegal date %02d.%02d.%d", day, month ,year));
                        }
                    }
                }
            }
        }

        if (month == 1 || month == 3 || month == 5 || month == 7 || month ==8 || month ==10 || month == 12){
            if (day > 31){
                throw new DateException(String.format("Illegal date %02d.%02d.%d", day, month ,year));
            }
        }

        else if (month == 4 || month == 6 || month == 9 || month == 11){
            if (day > 30){
                throw new DateException(String.format("Illegal date %02d.%02d.%d", day, month ,year));
            }
        }

        else{
            if(year % 4 == 0){
                if (day > 29){
                    throw new DateException(String.format("Illegal date %02d.%02d.%d", day, month ,year));
                }
                else if (day > 28) {
                    throw new DateException(String.format("Illegal date %02d.%02d.%d", day, month ,year));
                }
            }
        }
        try {
            formatter.parse(datestring);
        }
        catch(Exception e){
            throw new DateException(String.format("Illegal date %02d.%02d.%d", day, month ,year));
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
