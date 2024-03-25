package hu.webler.hockeyteammanytomany.util;

import hu.webler.hockeyteammanytomany.entity.Coach;
import hu.webler.hockeyteammanytomany.entity.Group;
import hu.webler.hockeyteammanytomany.entity.Player;
import hu.webler.hockeyteammanytomany.entity.Team;
import hu.webler.hockeyteammanytomany.model.*;

public class Mapper {

    public static GroupModel mapGroupEntityToGroupModel(Group group) {
        GroupModel model = new GroupModel();
        model.setId(group.getId());
        model.setName(group.getName());
        model.setYoungPlayer(group.getYoungPlayer());
        model.setOldPlayer(group.getOldPlayer());
        model.setTeam(group.getTeam());
        model.setCoach(group.getCoach());
        return model;
    }

    public static Group mapGroupCreateModelToGroupEntity(GroupCreateModel model) {
        Group currentGroup = new Group();
        currentGroup.setName(model.getName());
        currentGroup.setYoungPlayer(model.getYoungPlayer());
        currentGroup.setOldPlayer(model.getOldPlayer());
        return currentGroup;
    }

    public static PlayerModel mapPlayerEntityToPlayerModel (Player player) {
        PlayerModel model = new PlayerModel();
        model.setId(player.getId());
        model.setFirstName(player.getFirstName());
        model.setMidName(player.getMidName());
        model.setLastName(player.getLastName());
        model.setPhoneNumber(player.getPhoneNumber());
        model.setEmail(player.getEmail());
        model.setDateOfBirth(player.getDateOfBirth());
        return model;
    }

    public static Player mapPlayerCreateModelToPlayerEntity(PlayerCreateModel model) {
        Player player = new Player();
        player.setFirstName(model.getFirstName());
        player.setMidName(model.getMidName());
        player.setLastName(model.getLastName());
        player.setPhoneNumber(model.getPhoneNumber());
        player.setEmail(model.getEmail());
        player.setDateOfBirth(model.getDateOfBirth());
        return player;
    }

    public static CoachModel mapCoachEntityToCoachModel(Coach coach) {
        CoachModel model = new CoachModel();
        model.setId(coach.getId());
        model.setName(coach.getName());
        model.setGroups(coach.getGroups());
        return model;
    }

    public static Coach mapCoachCreateModelToCoachEntity(CoachCreateModel model) {
        Coach coach = new Coach();
        coach.setName(model.getName());
        coach.setGroups(model.getGroups());
        return coach;
    }

    public static TeamModel mapTeamEntityToTeamModel(Team team) {
        TeamModel model = new TeamModel();
        model.setId(team.getId());
        model.setName(team.getName());
        model.setAddress(team.getAddress());
        model.setGroups(team.getGroups());
        return model;
    }

    public static Team mapTeamCreateModelToTeamEntity(TeamCreateModel model) {
        Team team = new Team();
        team.setName(model.getName());
        team.setAddress(model.getAddress());
        return team;
    }

    private Mapper() {

    }
}
