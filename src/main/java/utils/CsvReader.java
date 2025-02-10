package utils;
import Models.Movie;
import Models.Actor;
import Models.Director;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class CsvReader {
    // Reads movies from a CSV file
    public static List<Movie> loadMovies(String fileName) throws FileNotFoundException, FileNotFoundException {
        List<Movie> movies = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(",");

                String id = tokens[0];
                String movieTitle = tokens[1];
                int releaseYear = Integer.parseInt(tokens[2]);
                String genre = tokens[3];
                float rating = Float.parseFloat(tokens[4]);
                int duration = Integer.parseInt(tokens[5]);

                Movie movie = new Movie(id, movieTitle, releaseYear, genre, rating, duration);
                System.out.println(movie);
                movies.add(movie);
            }
        } catch (IOException e) {
            System.out.println("Error loading movie titles: " + e.getMessage());
        }
        System.out.println(movies);
        return movies;
    }

    // Reads actors from a CSV file (format: id,name,birthDate with date as yyyy-MM-dd)
    public static Map<String, Actor> loadActors(String filePath) {
        Map<String, Actor> actors = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if(tokens.length < 3) continue;
                String id = tokens[0];
                String name = tokens[1];
                LocalDate dateOfBirth = LocalDate.parse(tokens[2], formatter);
                String nationality = tokens[3];
                Actor actor = new Actor(id, name, dateOfBirth, nationality);
                actors.put(id, actor);
            }
        } catch (IOException e) {
            System.err.println("Error reading actors file: " + e.getMessage());
        }
        return actors;
    }

    // Reads directors from a CSV file (format: id,name)
    public static Map<String, Director> loadDirectors(String filePath) {
        Map<String, Director> directors = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if(tokens.length < 2) continue;
                String id = tokens[0];
                String name = tokens[1];
                LocalDate dateOfBirth = LocalDate.parse(tokens[2], formatter);
                String nationality = tokens[3];
                Director director = new Director(id, name, dateOfBirth, nationality);
                directors.put(id, director);
            }
        } catch (IOException e) {
            System.err.println("Error reading directors file: " + e.getMessage());
        }
        return directors;
    }

    // assigns director and actors to movies using extra CSV details
    public static void assignDetailsToMovies(List<Movie> movies, Map<String, Director> directors, Map<String, Actor> actors, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length < 7) continue;
                String movieId = tokens[0];
                String directorId = tokens[5];
                String actorIdsStr = tokens[6];
                for (Movie movie : movies) {
                    if (movie.getId().equals(movieId)) {
                        // Sets director (if available)
                        if (directors.containsKey(directorId)) {
                            movie.setDirector(directors.get(directorId));
                        }
                        // Sets actors (if available)
                        List<Actor> actorList = new ArrayList<>();
                        String[] actorIds = actorIdsStr.split(";");
                        for (String actorId : actorIds) {
                            actorId = actorId.trim();
                            if (actors.containsKey(actorId)) {
                                actorList.add(actors.get(actorId));
                            }
                        }
                        movie.setActors(actorList);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error assigning movie details: " + e.getMessage());
        }
    }
}
