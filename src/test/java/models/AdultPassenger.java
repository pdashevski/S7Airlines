package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdultPassenger {
    String firstName;
    String lastName;
    String dateOfBirth;
    String documentNumber;
}
