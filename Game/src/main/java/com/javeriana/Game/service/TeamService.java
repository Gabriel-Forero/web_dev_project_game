package com.javeriana.Game.service;
//import com.javeriana.Game.model.Ship;
import com.javeriana.Game.dto.AddTeamDTO;
import com.javeriana.Game.dto.TravelDTO;
import com.javeriana.Game.model.Star;
import com.javeriana.Game.model.Team;
import com.javeriana.Game.model.User;
import com.javeriana.Game.repository.TeamRepository;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TeamService {
    private final TeamRepository teamRepo;

    public  TeamService(TeamRepository teamRepo) {
        this.teamRepo=teamRepo;
    }

    public Team addTeam(AddTeamDTO teamDTO) {
        Team team =  new Team();
        team.setTeamName(teamDTO.getTeamName());
        team.setTeamCurrentMoney(teamDTO.getTeamCurrentMoney());
        team.setShip(teamDTO.getShip());
        team.setTeamTimeGame(teamDTO.getTeamTimeGame());
        team.setTeamPositionX(teamDTO.getTeamPositionX());
        team.setTeamPositionY(teamDTO.getTeamPositionY());
        team.setTeamPositionZ(teamDTO.getTeamPositionZ());
        return teamRepo.save(team);
    }

    public List<Team> findAllTeams(){
        return (List<Team>) teamRepo.findAll();
    }

    public Team updateTeam(Team team) {
        return teamRepo.save(team);
    }

    public void deleteTeamById(Long id) {
        teamRepo.deleteById(id);
    }

    public Team findByTeamId(Long teamId) {
        log.info("looking for the team");
        return teamRepo.findByTeamId(teamId);
    }

    public User addUserToTeam(Team team, User user){
        team.getUsers().add(user);
        //log.info("New user named: {} with id {} added to the team {}",user.getUserName(), String.valueOf(user.getUserId()), team.getTeamName());
        teamRepo.save(team);
        return user;
    }

    public List<User> getUsersFromTeam(Team team){
        return team.getUsers();
    }

    public TravelDTO goToOtherStar(Team team, Star star){
        team.setTeamTimeGame(calculateTimeOfTravel(team,star));
        team.setTeamPositionX(star.getStarPositionX());
        team.setTeamPositionY(star.getStarPositionY());
        team.setTeamPositionZ(star.getStarPositionZ());

        Team newTeam = teamRepo.save(team);

        return new TravelDTO(newTeam, star );
    }

    private double calculateTimeOfTravel(Team team, Star star){
        double x = Math.pow(Math.abs(team.getTeamPositionX()- star.getStarPositionX()) ,2);
        double y = Math.pow(Math.abs(team.getTeamPositionY()- star.getStarPositionY()) ,2);
        double z = Math.pow(Math.abs(team.getTeamPositionZ()- star.getStarPositionZ()) ,2);
        return team.getTeamTimeGame() + Math.sqrt(x+y+z)/(double) team.getShip().getShipSpeed();
    }
}
