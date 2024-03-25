package hu.webler.hockeyteammanytomany.Controller;

import hu.webler.hockeyteammanytomany.entity.Team;
import hu.webler.hockeyteammanytomany.model.TeamCreateModel;
import hu.webler.hockeyteammanytomany.model.TeamModel;
import hu.webler.hockeyteammanytomany.model.TeamUpdateModel;
import hu.webler.hockeyteammanytomany.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/teams")
    public ResponseEntity<List<TeamModel>> renderAllTeams() {
        return ResponseEntity.status(200).body(teamService.getTeam());
    }

    @PostMapping("/teams")
    public ResponseEntity<TeamModel> createTeam(@RequestBody TeamCreateModel teamCreateModel) {
        return ResponseEntity.status(200).body(teamService.createTeam(teamCreateModel));
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/teams/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Long id, @RequestBody TeamUpdateModel teamUpdateModel) {
        return ResponseEntity.status(200).body(teamService.updateTeam(id,teamUpdateModel));
    }
}
