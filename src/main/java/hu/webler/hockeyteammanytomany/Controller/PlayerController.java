package hu.webler.hockeyteammanytomany.Controller;

import hu.webler.hockeyteammanytomany.entity.Player;
import hu.webler.hockeyteammanytomany.model.PlayerCreateModel;
import hu.webler.hockeyteammanytomany.model.PlayerModel;
import hu.webler.hockeyteammanytomany.model.PlayerUpdateModel;
import hu.webler.hockeyteammanytomany.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/players")
    public ResponseEntity<List<PlayerModel>> renderAllPlayers() {
        return ResponseEntity.status(200).body(playerService.getAllPlayers());
    }

    @PostMapping("/players")
    public ResponseEntity<PlayerModel> createPlayer(@RequestBody PlayerCreateModel playerCreateModel) {
        return ResponseEntity.status(200).body(playerService.createPlayer(playerCreateModel));
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayers(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/players/{id}")
    public Player patchPlayer(@PathVariable Long id, @RequestBody PlayerUpdateModel player) {
        return playerService.updatePlayer(id, player);
    }
}
