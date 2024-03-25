package hu.webler.hockeyteammanytomany.repository;

import hu.webler.hockeyteammanytomany.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    Optional<Group> findGroupById(Long id);
}
