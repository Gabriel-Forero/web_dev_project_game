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
import com.javeriana.Game.dto.PriceDTO;
import com.javeriana.Game.model.Price;
import com.javeriana.Game.service.PriceService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/price")
public class PriceController {


	private final PriceService priceService;

	public PriceController(final PriceService priceService) {
		this.priceService = priceService;
	}

	@PostMapping("/addPrice")
	public ResponseEntity<Price> addPrice(@RequestBody Price price){
		Price newPrice = priceService.addPrice(price);
		return new ResponseEntity<Price> (newPrice, HttpStatus.OK);
	}

	@GetMapping("/findallByPlanetId/{planetId}")
	public ResponseEntity<List<PriceDTO>> findallByPlanet(@PathVariable Long planetId){
		List<PriceDTO> assets = priceService.findAllByPlanet(planetId);
		return new ResponseEntity<List<PriceDTO>> (assets, HttpStatus.OK);
	}

	@GetMapping("/findByPriceId/{priceId}")
	public ResponseEntity<PriceDTO> findByPriceId(@PathVariable Long priceId){
		PriceDTO asset = priceService.findByPriceId(priceId);
		return new ResponseEntity<PriceDTO> (asset, HttpStatus.OK);
	}



}
