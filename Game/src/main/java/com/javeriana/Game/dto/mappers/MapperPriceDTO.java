package com.javeriana.Game.dto.mappers;

import com.javeriana.Game.dto.PriceDTO;
import com.javeriana.Game.model.Price;

public class MapperPriceDTO {

	public PriceDTO mapperToPriceDTO(Price price){
		PriceDTO priceDTO = new PriceDTO();

		priceDTO.setPriceId(price.getPriceId());
		priceDTO.setAssetAmount(price.getAssetAmount());
		priceDTO.setDemandFactor(price.getDemandFactor());
		priceDTO.setSupplyFactor(price.getSupplyFactor());
		priceDTO.setAsset(price.getAsset());
		priceDTO.setPv(pvCalculator(price));
		priceDTO.setPc(pcCalculator(price));

		return priceDTO;
	}

	private double pvCalculator(Price price){
		return (double)price.getDemandFactor()/(1+(double)price.getAssetAmount());
	}

	private Double pcCalculator(Price price){
		return (double)price.getSupplyFactor()/(1+(double)price.getAssetAmount());
	}
}
