package Models;

import java.time.LocalDate;

// Director class
public class Director {
    private String id;
    private String name;
    private String dateOfBirth;
    private String nationality;


    // Constructor
    public Director(String id, String name, LocalDate dateOfBirth, String nationality) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = String.valueOf(dateOfBirth);
        this.nationality = nationality;
    }

    // Setter and Getter Methods
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Director: [id=" + id + ", name=" + name + ", Date of birth="
                + dateOfBirth + ", Nationality" + nationality + "]";
    }
}
