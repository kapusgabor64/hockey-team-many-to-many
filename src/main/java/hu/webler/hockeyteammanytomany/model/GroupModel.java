package hu.webler.hockeyteammanytomany.model;

import hu.webler.hockeyteammanytomany.entity.Coach;
import hu.webler.hockeyteammanytomany.entity.Player;
import hu.webler.hockeyteammanytomany.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupModel {

    private Long id;
    private String name;
    private Integer youngPlayer;
    private Integer oldPlayer;
    private Team team;
    private List<Player> players;
    private Coach coach;
}
