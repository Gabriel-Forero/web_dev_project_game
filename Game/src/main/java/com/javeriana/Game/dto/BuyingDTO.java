package com.javeriana.Game.dto;

public class BuyingDTO {

	private Long priceId;

	private int amount;

	private Long assetId;

	private Long planetId;

	private Long teamId;

	private double totalPC;

	public BuyingDTO(final Long priceId, final int amount, final Long assetId, final Long planetId, final Long teamId,
					 final double totalPC) {

		this.priceId = priceId;
		this.amount = amount;
		this.assetId = assetId;
		this.planetId = planetId;
		this.teamId = teamId;
		this.totalPC = totalPC;
	}

	public Long getPriceId() {

		return priceId;
	}

	public void setPriceId(final Long priceId) {

		this.priceId = priceId;
	}

	public int getAmount() {

		return amount;
	}

	public void setAmount(final int amount) {

		this.amount = amount;
	}

	public Long getAssetId() {

		return assetId;
	}

	public void setAssetId(final Long assetId) {

		this.assetId = assetId;
	}

	public Long getPlanetId() {

		return planetId;
	}

	public void setPlanetId(final Long planetId) {

		this.planetId = planetId;
	}

	public Long getTeamId() {

		return teamId;
	}

	public void setTeamId(final Long teamId) {

		this.teamId = teamId;
	}

	public double getTotalPC() {

		return totalPC;
	}

	public void setTotalPC(final double totalPC) {

		this.totalPC = totalPC;
	}
}
