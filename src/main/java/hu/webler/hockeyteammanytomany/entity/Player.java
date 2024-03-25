package hu.webler.hockeyteammanytomany.entity;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player extends Person {

    @CreationTimestamp
    private LocalDateTime registrationDate = LocalDateTime.now();

    /*@Enumerated(EnumType.STRING)
    private Status status = Status.INACTIVE;*/

    private boolean isPaid = false;

    @ManyToMany(mappedBy = "players")
    private List<Group> groups;


}
