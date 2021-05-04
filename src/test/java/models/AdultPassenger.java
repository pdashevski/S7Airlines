package models;

import lombok.*;

@Data
@AllArgsConstructor
public class AdultPassenger {
    String firstName;
    String lastName;
    String dateOfBirth;
    String documentNumber;
}
