package hu.webler.hockeyteammanytomany.repository;

import hu.webler.hockeyteammanytomany.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {

    Optional<Coach> findCoachById(Long id);
}
