import java.lang.String;


public class Movie {
    private String title;
    private int releaseYear;
    private int duration;
    private String genre;
    private double score;
    private String director;


    public Movie(String title, int releaseYear, int duration, String genre, double score, String director){
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.genre = genre;
        this.score = score;
        this.director = director;

    }

    public String getTitle(){ return this.title;}

    public int getReleaseYear(){return this.releaseYear;}

    public int getDuration(){return this.duration;}

    public String getGenre(){return this.genre;}

    public double getScore(){return this.score;}

    public String getDirector(){return this.director;}

}
