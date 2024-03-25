package hu.webler.hockeyteammanytomany.service;

import hu.webler.hockeyteammanytomany.entity.Team;
import hu.webler.hockeyteammanytomany.model.TeamCreateModel;
import hu.webler.hockeyteammanytomany.model.TeamModel;
import hu.webler.hockeyteammanytomany.model.TeamUpdateModel;
import hu.webler.hockeyteammanytomany.repository.TeamRepository;
import hu.webler.hockeyteammanytomany.util.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {

    private final TeamRepository teamRepository;

    public List<TeamModel> getTeam() {
        return teamRepository.findAll()
                .stream()
                .map(Mapper::mapTeamEntityToTeamModel)
                .collect(Collectors.toList());
    }

    public Team findTeamById(Long id) {
        return teamRepository.findTeamById(id)
                .orElseThrow(() -> {
                    String message = String.format("Team with id %d not found", id);
                    log.info(message);
                    return new NoSuchElementException(message);
                });
    }

    public TeamModel createTeam(TeamCreateModel teamCreateModel) {
        return Mapper.mapTeamEntityToTeamModel(teamRepository.save(Mapper.mapTeamCreateModelToTeamEntity(teamCreateModel)));
    }

    public void deleteTeam(Long id) {
        findTeamById(id);
        teamRepository.deleteById(id);
    }

    public Team updateTeam (Long id, TeamUpdateModel model) {
        Team team = findTeamById(id);
        team.setName(model.getName());
        team.setAddress(model.getAddress());
        team.setGroups(model.getGroups());
        return teamRepository.save(team);
    }
}
