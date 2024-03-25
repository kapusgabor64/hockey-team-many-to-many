package hu.webler.hockeyteammanytomany.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupUpdateModel {

    private String name;
    private Integer youngPlayer;
    private Integer oldPlayer;
}
