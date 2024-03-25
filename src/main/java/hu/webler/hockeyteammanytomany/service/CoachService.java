package hu.webler.hockeyteammanytomany.service;

import hu.webler.hockeyteammanytomany.entity.Coach;
import hu.webler.hockeyteammanytomany.model.CoachCreateModel;
import hu.webler.hockeyteammanytomany.model.CoachModel;
import hu.webler.hockeyteammanytomany.model.CoachUpdateModel;
import hu.webler.hockeyteammanytomany.repository.CoachRepository;
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
public class CoachService {

    private final CoachRepository coachRepository;

    public List<CoachModel> getAllCoaches() {
        return coachRepository.findAll()
                .stream()
                .map(Mapper::mapCoachEntityToCoachModel)
                .collect(Collectors.toList());
    }

    public CoachModel addCoach (CoachCreateModel coachCreateModel) {
        return Mapper.mapCoachEntityToCoachModel(coachRepository.save(Mapper.mapCoachCreateModelToCoachEntity(coachCreateModel)));
    }

    public Coach findCoachById(Long id) {
        return coachRepository.findCoachById(id)
                .orElseThrow(() -> {
                    String message = String.format("Coach with id %d was not found", id);
                    log.info(message);
                    return new NoSuchElementException(message);
                });
    }

    public void deleteCoach(Long id) {
        findCoachById(id);
        coachRepository.deleteById(id);
    }

    public Coach updateCoach (Long id, CoachUpdateModel coachUpdateModel) {
        Coach coach = findCoachById(id);
        coach.setName(coachUpdateModel.getName());
        coach.setGroups(coachUpdateModel.getGroups());
        return coachRepository.save(coach);
    }
}
