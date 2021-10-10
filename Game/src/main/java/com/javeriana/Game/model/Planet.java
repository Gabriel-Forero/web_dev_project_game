package com.javeriana.Game.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "planet_id")
    private Long planetId;

    @Column(name= "planet_name")
    private String planetName;


    @OneToMany(mappedBy = "planet")
    private List<Price> assets = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="star_id", nullable=false)
    private Star star;

    public Planet() {}

    public Planet(Long planetId, String planetName, List<Price> assets, Star star) {
        this.planetId = planetId;
        this.planetName = planetName;
        this.assets = assets;
        this.star = star;
    }

    public Long getPlanetId() {
        return planetId;
    }

    public void setPlanetId(Long planetId) {
        this.planetId = planetId;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public List<Price> getAssets() {
        return assets;
    }

    public void setAssets(List<Price> assets) {
        this.assets = assets;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }
}
