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

    public MovieService(List<Movie> movies, Map<String, Actor> actors,
                        Map<String, Director> director) {
        this.movies = movies;
        this.actors = actors;
        this.director = director;
    }

    // 1. Get Movie Information (by ID or Title)
    public void getMovieInfo(String movieIdOrTitle) {
        Optional<Movie> movie = movies.stream()
                .filter(m -> m.getId().equalsIgnoreCase(movieIdOrTitle)
                        || m.getMovieTitle().equalsIgnoreCase(movieIdOrTitle))
                .findFirst();

        if (movie.isPresent()) {
            System.out.println(movie.get());
        } else {
            System.out.println("Movie not found");
        }
    }

    // 2. Get Top 10 Rated Movies
    public List<Movie> getTop10RatedMovies() {
        return movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    // 3. Get Movies by Genre
    public List<Movie> getMoviesByGenre(String genre) {
        return movies.stream()
                .filter(m -> m.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    // 4. Get Movies by Director
    public List<Movie> getMoviesByDirector(String directorName) {
        return movies.stream()
                .filter(m -> m.getDirector() != null &&
                        m.getDirector().getName().equalsIgnoreCase(directorName))
                .collect(Collectors.toList());
    }

    // 5. Get Movies by Release Year
    public List<Movie> getMoviesByReleaseYear(int year) {
        return movies.stream()
                .filter(m -> m.getReleaseYear() == year)
                .collect(Collectors.toList());
    }

    // 6. Add a New Movie
    public void addMovie(Movie movie) {
        movies.add(movie);
        System.out.println("Movie added successfully.");
    }

    // 8. Update Movie Rating
    public void updateMovieRating(String movieId, float newRating) {
        Optional<Movie> movie = movies.stream()
                .filter(m -> m.getId().equalsIgnoreCase(movieId))
                .findFirst();
        if (movie.isPresent()) {
            movie.get().setRating(newRating);
            System.out.println("Rating updated successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }

    // 9. Delete a Movie
    public void deleteMovie(String movieId) {
        boolean removed = movies.removeIf(m -> m.getId().equalsIgnoreCase(movieId));
        if (removed) {
            System.out.println("Movie removed successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }

    // 10. Sort and Return 15 Movies by Release Year
    public List<Movie> sortMoviesByReleaseYear() {
        return movies.stream()
                .sorted(Comparator.comparingInt(Movie::getReleaseYear))
                .limit(15)
                .collect(Collectors.toList());
    }
}
