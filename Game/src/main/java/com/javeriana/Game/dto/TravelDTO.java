package com.javeriana.Game.dto;

import com.javeriana.Game.model.Star;
import com.javeriana.Game.model.Team;

public class TravelDTO {

	private Team team;

	private Star star;

	public TravelDTO(final Team team, final Star star) {

		this.team = team;
		this.star = star;
	}

	public Team getTeam() {

		return team;
	}

	public void setTeam(final Team team) {

		this.team = team;
	}

	public Star getStar() {

		return star;
	}

	public void setStar(final Star star) {

		this.star = star;
	}
}
