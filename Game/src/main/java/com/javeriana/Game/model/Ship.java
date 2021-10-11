package com.javeriana.Game.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ship")
public class Ship  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ship_id")
    Long shipId;

    @Column(name= "ship_type")
    String shipType;

    @Column(name= "speed")
    Long shipSpeed;

    @Column(name= "ship_volume")
    Long shipVolume;

    @OneToMany(mappedBy="ship")
    @JsonIgnore
    List<Team> teams = new ArrayList<>();

    public Ship() {}

    public Ship(Long shipId, String shipType, Long shipSpeed, Long shipVolume ) {
        this.shipId = shipId;
        this.shipType = shipType;
        this.shipSpeed = shipSpeed;
        this.shipVolume = shipVolume;
     
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public Long getShipSpeed() {
        return shipSpeed;
    }

    public void setShipSpeed(Long shipSpeed) {
        this.shipSpeed = shipSpeed;
    }

    public Long getShipVolume() {
        return shipVolume;
    }

    public void setShipVolume(Long shipVolume) {
        this.shipVolume = shipVolume;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
