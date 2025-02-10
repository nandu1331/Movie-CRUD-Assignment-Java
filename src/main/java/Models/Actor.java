package Models;
import java.time.LocalDate;
import java.time.Period;

public class Actor {
    private String id;
    private String name;
    private LocalDate dateOfBirth;
    private String nationality;

    public Actor(String id, String name, LocalDate dateOfBirth, String nationality) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
    }

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getPresentAge(LocalDate date) {
        if (dateOfBirth != null) {
            return Period.between(dateOfBirth, date).getYears();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Actor: [id=" + id + ", name=" + name + ", Date of birth="
                + dateOfBirth + ", Nationality=" + nationality + "]";
    }
}
