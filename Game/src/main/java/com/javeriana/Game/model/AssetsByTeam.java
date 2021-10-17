package com.javeriana.Game.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "assets_by_team")
public class AssetsByTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "assets_by_team_id")
    private Long assetsByTeamId;

    @Column(name= "asset_amount", columnDefinition = "integer default 0 ")
    private int assetAmount;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "team_id")
    private Team team;

    public AssetsByTeam() {
    }

    public AssetsByTeam(Long assetsByTeamId, int assetAmount, Asset asset, Team team) {
        this.assetsByTeamId = assetsByTeamId;
        this.assetAmount = assetAmount;
        this.asset = asset;
        this.team = team;
    }

    public Long getAssetsByTeamId() {
        return assetsByTeamId;
    }

    public void setAssetsByTeamId(Long assetsByTeamId) {
        this.assetsByTeamId = assetsByTeamId;
    }

    public int getAssetAmount() {
        return assetAmount;
    }

    public void setAssetAmount(int assetAmount) {
        this.assetAmount = assetAmount;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
