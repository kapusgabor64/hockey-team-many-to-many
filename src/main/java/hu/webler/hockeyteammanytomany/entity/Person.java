package hu.webler.hockeyteammanytomany.entity;

import hu.webler.hockeyteammanytomany.entity.base.Identifier;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
public class Person extends Identifier {

    private String firstName;
    private String midName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
}
