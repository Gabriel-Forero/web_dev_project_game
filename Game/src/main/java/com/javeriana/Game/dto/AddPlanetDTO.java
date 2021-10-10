package com.javeriana.Game.dto;

import com.javeriana.Game.model.Star;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddPlanetDTO {

	private String planetName;

	private Long starId;

	private Star star;

	public String getPlanetName() {

		return planetName;
	}

	public void setPlanetName(final String planetName) {

		this.planetName = planetName;
	}

	public Long getStarId() {

		return starId;
	}

	public Star getStar() {

		return star;
	}

	public void setStar(final Star star) {

		this.star = star;
	}

	public void setStarId(final Long starId) {

		this.starId = starId;
	}
}
