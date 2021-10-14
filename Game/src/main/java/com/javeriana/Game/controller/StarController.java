package com.javeriana.Game.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javeriana.Game.model.Planet;
import com.javeriana.Game.model.Star;
import com.javeriana.Game.service.StarService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="/star")
public class StarController {

	private final StarService starService;

	public StarController( StarService starService){
		this.starService = starService;
	}

	@PostMapping("/addStar")
	public ResponseEntity<Star> addStar(@RequestBody Star star){
		starService.addStar(star);
		return new ResponseEntity<Star>(star, HttpStatus.OK);
	}

	@GetMapping("/findStar/{starId}")
	public ResponseEntity<Star> findStar(@PathVariable Long starId){
		Star star = starService.findByStarId(starId);
		if(star!=null)
			return new ResponseEntity<Star>(star, HttpStatus.OK);
		else
			return new ResponseEntity( HttpStatus.NOT_FOUND);
	}

	@GetMapping("/getPlanetsByStar/{starId}")
	public ResponseEntity<List<Planet>> getPlanetsByStar(@PathVariable Long starId){
		Star star = starService.findByStarId(starId);
		if(star!=null)
			return new ResponseEntity<List<Planet>>(star.getPlanets(), HttpStatus.OK);
		else
			return new ResponseEntity( HttpStatus.NOT_FOUND);

	}

	@GetMapping("/findAllStars")
	public ResponseEntity<List<Star>> findAllStars(){
		List<Star> stars = starService.findAllStars();
		return new ResponseEntity<List<Star>>(stars, HttpStatus.OK);
	}
}
