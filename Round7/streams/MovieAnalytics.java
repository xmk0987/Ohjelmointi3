import java.io.*;
import java.lang.*;
import java.util.*;
import java.lang.String;
import java.util.stream.Stream;
import java.util.function.Consumer;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.util.Comparator;

public class MovieAnalytics {
    private final ArrayList<Movie> movies;

    public MovieAnalytics(){
        this.movies = new ArrayList<>();
    }

    public static Consumer<Movie> showInfo(){
        return  x -> System.out.format("%s (%s, %d)%n", x.getTitle(), x.getDirector(), x.getReleaseYear() );
    }

    void populateWithData(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));

        String strLine;

        while ((strLine = br.readLine()) != null) {
            List<String> info = Arrays.asList(strLine.split(";"));
            String title = info.get(0);
            int releaseYear= parseInt(info.get(1));
            int duration = parseInt(info.get(2));
            String genre = info.get(3);
            double score = parseDouble(info.get(4));
            String director = info.get(5);
            var movie = new Movie(title,releaseYear,duration,genre,score,director);
            movies.add(movie);

        }
        br.close();
    }

    public Stream<Movie> moviesAfter(int year){
        return movies.stream().filter(s -> s.getReleaseYear() >= year).sorted(Comparator.comparing(Movie::getReleaseYear).thenComparing(Movie::getTitle));
    }

    public Stream<Movie> moviesBefore(int year){
        return movies.stream().filter(s -> s.getReleaseYear() <= year).sorted(Comparator.comparing(Movie::getReleaseYear).thenComparing(Movie::getTitle));
    }

    public Stream<Movie> moviesBetween(int yearA, int yearB){
        return movies.stream().filter(s -> s.getReleaseYear() <= yearB).filter(s -> s.getReleaseYear() >= yearA).sorted(Comparator.comparing(Movie::getReleaseYear).thenComparing(Movie::getTitle));
    }

    public Stream<Movie> moviesByDirector(String director){
        return movies.stream().filter(s -> s.getDirector().equals(director)).sorted(Comparator.comparing(Movie::getReleaseYear).thenComparing(Movie::getTitle));
    }

}
