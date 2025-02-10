package services;
import Models.Actor;
import Models.Movie;

import java.time.LocalDate;
import java.util.*;

public class ActorService {
    private List<Movie> movies;

    public ActorService(List<Movie> movies) {
        this.movies = movies;
    }

    // Get Actors Who Have Worked in Multiple Movies
    public void getActorsWithMultipleMovies() {
        Map<Actor, Long> actorCount = new HashMap<>();
        for (Movie movie : movies) {
            if (movie.getActors() != null) {
                for (Actor actor : movie.getActors()) {
                    actorCount.put(actor, actorCount.getOrDefault(actor, 0L) + 1);
                }
            }
        }
        actorCount.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(
                        entry.getKey().getName() + " - " + entry.getValue() + " movies")
                );
    }

    // Get the Movies of the Youngest Actor (as of a reference date)
    public void getMoviesOfYoungestActor(LocalDate referenceDate) {
        // Gather all unique actors from the movie list
        Set<Actor> movieActors = new HashSet<>();
        for (Movie movie : movies) {
            if (movie.getActors() != null) {
                movieActors.addAll(movie.getActors());
            }
        }
        Optional<Actor> youngest = movieActors.stream()
                .min(Comparator.comparingInt(actor -> actor.getPresentAge(referenceDate)));
        if (youngest.isPresent()) {
            Actor actor = youngest.get();
            System.out.println("Youngest Actor: " + actor.getName() + ", Age: "
                    + actor.getPresentAge(referenceDate));
            System.out.println("Movies featuring " + actor.getName() + ":");
            movies.stream()
                    .filter(m -> m.getActors() != null && m.getActors().contains(actor))
                    .forEach(System.out::println);
        } else {
            System.out.println("No actors found in movies.");
        }
    }
}
