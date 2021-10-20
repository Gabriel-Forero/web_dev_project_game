package com.javeriana.Game.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javeriana.Game.dto.BuyingDTO;
import com.javeriana.Game.model.Asset;
import com.javeriana.Game.model.AssetsByTeam;
import com.javeriana.Game.model.Planet;
import com.javeriana.Game.model.Price;
import com.javeriana.Game.model.Team;
import com.javeriana.Game.service.AssetService;
import com.javeriana.Game.service.AssetsByTeamService;
import com.javeriana.Game.service.PlanetService;
import com.javeriana.Game.service.PriceService;
import com.javeriana.Game.service.TeamService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/sales")
public class SellingUseCaseController {

	private final PriceService priceService;

	private final AssetService assetService;

	private final PlanetService planetService;

	private final TeamService teamService;

	private final AssetsByTeamService assetsByTeamService;

	public SellingUseCaseController(final PriceService priceService, final AssetService assetService,
									final PlanetService planetService, final TeamService teamService,
									final AssetsByTeamService assetsByTeamService) {

		this.priceService = priceService;
		this.assetService = assetService;
		this.planetService = planetService;
		this.teamService = teamService;
		this.assetsByTeamService = assetsByTeamService;
	}

	@PostMapping("/buying")
	public ResponseEntity buying(@RequestBody BuyingDTO buyingDTO){
		Price price = priceService.findByPriceIdReturnPrice(buyingDTO.getPriceId());
		Asset asset  = assetService.findAssetById(buyingDTO.getAssetId());
		Team team = teamService.findByTeamId(buyingDTO.getTeamId());
		AssetsByTeam assetsByTeam = assetsByTeamService.findAssetByTeamAndAsset(team.getTeamId(), asset.getAssetId());

		price.setAssetAmount(price.getAssetAmount()-buyingDTO.getAmount());
		team.setTeamCurrentMoney(team.getTeamCurrentMoney()- buyingDTO.getTotalPC());
		if(assetsByTeam!=null){
			assetsByTeam.setAssetAmount(assetsByTeam.getAssetAmount()+buyingDTO.getAmount());
			assetsByTeamService.updateAssetsByTeam(assetsByTeam);
		}
		else{
			AssetsByTeam newAssetsByTeam = new AssetsByTeam();
			newAssetsByTeam.setAsset(asset);
			newAssetsByTeam.setTeam(team);
			newAssetsByTeam.setAssetAmount(buyingDTO.getAmount());
			assetsByTeamService.addAssetsByTeam(newAssetsByTeam);
		}
		priceService.updatePrice(price);
		teamService.updateTeam(team);

		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/selling")
	public ResponseEntity selling(@RequestBody BuyingDTO buyingDTO){

		Asset asset  = assetService.findAssetById(buyingDTO.getAssetId());
		Team team = teamService.findByTeamId(buyingDTO.getTeamId());
		Planet planet = planetService.findPlanetById(buyingDTO.getPlanetId());
		AssetsByTeam assetsByTeam = assetsByTeamService.findByAsset(buyingDTO.getAssetId());
		Price price = priceService.findByPlanetAndAssetReturn(planet,asset);

		team.setTeamCurrentMoney(team.getTeamCurrentMoney()+ buyingDTO.getTotalPC());
		assetsByTeam.setAssetAmount(assetsByTeam.getAssetAmount()-buyingDTO.getAmount());
		if(price!=null){
			price.setAssetAmount(price.getAssetAmount()+buyingDTO.getAmount());
			priceService.updatePrice(price);
		}
		else{
			Price newPrice = new Price();
			newPrice.setAsset(asset);
			newPrice.setPlanet(planet);
			newPrice.setAssetAmount(buyingDTO.getAmount());
			priceService.addPrice(newPrice);
		}
		assetsByTeamService.updateAssetsByTeam(assetsByTeam);
		teamService.updateTeam(team);

		return new ResponseEntity(HttpStatus.OK);
	}
}
