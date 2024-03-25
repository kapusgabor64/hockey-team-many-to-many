package hu.webler.hockeyteammanytomany.entity;

import hu.webler.hockeyteammanytomany.entity.base.Identifier;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group extends Identifier {

    @NonNull
    private String name;
    @NonNull
    private Integer youngPlayer;
    private Integer oldPlayer;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToMany
    @JoinTable(
            name = "group_player",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players;

    @ManyToOne
    @JoinColumn(name = "coach_id")
    private Coach coach;
}
