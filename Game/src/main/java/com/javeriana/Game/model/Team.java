package com.javeriana.Game.model;
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
    Long teamId;

    @Column(name= "team_name")
    String teamName;

    @Column(name= "team_current_money" , columnDefinition = "Decimal(10,2) default '000.00'")
    Long teamCurrentMoney;

    @Column(name= "team_time_game", columnDefinition = "Decimal(10,2) default '000.00'")
    Long teamTimeGame;

    @Column(name= "team_position_x", columnDefinition = "Decimal(10,2) default '000.00'")
    Long teamPositionX;

    @Column(name= "team_position_y", columnDefinition = "Decimal(10,2) default '000.00'")
    Long teamPositionY;

    @Column(name= "team_position_z", columnDefinition = "Decimal(10,2) default '000.00'")
    Long teamPositionZ;

    @ManyToOne
    Ship ship;

    @OneToMany(mappedBy="team")
    List<User> users =  new ArrayList<>();

    @OneToMany(mappedBy="team")
    @JsonManagedReference
    Set<AssetsByTeam> assets;





    public Team() {}

    public Team(Long teamId, String teamName, Long teamCurrentMoney, Long teamTimeGame, Long teamPositionX, Long teamPositionY, Long teamPositionZ, Ship ship, List<User> users, Set<AssetsByTeam> assets) {
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

    public Long getTeamPositionX() {
        return teamPositionX;
    }

    public void setTeamPositionX(Long teamPositionX) {
        this.teamPositionX = teamPositionX;
    }

    public Long getTeamPositionY() {
        return teamPositionY;
    }

    public void setTeamPositionY(Long teamPositionY) {
        this.teamPositionY = teamPositionY;
    }

    public Long getTeamPositionZ() {
        return teamPositionZ;
    }

    public void setTeamPositionZ(Long teamPositionZ) {
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

    public Long getTeamCurrentMoney() {
        return teamCurrentMoney;
    }

    public void setTeamCurrentMoney(Long teamCurrentMoney) {
        this.teamCurrentMoney = teamCurrentMoney;
    }

    public Long getTeamTimeGame() {
        return teamTimeGame;
    }

    public void setTeamTimeGame(Long teamTimeGame) {
        this.teamTimeGame = teamTimeGame;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
