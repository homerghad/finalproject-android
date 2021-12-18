package csci81.demo.finalproject.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Movie extends RealmObject {

    @PrimaryKey
    private String movieID;

    private String title;
    private String director;
    private String genre;
    private String releaseDate;
    private double rentalCost;
    private int rentalDuration;

    public Movie() {
    }

    public Movie(String movieID, String title, String director, String genre, String releaseDate, double rentalCost, int rentalDuration) {
        this.movieID = movieID;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.rentalCost = rentalCost;
        this.rentalDuration = rentalDuration;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieID='" + movieID + '\'' +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", rentalCost=" + rentalCost +
                ", rentalDuration=" + rentalDuration +
                '}';
    }
}
