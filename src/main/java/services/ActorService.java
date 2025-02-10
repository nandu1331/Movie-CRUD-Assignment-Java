package services;
import Models.Actor;
import Models.Movie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                .forEach(entry -> System.out.println(entry.getKey().getName() + " - " + entry.getValue() + " movies"));
    }
}
