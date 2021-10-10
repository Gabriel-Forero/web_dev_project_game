package com.javeriana.Game.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "price")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "price_id")
    private Long priceId;

    @Column(name= "asset_amount", columnDefinition = "integer default 0 ")
    private int assetAmount;

    @Column(name= "demand_factor", columnDefinition = "Decimal(10,2) default '000.00'")
    private Long demandFactor;

    @Column(name= "suply_factor", columnDefinition = "Decimal(10,2) default '000.00'")
    private Long supplyFactor;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "asset_id")
    private Asset asset;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "planet_id")
    private Planet planet;

    public Price() {}

    public Price(Long priceId, int assetAmount, Long demandFactor, Long supplyFactor, Asset asset, Planet planet) {
        this.priceId = priceId;
        this.assetAmount = assetAmount;
        this.demandFactor = demandFactor;
        this.supplyFactor = supplyFactor;
        this.asset = asset;
        this.planet = planet;
    }


    public Long getPriceId() {
        return priceId;
    }

    public void setPriceId(Long priceId) {
        this.priceId = priceId;
    }

    public int getAssetAmount() {
        return assetAmount;
    }

    public void setAssetAmount(int assetAmount) {
        this.assetAmount = assetAmount;
    }

    public Long getDemandFactor() {
        return demandFactor;
    }

    public void setDemandFactor(Long demandFactor) {
        this.demandFactor = demandFactor;
    }

    public Long getSupplyFactor() {
        return supplyFactor;
    }

    public void setSupplyFactor(Long supplyFactor) {
        this.supplyFactor = supplyFactor;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }


}
