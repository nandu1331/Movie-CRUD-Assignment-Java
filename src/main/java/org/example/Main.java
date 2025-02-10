package org.example;

import Models.Movie;
import Models.Actor;
import Models.Director;
import services.MovieService;
import services.ActorService;
import services.DirectorService;
import utils.CsvReader;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // File paths
        String moviesFilePath = "D:\\Movie-CRUD-Assignment-Java\\src\\main\\resources\\movies_large.csv";
        String actorsFilePath = "D:\\Movie-CRUD-Assignment-Java\\src\\main\\resources\\actors_large.csv";
        String directorsFilePath = "D:\\Movie-CRUD-Assignment-Java\\src\\main\\resources\\directors_large.csv";

        // Load CSV data
        List<Movie> movies = CsvReader.loadMovies(moviesFilePath);
        Map<String, Actor> actors = CsvReader.loadActors(actorsFilePath);
        Map<String, Director> directors = CsvReader.loadDirectors(directorsFilePath);

        // Associate directors and actors with movies using extra CSV details (if applicable)
        CsvReader.assignDetailsToMovies(movies, directors, actors, moviesFilePath);

        // Initialize the services
        MovieService movieService = new MovieService(movies);
        ActorService actorService = new ActorService(movies);
        DirectorService directorService = new DirectorService(movies);

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            // Display Menu Options
            System.out.println("\n--- Movie Data Management System ---");
            System.out.println("1. Get Movie Information");
            System.out.println("2. Get Top 10 Rated Movies");
            System.out.println("3. Get Movies by Genre");
            System.out.println("4. Get Movies by Director");
            System.out.println("5. Get Movies by Release Year");
            System.out.println("6. Get Movies by Release Year Range");
            System.out.println("7. Add a New Movie");
            System.out.println("8. Update Movie Rating");
            System.out.println("9. Delete a Movie");
            System.out.println("10. Sort and Return 15 Movies by Release Year");
            System.out.println("11. Get Directors with the Most Movies");
            System.out.println("12. Get Actor Who Has Worked in Multiple Movies");
            System.out.println("13. Get Movies of the Youngest Actor (as of 2025-02-10)");
            System.out.println("14. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            long startTime = System.currentTimeMillis();

            switch (choice) {
                case 1:
                    System.out.print("Enter Movie ID or Title: ");
                    String idOrTitle = scanner.nextLine();
                    movieService.getMovieInfo(idOrTitle);
                    break;
                case 2:
                    movieService.getTop10RatedMovies().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    movieService.getMoviesByGenre(genre).forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Enter Director Name: ");
                    String directorName = scanner.nextLine();
                    movieService.getMoviesByDirector(directorName).forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Enter Release Year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    movieService.getMoviesByReleaseYear(year).forEach(System.out::println);
                    break;
                case 6:
                    System.out.print("Enter Release Year Range (startYear-endYear): ");
                    String[] range = scanner.nextLine().split("-");
                    int startYear = Integer.parseInt(range[0].trim());
                    int endYear = Integer.parseInt(range[1].trim());
                    movieService.getMoviesByReleaseYearRange(startYear, endYear).forEach(System.out::println);
                    break;
                case 7:
                    System.out.print("Enter movie details (id,title,releaseYear,genre,rating,duration): ");
                    String[] details = scanner.nextLine().split(",");
                    if (details.length < 5) {
                        System.out.println("Insufficient details provided.");
                    } else {
                        Movie newMovie = new Movie(
                                details[0].trim(),
                                details[1].trim(),
                                Integer.parseInt(details[2].trim()),
                                details[3],
                                Float.parseFloat(details[4].trim()),
                                Integer.parseInt(details[5].trim())
                        );
                        movieService.addMovie(newMovie);
                    }
                    break;
                case 8:
                    System.out.print("Enter Movie ID: ");
                    String movieIdToUpdate = scanner.nextLine();
                    System.out.print("Enter New Rating: ");
                    float newRating = Float.parseFloat(scanner.nextLine());
                    movieService.updateMovieRating(movieIdToUpdate, newRating);
                    break;
                case 9:
                    System.out.print("Enter Movie ID: ");
                    String movieIdToDelete = scanner.nextLine();
                    movieService.deleteMovie(movieIdToDelete);
                    break;
                case 10:
                    movieService.sortMoviesByReleaseYear().forEach(System.out::println);
                    break;
                case 11:
                    directorService.getDirectorsWithMostMovies();
                    break;
                case 12:
                    actorService.getActorsWithMultipleMovies();
                    break;
                case 13:
                    // Using reference date 2025-02-10
                    LocalDate refDate = LocalDate.of(2025, 2, 10);
                    actorService.getMoviesOfYoungestActor(refDate);
                    break;
                case 14:
                    System.out.println("Exiting application...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Operation completed in " + (endTime - startTime) + " ms.");
        }
    }
}
