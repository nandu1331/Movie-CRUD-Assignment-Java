package services;
import Models.Movie;
import java.util.List;

public class ActorService {
    private List<Movie> movies;

    public ActorService(List<Movie> movies) {
        this.movies = movies;
    }
}
