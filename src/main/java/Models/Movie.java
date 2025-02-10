package Models;
import java.util.List;

// Movie Class
public class Movie {
    private String id;
    private String movieTitle;
    private int releaseYear;
    private String genre;
    private float rating;
    private int duration;
    private List<Actor> actors;
    private Director director;

    // Constructor
    public Movie (String id, String movieTitle, int releaseYear, String genre, float rating, int duration) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
    }

    // Getter and Setter methods
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        StringBuilder actorNames = new StringBuilder();

        if (actors != null) {
            for (Actor actor: actors) {
                actorNames.append(actor.getName()).append(", ");
            }
            if (!actorNames.isEmpty()) {
                // remove trailing double quotes in the dataset
                actorNames.setLength(actorNames.length() - 2);
            }
        }

        return "Movie [id=" + id + ", title=" + movieTitle + ", genre=" + genre + ", Rating=" + rating
                + ", Duration=" + duration + ", Release Year=" + releaseYear + ", Director=" +
                (director != null ? director.getName() : "NA" + ", Actors=" + actorNames + "]");
    }
}
