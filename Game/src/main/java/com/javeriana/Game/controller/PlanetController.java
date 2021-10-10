package com.javeriana.Game.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javeriana.Game.dto.AddPlanetDTO;
import com.javeriana.Game.model.Planet;
import com.javeriana.Game.model.Star;
import com.javeriana.Game.service.PlanetService;
import com.javeriana.Game.service.StarService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/planet")
public class PlanetController {

	private final PlanetService planetService;
	private final StarService starService;

	public PlanetController( PlanetService planetService, StarService starService){

		this.starService = starService;
		this.planetService = planetService;
	}

	@PostMapping("/addPlanet")
	public ResponseEntity<Planet> addPlanet(@RequestBody AddPlanetDTO planet){


		log.info("Adding star id: {}", planet.getStarId());

		Star star = starService.findByStarId(planet.getStarId());
		if(star == null){
			log.warn("star not found by id: {}", planet.getStarId());
			return new ResponseEntity( HttpStatus.NOT_FOUND);
		}
		planet.setStar(star);
		Planet p = planetService.addPlanet(planet);

		return new ResponseEntity<Planet>(p, HttpStatus.OK);

	}

	@GetMapping("/findPlanet/{planetId}")
	public ResponseEntity<Planet> findPlanet(@PathVariable Long planetId){
		Planet planet = planetService.findPlanetById(planetId);
		if(planet!=null)
			return new ResponseEntity<Planet>(planet, HttpStatus.OK);
		else
			return new ResponseEntity( HttpStatus.NOT_FOUND);
	}

}
