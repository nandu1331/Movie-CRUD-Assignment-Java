package Interfaces;

import java.time.LocalDate;
import java.time.Period;

public interface Person {
    String getId();
    String getName();
    LocalDate getDateOfBirth();
    String getNationality();

    default int getAge(LocalDate referenceDate) {
        if (getDateOfBirth() != null) {
            return Period.between(getDateOfBirth(), referenceDate).getYears();
        }
        return 0;
    }
}
