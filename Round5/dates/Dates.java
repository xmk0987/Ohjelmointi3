import java.io.*;
import java.util.*;
import java.lang.String;
import java.time.*;
import java.time.temporal.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;



public class Dates {

    public static class DateDiff{
        private String start = "";
        private String end = "";
        private int diff = 0;

        private DateDiff(){

        }

        public String getStart(){
            return this.start;
        }

        public String getEnd(){
            return this.end;
        }

        public int getDiff(){
            return this.diff;
        }

        public String toString(){
            return String.format("%s --> %s: %d days", start, end, diff);
        }

    }

    public static DateDiff[] dateDiffs(String ...dateStrs) {

    }


}
