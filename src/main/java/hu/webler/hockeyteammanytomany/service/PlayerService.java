package hu.webler.hockeyteammanytomany.service;

import hu.webler.hockeyteammanytomany.entity.Player;
import hu.webler.hockeyteammanytomany.model.PlayerCreateModel;
import hu.webler.hockeyteammanytomany.model.PlayerModel;
import hu.webler.hockeyteammanytomany.model.PlayerUpdateModel;
import hu.webler.hockeyteammanytomany.repository.PlayerRepository;
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
public class PlayerService {

    private final PlayerRepository playerRepository;

    public List<PlayerModel> getAllPlayers() {
        return playerRepository.findAll()
                .stream()
                .map(Mapper::mapPlayerEntityToPlayerModel)
                .collect(Collectors.toList());
    }

    public Player findPlayerById(Long id) {
        return playerRepository.findPlayerById(id)
                .orElseThrow(() -> {
                    String message = String.format("Player with id %d was not found",id);
                    log.info(message);
                    return new NoSuchElementException(message);
                });
    }

    public PlayerModel createPlayer(PlayerCreateModel playerCreateModel) {
        return Mapper.mapPlayerEntityToPlayerModel(playerRepository.save(Mapper.mapPlayerCreateModelToPlayerEntity(playerCreateModel)));
    }

    public void deletePlayers(Long id) {
        findPlayerById(id);
        playerRepository.deleteById(id);
    }

    public Player updatePlayer(Long id, PlayerUpdateModel model) {
        Player player = findPlayerById(id);
        player.setFirstName(model.getFirstName());
        player.setMidName(model.getMidName());
        player.setLastName(model.getLastName());
        player.setPhoneNumber(model.getPhoneNumber());
        player.setEmail(model.getEmail());
        player.setDateOfBirth(model.getDateOfBirth());
        return playerRepository.save(player);
    }
}
