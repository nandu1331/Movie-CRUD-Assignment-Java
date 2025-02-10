# Movie Data Management System

A robust Java-based application for managing movie data using CSV files as the data source. This system implements a comprehensive menu-driven interface for querying, adding, updating, and deleting movie records, along with specialized queries for actors and directors. Built with a focus on modularity and separation of concerns.

## Table of Contents

1. [Overview](#overview)
2. [Features](#features)
3. [Project Structure](#project-structure)
4. [Technical Architecture](#technical-architecture)
5. [Data Management](#data-management)
6. [Installation](#installation)
7. [Usage Guide](#usage-guide)
8. [Development](#development)
9. [Testing](#testing)
10. [Contributing](#contributing)
11. [License](#license)

## Overview

The Movie Data Management System is designed to handle complex movie data operations while maintaining high performance and data integrity. It serves as a comprehensive solution for managing relationships between movies, actors, and directors through an intuitive interface.

## Features

- **Core CRUD Operations**
  - Create new movie entries with full metadata
  - Retrieve movie information by ID or title
  - Update existing movie records
  - Delete movies with proper reference handling

- **Advanced Queries**
  - Filter movies by multiple criteria
  - Sort by various attributes
  - Complex relationship mapping
  - Performance-optimized search operations

- **Analytics Capabilities**
  - Top-rated movies identification
  - Actor collaboration networks
  - Director filmography analysis
  - Temporal data analysis

## Project Structure

```
Movie-CRUD-Assignment-Java/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── org/example/              # Entry point
│   │   │   │   └── Main.java
│   │   │   ├── models/                   # Domain models
│   │   │   │   ├── Movie.java
│   │   │   │   ├── Actor.java
│   │   │   │   └── Director.java
│   │   │   ├── services/                 # Business logic
│   │   │   │   ├── MovieService.java
│   │   │   │   ├── ActorService.java
│   │   │   │   └── DirectorService.java
│   │   │   └── utils/                    # Utilities
│   │   │       └── CsvReader.java
│   │   └── resources/                    # Configuration files
├── test/                                 # Test suites
├── resources/                            # Data files
│   ├── movies.csv
│   ├── actors.csv
│   └── directors.csv
├── docs/                                 # Documentation
├── .gitignore
├── LICENSE
└── README.md
```

## Technical Architecture

### Models

#### Movie Class
```java
public class Movie {
    private String id;
    private String title;
    private int releaseYear;
    private String genre;
    private float rating;
    private int duration;
    private Director director;
    private List<Actor> actors;
    // Getters, setters, and utility methods
}
```

#### Actor Class
```java
public class Actor {
    private String id;
    private String name;
    private LocalDate birthDate;
    // Methods including age calculation
}
```

#### Director Class
```java
public class Director {
    private String id;
    private String name;
    // Associated methods
}
```

### Services

#### MovieService
- Handles core movie operations
- Implements caching for performance
- Manages data consistency

#### ActorService
- Processes actor-related queries
- Handles relationship mapping
- Maintains actor metadata

#### DirectorService
- Manages director information
- Handles filmography tracking
- Processes director-specific analytics

## Data Management

### CSV Format Specifications

#### movies.csv
```csv
movieId,title,releaseYear,genre,rating,duration,directorId,actorIds
1,"The Example",2021,"Drama",8.5,120,D001,"A001,A002,A003"
```

#### actors.csv
```csv
id,name,birthDate
A001,"John Smith",1980-01-15
```

#### directors.csv
```csv
id,name
D001,"Jane Director"
```

### Data Validation Rules
- All IDs must be unique
- Release years must be valid
- Ratings must be between 0 and 10
- Duration must be positive
- References must be valid

## Work Flow

### Getting Movie details
![Screenshot 2025-02-10 231237](https://github.com/user-attachments/assets/3c550dd1-93f5-4bd8-917d-6b0814dec93d)

### Getting Top Rated Movies
![Screenshot 2025-02-10 231254](https://github.com/user-attachments/assets/9721d268-3abd-4399-b8cb-0105a0616703)

### Getting Movies By Genre
![Screenshot 2025-02-10 231237](https://github.com/user-attachments/assets/05c81eb3-10e9-4ab1-bfd7-b4779b13c25d)

### Getting Movies By Year
![Screenshot 2025-02-10 231338](https://github.com/user-attachments/assets/047b861b-b4fe-425a-8c34-2950056c403e)

### Getting Movies in a year range
![Screenshot 2025-02-10 231350](https://github.com/user-attachments/assets/4333e583-b896-420c-901c-5983ac2d40a3)

### Adding new movie
![Screenshot 2025-02-10 231350](https://github.com/user-attachments/assets/b709d779-9dc5-4127-89dc-41a1c3e67279)

### Updating movie rating
![Screenshot 2025-02-10 232036](https://github.com/user-attachments/assets/29fb91f0-16b7-4e0f-a8de-e837293bac37)

### Deleting a movie
![image](https://github.com/user-attachments/assets/190c6841-c14c-4e01-a7d0-afbaa7440630)

### Directors with most number of movies
![image](https://github.com/user-attachments/assets/2d927fe3-be7c-43d5-b469-26010ec62534)

### Actors who acted in multiple movies
![image](https://github.com/user-attachments/assets/23284e2b-0d9e-46bc-98ad-a21a7ab47ff2)

### Getting Youngest actor and their movies
![image](https://github.com/user-attachments/assets/5b283a67-428c-457d-9d1e-e05fcdfbc438)

## Installation

### Prerequisites
- Java JDK 8 or higher
- Git
- Maven (optional)

### Setup Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/movie-data-management.git
   cd movie-data-management
   ```

2. Build the project:
   ```bash
   ./mvnw clean install
   ```

3. Run the application:
   ```bash
   java -jar target/movie-management-1.0.jar
   ```

## Usage Guide

### Basic Operations

1. **Adding a Movie**
   ```bash
   Select option 1
   Follow prompts to enter movie details
   ```

2. **Searching Movies**
   ```bash
   Select option 2
   Enter search criteria
   ```

3. **Updating Records**
   ```bash
   Select option 3
   Enter movie ID and new details
   ```

### Advanced Features

- **Complex Queries**
  - Filter by multiple criteria
  - Sort results
  - Export data

- **Performance Monitoring**
  - Operation timing
  - Resource usage tracking
  - Query optimization

## Development

### Coding Standards
- Follow Java coding conventions
- Use meaningful variable names
- Document public methods
- Write unit tests

### Building
```bash
mvn clean install
```

### Running Tests
```bash
mvn test
```

## Testing

### Unit Tests
- Model validation
- Service operations
- Data integrity

### Integration Tests
- End-to-end workflows
- Performance benchmarks
- Edge cases

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit changes
4. Push to branch
5. Create Pull Request

### Pull Request Guidelines
- Follow coding standards
- Include tests
- Update documentation
- Add changelog entry

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Support

For support and queries:
- Create an issue
- Email: support@example.com
- Documentation: [Wiki](wiki-link)

---

**Note**: For detailed API documentation and additional examples, please refer to the `/docs` directory.

*Last updated: February 2025*
