import java.io.*;
import java.lang.*;
import java.util.*;
import java.lang.String;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        HashMap<String, Long> director_movies = (HashMap<String, Long>) all_directors
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        director_movies
                .entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(Map.Entry<String, Long>::getValue).reversed().thenComparing(Map.Entry::getKey))
                .limit(n)
                .forEach(x-> System.out.format("%s: %d movies%n", x.getKey(), x.getValue()));


    }

    void printAverageDurationByGenre(){
        movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.averagingDouble(Movie::getDuration)))
                .entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry<String, Double>::getValue).thenComparing(Map.Entry::getKey))
                .forEach(x -> System.out.format("%s: %.2f%n", x.getKey(), x.getValue()));

    }

    void printAverageScoreByGenre(){
        movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.averagingDouble(Movie::getScore))).entrySet().stream()
                .sorted(Comparator.comparingDouble(Map.Entry<String, Double>::getValue).reversed().thenComparing(Map.Entry::getKey))
                .forEach(x -> System.out.format("%s: %.2f%n", x.getKey(), x.getValue()));

    }





}
