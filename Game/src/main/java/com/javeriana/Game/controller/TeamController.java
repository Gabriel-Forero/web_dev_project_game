package com.javeriana.Game.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javeriana.Game.dto.AddTeamDTO;
import com.javeriana.Game.dto.TravelDTO;
import com.javeriana.Game.model.Ship;
import com.javeriana.Game.model.Star;
import com.javeriana.Game.model.Team;
import com.javeriana.Game.model.User;
import com.javeriana.Game.service.ShipService;
import com.javeriana.Game.service.StarService;
import com.javeriana.Game.service.TeamService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="/team")
public class TeamController {

	private final TeamService teamservice;
	private final ShipService shipService;
	private final StarService starService;

	public TeamController(final TeamService teamservice, final ShipService shipService, final StarService starService) {

		this.teamservice = teamservice;
		this.shipService = shipService;
		this.starService = starService;
	}

	@PostMapping("/addTeam")
	public ResponseEntity<Team> addTeam(@RequestBody AddTeamDTO teamDTO){

		Ship ship = shipService.findByShipId(teamDTO.getShipId());
		if( ship == null){
			return  new ResponseEntity( HttpStatus.NOT_FOUND);
		}
		teamDTO.setShip(ship);
		Team nTeam  = teamservice.addTeam(teamDTO);
		return  new ResponseEntity<Team>(nTeam, HttpStatus.OK);
	}

	@GetMapping("/findTeam/{teamId}")
	public ResponseEntity<Team> findTeam(@PathVariable Long teamId){
		Team team =teamservice.findByTeamId(teamId);
		return new ResponseEntity<Team>(team, HttpStatus.OK);
	}

	@GetMapping("/findUsersByTeam/{teamId}")
	public ResponseEntity<List<User>> findUsersByTeam(@PathVariable Long teamId){
		Team team =teamservice.findByTeamId(teamId);
		return new ResponseEntity<List<User>>(team.getUsers(), HttpStatus.OK);
	}

	@GetMapping("/findAllTeams")
	public ResponseEntity<List<Team>> findAllUser(){
		List<Team> teams = teamservice.findAllTeams();
		return new ResponseEntity<List<Team>>(teams, HttpStatus.OK);
	}

	@PutMapping("/updateTeam/{teamId}")
	public ResponseEntity<Team> updateTeam(@PathVariable Long teamId, @RequestBody Team team){

		Team teamExists = teamservice.findByTeamId(teamId);
		if(teamExists == null){
			log.info("team not found");
			return new ResponseEntity<Team>( HttpStatus.NOT_FOUND);
		}
		team.setShip(teamExists.getShip());
		Team teamUpdated = teamservice.updateTeam(team);
		return new ResponseEntity<Team>(teamUpdated, HttpStatus.OK);
	}

	@GetMapping("/goToOtherStar/{teamId}/{starId}")
	public ResponseEntity<TravelDTO> goToOtherStar(@PathVariable Long teamId, @PathVariable Long starId){
		Team teamExists = teamservice.findByTeamId(teamId);
		Star starExists = starService.findByStarId(starId);

		TravelDTO teamUpdated = teamservice.goToOtherStar(teamExists, starExists);
		return new ResponseEntity<TravelDTO>(teamUpdated, HttpStatus.OK);



	}



}
