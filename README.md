```markdown
# Movie Data Management System

A Java-based application for managing movie data using CSV files as the data source. This system provides a menu-driven interface to query, add, update, and delete movie records, along with specialized queries related to actors and directors. It is designed using a modular approach, ensuring separation of concerns between models, services, and utilities.

---

## Table of Contents

- [Overview](#overview)
- [Project Structure](#project-structure)
- [Data Ingestion](#data-ingestion)
- [Models](#models)
- [Services](#services)
- [CSV Format Details](#csv-format-details)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Performance Metrics](#performance-metrics)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

The Movie Data Management System provides the following functionality:
- **CRUD Operations:** Create, read, update, and delete movies.
- **Advanced Queries:** Retrieve top-rated movies, filter by genre, director, release year, and release year range.
- **Actor & Director Queries:** Identify directors with the most movies, actors working in multiple movies, and movies of the youngest actor (as of a specified date).
- **Data Loading:** All data is loaded from CSV files placed in the `resources/` folder.
- **Performance Reporting:** Each operation prints the execution time (in milliseconds) to help you track performance.

---

## Project Structure

The project is organized into a clean package structure, ensuring a clear separation of concerns:

```
Movie-CRUD-Assignment-Java/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── org/example/              # Main application entry point
│   │   │   │   └── Main.java
│   │   │   ├── Models/                   # Domain models
│   │   │   │   ├── Movie.java
│   │   │   │   ├── Actor.java
│   │   │   │   └── Director.java
│   │   │   ├── services/                 # Service classes (business logic)
│   │   │   │   ├── MovieService.java
│   │   │   │   ├── ActorService.java
│   │   │   │   └── DirectorService.java
│   │   │   └── utils/                    # Utility classes for CSV reading/parsing
│   │   │       └── CsvReader.java
├── resources/                          # CSV data files
│   ├── movies.csv
│   ├── actors.csv
│   └── directors.csv
├── README.md
└── LICENSE
```

---

## Data Ingestion

### CSV Data Loading
Data is loaded from CSV files stored in the `resources/` folder. The application uses a custom CSV parser (found in `CsvReader.java`) that handles special cases such as quoted fields. The parser reads each file line-by-line and creates in-memory representations of movies, actors, and directors.

#### How It Works:
1. **Movies:**  
   The `CsvReader.loadMovies(String filePath)` method reads each movie record and creates a `Movie` object. Initially, these objects may contain only basic information (ID, title, release year, genre, rating, duration).

2. **Actors and Directors:**  
   The methods `CsvReader.loadActors(String filePath)` and `CsvReader.loadDirectors(String filePath)` load actors and directors into `Map` objects for quick lookups based on their IDs.

3. **Assigning Details:**  
   The `CsvReader.assignDetailsToMovies(...)` method is then used to associate each movie with its respective director and actors. This method uses a regex-based split (or a CSV library if preferred) to correctly handle fields with extra quotes (e.g., actor IDs listed as `"461,1696,964"`). It removes any unwanted quotes and splits the actor IDs correctly, then updates the corresponding `Movie` object with a list of `Actor` objects and sets the `Director`.

---

## Models

### Movie.java
Represents a movie with the following fields:
- **id:** Unique movie identifier.
- **title:** Movie title.
- **releaseYear:** Year of release.
- **genre:** Genre of the movie.
- **rating:** Average rating.
- **duration:** Duration (in minutes).
- **director:** A reference to a `Director` object.
- **actors:** A list of associated `Actor` objects.

The `toString()` method is overridden to print all these details in a readable format, including actor names if available.

### Actor.java
Represents an actor with:
- **id:** Unique actor identifier.
- **name:** Actor’s name.
- **birthDate:** Date of birth.
- **getAgeAtDate(LocalDate date):** A method to calculate the actor’s age as of a given date.

### Director.java
Represents a director with:
- **id:** Unique director identifier.
- **name:** Director’s name.

---

## Services

The application logic is split into three service classes for modularity:

### MovieService.java
Handles operations related to movies:
- **getMovieInfo(String movieIdOrTitle):** Displays detailed information about a movie.
- **getTop10RatedMovies():** Returns the top 10 rated movies.
- **getMoviesByGenre(String genre):** Filters movies by genre.
- **getMoviesByDirector(String directorName):** Retrieves movies by director name.
- **getMoviesByReleaseYear(int year):** Filters movies by a specific release year.
- **getMoviesByReleaseYearRange(int startYear, int endYear):** Filters movies within a year range.
- **addMovie(Movie movie):** Adds a new movie.
- **updateMovieRating(String movieId, float newRating):** Updates the rating of a movie.
- **deleteMovie(String movieId):** Deletes a movie.
- **sortMoviesByReleaseYear():** Returns a sorted list of movies based on the release year.

### ActorService.java
Handles actor-specific queries:
- **getActorsWithMultipleMovies():** Lists actors who have appeared in multiple movies.
- **getMoviesOfYoungestActor(LocalDate referenceDate):** Finds and displays movies featuring the youngest actor as of the given date.

### DirectorService.java
Handles director-specific queries:
- **getDirectorsWithMostMovies():** Displays the top directors based on the number of movies they directed.

---

## CSV Format Details

### movies.csv
```csv
movieId,title,releaseYear,genre,rating,duration,directorId,actorIds
1,Movie 1,2001,Crime,5.4,81,231,"461,1696,964"
2,Movie 2,1975,Horror,9.4,99,238,"1246,1921,1799,225,282"
3,Movie 3,1992,Fantasy,5.8,104,222,"865,1049,1301,1256,1919"
4,Movie 4,1956,Drama,8.4,104,995,"1261,316"
```
**Note:**  
- The `actorIds` field is enclosed in double quotes and contains multiple IDs separated by commas.
- The CSV parser in `CsvReader.java` uses a regex split to correctly parse this field and remove unwanted quotes.

### actors.csv
Contains actor details (fields such as `id,name,birthDate`). The birth date should follow the `yyyy-MM-dd` format.

### directors.csv
Contains director details (fields such as `id,name`).

---

## Setup and Installation

### Prerequisites
- **Java 8 or higher**
- **Git** (to clone the repository)
- Optionally, an IDE such as IntelliJ IDEA or Eclipse

### Steps

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/Movie-CRUD-Assignment-Java.git
   cd Movie-CRUD-Assignment-Java
   ```

2. **Import into IDE:**
   - Open your preferred Java IDE.
   - Import the project as a Maven/Gradle project (if build files are provided) or as a Java project.
   - Ensure the source folder `src/main/java` is set up correctly.

3. **Build the Project:**
   If you are using the command line:
   ```bash
   javac -d out src/main/java/org/example/Main.java
   ```

4. **Run the Application:**
   ```bash
   java -cp out org.example.Main
   ```
   Alternatively, run the `Main` class from your IDE.

---

## Usage

Upon running the application, you will see a menu with options like:
- Get movie information by ID or title.
- Retrieve the top 10 rated movies.
- Filter movies by genre, director, or release year.
- Add, update, or delete movies.
- Execute specialized queries for actors and directors.

After selecting an option, follow the prompts. Each operation prints its execution time in milliseconds, allowing you to monitor performance.

---

## Performance Metrics

Each operation in the application is timed using `System.currentTimeMillis()`. When an operation completes, the elapsed time is printed to the console in the following format:
```
Operation completed in XXXX ms.
```
This helps in evaluating the performance, especially when handling large datasets.

---

## Dependencies

- **Java Standard Library:**  
  No external libraries are required for basic CSV parsing since a regex-based approach is used.  
- **Optional:**  
  You may integrate a robust CSV parsing library (e.g., OpenCSV or Apache Commons CSV) if the CSV data grows in complexity.

---

## Contributing

Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Commit your changes with descriptive messages.
4. Push your branch and open a pull request.

Ensure your changes adhere to the existing code style and include appropriate tests.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact

For questions or suggestions, please open an issue or contact the repository maintainer at [your.email@example.com](mailto:your.email@example.com).

```
