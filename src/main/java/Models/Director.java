package Models;

import java.time.LocalDate;
import Interfaces.Person;

public class Director implements Person {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private String nationality;

    // Constructor
    public Director(String id, String name, LocalDate dateOfBirth, String nationality) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

    // Implemented Methods from Person Interface
    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return "Director: [id=" + id + ", name=" + name + ", Date of birth="
                + dateOfBirth + ", Nationality=" + nationality + "]";
    }
}
