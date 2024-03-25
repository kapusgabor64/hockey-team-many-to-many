package hu.webler.hockeyteammanytomany.Controller;

import hu.webler.hockeyteammanytomany.entity.Group;
import hu.webler.hockeyteammanytomany.model.GroupCreateModel;
import hu.webler.hockeyteammanytomany.model.GroupModel;
import hu.webler.hockeyteammanytomany.model.GroupUpdateModel;
import hu.webler.hockeyteammanytomany.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @GetMapping("/groups")
    public ResponseEntity<List<GroupModel>> renderAllGroups() {
        return ResponseEntity.status(200).body(groupService.getallGroups());
    }

    @GetMapping("/groups/id")
    public ResponseEntity<Group> renderGroupById(Long id) {
        return ResponseEntity.status(200).body(groupService.findGroupById(id));
    }

    @PostMapping("/groups")
    public ResponseEntity<GroupModel> createGroup(@RequestBody GroupCreateModel groupCreateModel) {
        return ResponseEntity.status(200).body(groupService.createGroup(groupCreateModel));
    }

    @DeleteMapping("/groups/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        groupService.deleteGroup(id);
        return ResponseEntity.status(204).build();
    }

    @PatchMapping("/groups/{id}")
    public ResponseEntity<Group> updateGroup(@PathVariable Long id, @RequestBody GroupUpdateModel groupUpdateModel) {
        return ResponseEntity.status(200).body(groupService.updateGroup(id, groupUpdateModel));
    }
}
