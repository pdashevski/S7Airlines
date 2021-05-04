package models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contacts {
    String telephoneNumber;
    String email;
}
