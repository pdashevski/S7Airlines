package models;

import lombok.*;

@Data
@AllArgsConstructor
public class Passenger {
    String firstName;
    String lastName;
    String dateOfBirth;
    String documentNumber;
    String email;
    String telephoneNumber;
}
