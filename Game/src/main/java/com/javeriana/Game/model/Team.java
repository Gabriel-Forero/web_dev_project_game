package com.javeriana.Game.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "team_id")
    private Long teamId;

    @Column(name= "team_name")
    private String teamName;

    @Column(name= "team_current_money" , columnDefinition = "Decimal(10,2) default '000.00'")
    private double teamCurrentMoney;

    @Column(name= "team_time_game", columnDefinition = "Decimal(10,2) default '000.00'")
    private double teamTimeGame;

    @Column(name= "team_position_x", columnDefinition = "Decimal(10,2) default '000.00'")
    private double teamPositionX;

    @Column(name= "team_position_y", columnDefinition = "Decimal(10,2) default '000.00'")
    private double teamPositionY;

    @Column(name= "team_position_z", columnDefinition = "Decimal(10,2) default '000.00'")
    private double teamPositionZ;

    @ManyToOne
    @JsonIgnore
    private Ship ship;

    @OneToMany(mappedBy="team")
    @JsonIgnore
    private List<User> users =  new ArrayList<>();

    @OneToMany(mappedBy="team")
    @JsonIgnore
    private Set<AssetsByTeam> assets;

    public Team() {}

    public Team(Long teamId, String teamName, Long teamCurrentMoney, Long teamTimeGame, double teamPositionX, double teamPositionY, double teamPositionZ, Ship ship, List<User> users, Set<AssetsByTeam> assets) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.teamCurrentMoney = teamCurrentMoney;
        this.teamTimeGame = teamTimeGame;
        this.teamPositionX = teamPositionX;
        this.teamPositionY = teamPositionY;
        this.teamPositionZ = teamPositionZ;
        this.ship = ship;
        this.users = users;
        this.assets = assets;
    }

    public double getTeamPositionX() {
        return teamPositionX;
    }

    public void setTeamPositionX(double teamPositionX) {
        this.teamPositionX = teamPositionX;
    }

    public double getTeamPositionY() {
        return teamPositionY;
    }

    public void setTeamPositionY(double teamPositionY) {
        this.teamPositionY = teamPositionY;
    }

    public double getTeamPositionZ() {
        return teamPositionZ;
    }

    public void setTeamPositionZ(double teamPositionZ) {
        this.teamPositionZ = teamPositionZ;
    }

    public Set<AssetsByTeam> getAssets() {
        return assets;
    }

    public void setAssets(Set<AssetsByTeam> assets) {
        this.assets = assets;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public double getTeamCurrentMoney() {

        return teamCurrentMoney;
    }

    public void setTeamCurrentMoney(final double teamCurrentMoney) {

        this.teamCurrentMoney = teamCurrentMoney;
    }

    public void setTeamCurrentMoney(Long teamCurrentMoney) {
        this.teamCurrentMoney = teamCurrentMoney;
    }

    public double getTeamTimeGame() {
        return teamTimeGame;
    }

    public void setTeamTimeGame(double teamTimeGame) {
        this.teamTimeGame = teamTimeGame;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
