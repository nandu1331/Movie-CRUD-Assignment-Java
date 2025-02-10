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
