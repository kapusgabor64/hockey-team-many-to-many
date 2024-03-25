package hu.webler.hockeyteammanytomany.entity;

import hu.webler.hockeyteammanytomany.entity.base.Identifier;
import jakarta.persistence.CascadeType;
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
public class Team  extends Identifier {

    private String name;
    private String address;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Group> groups;
}
