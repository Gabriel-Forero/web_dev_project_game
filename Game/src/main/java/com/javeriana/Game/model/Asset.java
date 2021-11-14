package com.javeriana.Game.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "asset")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "asset_id")
    private Long assetId;

    @Column(name= "asset_name")
    private String assetName;

    @Column(name= "asset_volume", columnDefinition = "Decimal(10,2) default '000.00'")
    private Long assetVolume;

    @OneToMany(mappedBy = "asset")
    @JsonIgnore
    Set<AssetsByTeam> teams;

    @OneToMany(mappedBy = "asset")
    @JsonIgnore
    private List<Price> planets = new ArrayList<>();

    public Asset() {}

    public Asset(Long assetId, String assetName, Long assetVolume, Set<AssetsByTeam> teams, List<Price> planets) {
        this.assetId = assetId;
        this.assetName = assetName;
        this.assetVolume = assetVolume;
        this.teams = teams;
        this.planets = planets;
    }

    public Set<AssetsByTeam> getTeams() {
        return teams;
    }

    public void setTeams(Set<AssetsByTeam> teams) {
        this.teams = teams;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public Long getAssetVolume() {
        return assetVolume;
    }

    public void setAssetVolume(Long assetVolume) {
        this.assetVolume = assetVolume;
    }



    public List<Price> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Price> planets) {
        this.planets = planets;
    }
}
