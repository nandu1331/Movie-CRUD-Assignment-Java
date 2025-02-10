package services;

import Models.Movie;
import java.util.List;

public class DirectorService {
    private List<Movie> movies;

    public DirectorService(List<Movie> movies) {
        this.movies = movies;
    }
}
