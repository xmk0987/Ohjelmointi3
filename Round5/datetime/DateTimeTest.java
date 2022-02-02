import java.io.*;
import java.util.*;
import java.lang.String;



public class DateTimeTest {
    public static void main(String args[]) {
        ArrayList<Date> dates = new ArrayList<>();
        for(String arg : args) {
            try {
                String[] parts = arg.split(" ");
                if(parts.length == 3) {
                    dates.add(new Date(Integer.parseInt(parts[0]), Integer
                            .parseInt(parts[1]),
                            Integer.parseInt(parts[2])));
                }
                else if(parts.length == 6) {
                    dates.add(new DateTime(Integer.parseInt(parts[0]), Integer.parseInt(
                            parts[1]), Integer.parseInt(parts[2]), Integer
                            .parseInt(parts[3]), Integer.parseInt(parts[4]), Integer
                            .parseInt(parts[5])));
                }
            }
            catch(DateException e) {
                System.out.println(e);
            }
        }
        for(int i = 0; i < dates.size(); i++) {
            System.out.format("Date #%d: %s%n", i + 1, dates.get(i));
        }
    }
}
