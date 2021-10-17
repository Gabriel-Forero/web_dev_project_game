package com.javeriana.Game.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javeriana.Game.model.Asset;
import com.javeriana.Game.model.AssetsByTeam;
import com.javeriana.Game.service.AssetsByTeamService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/assetsByTeamController")
public class AssetsByTeamController {

	private final AssetsByTeamService assetByTeamService;

	public AssetsByTeamController(final AssetsByTeamService assetByTeamService) {
		this.assetByTeamService = assetByTeamService;
	}

	@GetMapping("/findAllByTeamId/{teamId}")
	public ResponseEntity<List<AssetsByTeam>> findAllByTeamId(@PathVariable Long teamId){
		List<AssetsByTeam> assets = assetByTeamService.findAllByTeam(teamId);
		return new ResponseEntity<List<AssetsByTeam>>(assets, HttpStatus.OK);
	}

	@GetMapping("/findByAsset/{assetId}")
	public ResponseEntity<AssetsByTeam> findByAsset(@PathVariable Long assetId){
		AssetsByTeam asset = assetByTeamService.findByAsset(assetId);
		return new ResponseEntity<AssetsByTeam>(asset, HttpStatus.OK);
	}
}
