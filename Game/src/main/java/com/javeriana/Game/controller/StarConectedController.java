package com.javeriana.Game.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javeriana.Game.model.StarConected;
import com.javeriana.Game.service.StarConectedService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="/starConected")
public class StarConectedController {

	private final StarConectedService starConectedService;

	public StarConectedController(final StarConectedService starConectedService) {
		this.starConectedService = starConectedService;
	}

	@GetMapping("/findNearestStarsBySatrId/{starId}")
	public ResponseEntity<List<StarConected>> findNearestStarsBySatrId(@PathVariable Long starId){
		List<StarConected> stars = starConectedService.findNearestStarsBySatrId(starId);
		return new ResponseEntity<List<StarConected>>(stars, HttpStatus.OK);
	}
}
