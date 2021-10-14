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
import com.javeriana.Game.model.Ship;
import com.javeriana.Game.model.Star;
import com.javeriana.Game.service.ShipService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path="/ship")
public class ShipController {

	private final ShipService shipService;

	public ShipController(ShipService shipService) {
		this.shipService = shipService;
	}

	@PostMapping("/addShip")
	public ResponseEntity<Ship> addShip(@RequestBody Ship ship){
		Ship nShip =shipService.addShip(ship);
		return new ResponseEntity<Ship>(nShip, HttpStatus.OK);
	}

	@GetMapping("/findShip/{shipId}")
	public ResponseEntity<Ship> findShip(@PathVariable Long shipId){
		Ship nShip =shipService.findByShipId(shipId);
		return new ResponseEntity<Ship>(nShip, HttpStatus.OK);
	}

	@GetMapping("/findAllShips")
	public ResponseEntity<List<Ship>> findAllShips(){
		List<Ship> ships = shipService.findAllShips();
		return new ResponseEntity<List<Ship>>(ships, HttpStatus.OK);
	}

	@PutMapping("/updateShip/{shipId}")
	public ResponseEntity<Ship> updateShip(@PathVariable Long shipId, @RequestBody Ship ship){

		Ship shipExists = shipService.findByShipId(shipId);

		if(shipExists == null){
			log.info("ship not found");
			return new ResponseEntity<Ship>( HttpStatus.NOT_FOUND);
		}

		Ship shipUpdated = shipService.updateShip(ship);
		return new ResponseEntity<Ship>(shipUpdated, HttpStatus.OK);
	}
}
