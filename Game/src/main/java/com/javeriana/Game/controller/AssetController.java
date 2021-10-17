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
import com.javeriana.Game.model.Asset;
import com.javeriana.Game.model.Planet;
import com.javeriana.Game.model.Star;
import com.javeriana.Game.service.AssetService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/asset")
public class AssetController {

	private final AssetService assetService;

	public AssetController(final AssetService assetService) {
		this.assetService = assetService;
	}

	@PostMapping("/addAsset")
	public ResponseEntity<Asset> addAsset(@RequestBody Asset asset){
		Asset newAsset = assetService.addAsset(asset);
		return new ResponseEntity<Asset>(newAsset, HttpStatus.OK);
	}

	@GetMapping("/findAllAssets")
	public ResponseEntity<List<Asset>> findAllAssets(){
		List<Asset> assets = assetService.findAllAssets();
		return new ResponseEntity<List<Asset>>(assets, HttpStatus.OK);
	}

	@PutMapping("/updateAsset/{assetId}")
	public ResponseEntity<Asset> updateAsset(@PathVariable Long assetId, @RequestBody Asset asset){

		Asset assetExists = assetService.findAssetById(assetId);

		if(assetExists == null){
			return new ResponseEntity<Asset>( HttpStatus.NOT_FOUND);
		}
		Asset assetUpdated = assetService.updateAsset(asset);
		return new ResponseEntity<Asset>(assetUpdated, HttpStatus.OK);
	}
}
