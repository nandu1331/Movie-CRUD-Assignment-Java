package services;

import Models.Actor;
import Models.Director;
import Models.Movie;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MovieService {
    private List<Movie> movies;;
    private Map<String, Actor> actors;
    private Map<String, Director> director;

    public MovieService(List<Movie> movies, Map<String, Actor> actors, Map<String, Director> director) {
        this.movies = movies;
        this.actors = actors;
        this.director = director;
    }

    // 1. Get Movie Information (by ID or Title)
    public void getMovieInfo(String movieIdOrTitle) {
        Optional<Movie> movie = movies.stream()
                .filter(m -> m.getId().equalsIgnoreCase(movieIdOrTitle) || m.getMovieTitle().equalsIgnoreCase(movieIdOrTitle))
                .findFirst();

        if (movie.isPresent()) {
            System.out.println(movie.get());
        } else {
            System.out.println("Movie not found");
        }
    }
}
