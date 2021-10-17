package com.javeriana.Game.dto;

import com.javeriana.Game.model.Asset;
import com.javeriana.Game.model.Planet;

public class PriceDTO {

	private Long priceId;

	private int assetAmount;

	private Long demandFactor;

	private Long supplyFactor;

	private Asset asset;

	private double pc;

	private double pv;

	public PriceDTO() {}

	public Long getPriceId() {

		return priceId;
	}

	public void setPriceId(final Long priceId) {

		this.priceId = priceId;
	}

	public int getAssetAmount() {

		return assetAmount;
	}

	public void setAssetAmount(final int assetAmount) {

		this.assetAmount = assetAmount;
	}

	public Long getDemandFactor() {

		return demandFactor;
	}

	public void setDemandFactor(final Long demandFactor) {

		this.demandFactor = demandFactor;
	}

	public Long getSupplyFactor() {

		return supplyFactor;
	}

	public void setSupplyFactor(final Long supplyFactor) {

		this.supplyFactor = supplyFactor;
	}

	public Asset getAsset() {

		return asset;
	}

	public void setAsset(final Asset asset) {

		this.asset = asset;
	}

	public double getPc() {

		return pc;
	}

	public void setPc(final double pc) {

		this.pc = pc;
	}

	public double getPv() {

		return pv;
	}

	public void setPv(final double pv) {

		this.pv = pv;
	}
}
