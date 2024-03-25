package hu.webler.hockeyteammanytomany.Controller;

import hu.webler.hockeyteammanytomany.entity.Coach;
import hu.webler.hockeyteammanytomany.model.CoachCreateModel;
import hu.webler.hockeyteammanytomany.model.CoachModel;
import hu.webler.hockeyteammanytomany.model.CoachUpdateModel;
import hu.webler.hockeyteammanytomany.service.CoachService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CoachController {

    private final CoachService coachService;

    @GetMapping("/coaches")
    public ResponseEntity<List<CoachModel>> renderALlCoach() {
        return ResponseEntity.status(200).body(coachService.getAllCoaches());
    }

    @PostMapping("/coaches")
    public ResponseEntity<CoachModel> createCoach(@RequestBody CoachCreateModel coachCreateModel) {
        return ResponseEntity.status(200).body(coachService.addCoach(coachCreateModel));
    }

    @DeleteMapping("/coaches/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        coachService.deleteCoach(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/coaches/{id}")
    public Coach updateCoach(@PathVariable Long id, @RequestBody CoachUpdateModel coachUpdateModel) {
        return coachService.updateCoach(id, coachUpdateModel);
    }
}
