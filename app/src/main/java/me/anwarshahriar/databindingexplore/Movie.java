package me.anwarshahriar.databindingexplore;

public class Movie {
    private String title;
    private int releaseYear;
    private String director;
    private String moviePoster;

    public Movie(String title, int releaseYear, String director, String moviePoster) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.director = director;
        this.moviePoster = moviePoster;
    }

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public String getMoviePoster() {
        return moviePoster;
    }
}
