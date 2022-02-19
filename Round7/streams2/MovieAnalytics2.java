import java.io.*;
import java.lang.*;
import java.util.*;
import java.lang.String;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Consumer;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Comparator;

public class MovieAnalytics2 {
    private final ArrayList<Movie> movies = new ArrayList<>();

    public MovieAnalytics2(){}

    void populateWithData(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        movies.addAll(br.lines().map(x -> {var line = x.split(";"); return new Movie(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]),
                line[3], Double.parseDouble(line[4]), line[5]);}).toList());

        br.close();

    }

    void printCountByDirector(int n){

        ArrayList<String> all_directors = new ArrayList<>();

        movies.forEach(x -> {all_directors.add(x.getDirector());});

        LinkedHashMap<String, Long> director_movies = (LinkedHashMap<String, Long>) all_directors.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        LinkedHashMap<String, Long> reverseSortedMap = new LinkedHashMap<String, Long>();

        director_movies.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        reverseSortedMap.entrySet().stream().limit(n).forEach(x-> System.out.format("%s: %d movies%n", x.getKey(), x.getValue()));

    }

    void printAverageDurationByGenre(){
        movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.averagingDouble(Movie::getDuration)))
                .forEach((key, value) -> System.out.format("%s: %.2f%n", key, value));

    }

    void printAverageScoreByGenre(){
        movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.averagingDouble(Movie::getScore)))
                .forEach((key, value) -> System.out.format("%s: %.2f%n", key, value));

    }





}
