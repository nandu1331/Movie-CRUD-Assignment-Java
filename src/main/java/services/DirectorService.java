package services;

import Models.Director;
import Models.Movie;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DirectorService {
    private List<Movie> movies;

    public DirectorService(List<Movie> movies) {
        this.movies = movies;
    }

    // Get Directors with the Most Movies (Top 5)
    public void getDirectorsWithMostMovies() {
        Map<Director, Long> directorCount = movies.stream()
                .filter(m -> m.getDirector() != null)
                .collect(Collectors.groupingBy(Movie::getDirector, Collectors.counting()));

        directorCount.entrySet().stream()
                .sorted(Map.Entry.<Director, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> System.out.println(entry.getKey().getName() + " - " + entry.getValue() + " movies"));
    }
}
