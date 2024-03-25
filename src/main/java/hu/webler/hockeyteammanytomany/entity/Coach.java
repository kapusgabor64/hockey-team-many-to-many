package hu.webler.hockeyteammanytomany.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coach extends Person {

    private String name;

    @OneToMany(mappedBy = "coach")
    private List<Group> groups;
}
