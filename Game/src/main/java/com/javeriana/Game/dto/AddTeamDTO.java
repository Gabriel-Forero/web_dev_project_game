package com.javeriana.Game.dto;

import com.javeriana.Game.model.Ship;

public class AddTeamDTO {

	private String teamName;

	private Long teamTimeGame;

	private Long teamCurrentMoney;

	private Long teamPositionX;

	private Long teamPositionY;

	private Long teamPositionZ;

	private Long shipId;

	private Ship ship;

	public String getTeamName() {

		return teamName;
	}
	public Long getTeamTimeGame() {

		if(teamTimeGame ==null){
			return (long) 0;
		}

		return teamTimeGame;
	}

	public void setTeamTimeGame(final Long teamTimeGame) {

		this.teamTimeGame = teamTimeGame;
	}

	public void setTeamName(final String teamName) {

		this.teamName = teamName;
	}

	public Long getTeamCurrentMoney() {

		return teamCurrentMoney;
	}

	public void setTeamCurrentMoney(final Long teamCurrentMoney) {

		this.teamCurrentMoney = teamCurrentMoney;
	}

	public Long getTeamPositionX() {

		return teamPositionX;
	}

	public void setTeamPositionX(final Long teamPositionX) {

		this.teamPositionX = teamPositionX;
	}

	public Long getTeamPositionY() {

		return teamPositionY;
	}

	public void setTeamPositionY(final Long teamPositionY) {

		this.teamPositionY = teamPositionY;
	}

	public Long getTeamPositionZ() {

		return teamPositionZ;
	}

	public void setTeamPositionZ(final Long teamPositionZ) {

		this.teamPositionZ = teamPositionZ;
	}

	public Long getShipId() {

		return shipId;
	}

	public void setShipId(final Long shipId) {

		this.shipId = shipId;
	}

	public Ship getShip() {

		return ship;
	}

	public void setShip(final Ship ship) {

		this.ship = ship;
	}
}
