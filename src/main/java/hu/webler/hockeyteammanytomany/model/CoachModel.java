package hu.webler.hockeyteammanytomany.model;

import hu.webler.hockeyteammanytomany.entity.Group;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CoachModel {

    private Long id;
    private String name;
    private List<Group> groups;
}
