package hu.webler.hockeyteammanytomany.service;

import hu.webler.hockeyteammanytomany.entity.Group;
import hu.webler.hockeyteammanytomany.model.GroupCreateModel;
import hu.webler.hockeyteammanytomany.model.GroupModel;
import hu.webler.hockeyteammanytomany.model.GroupUpdateModel;
import hu.webler.hockeyteammanytomany.repository.GroupRepository;
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
public class GroupService {

    private final GroupRepository groupRepository;

    public List<GroupModel> getallGroups() {
        return groupRepository.findAll()
                .stream()
                .map(Mapper::mapGroupEntityToGroupModel)
                .collect(Collectors.toList());
    }

    public Group findGroupById(Long id) {
        return groupRepository.findGroupById(id)
                .orElseThrow(() -> {
                    String message = String.format("Group with id %d not found", id);
                    log.info(message);
                    return new NoSuchElementException(message);
                });
    }

    public GroupModel createGroup(GroupCreateModel groupCreateModel) {
        return Mapper.mapGroupEntityToGroupModel(groupRepository.save(Mapper.mapGroupCreateModelToGroupEntity(groupCreateModel)));
    }

    public void deleteGroup(Long id) {
        findGroupById(id);
        groupRepository.deleteById(id);
    }

    public Group updateGroup(Long id, GroupUpdateModel groupUpdateModel) {
        Group group = findGroupById(id);
        group.setName(groupUpdateModel.getName());
        group.setYoungPlayer(groupUpdateModel.getYoungPlayer());
        group.setOldPlayer(groupUpdateModel.getOldPlayer());
        return groupRepository.save(group);
    }
}
