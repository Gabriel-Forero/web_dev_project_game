package com.javeriana.Game.repository;
import java.util.List;

import com.javeriana.Game.model.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PriceRepository  extends JpaRepository<Price, Long> {

    @Query(value = "SELECT * FROM price where planet_id = ?1 and asset_id = ?2", nativeQuery = true)
    Price findByPlanetAndAsset(Long planetId, Long assetId);

    @Query(value = "SELECT * FROM price where planet_id = ?1", nativeQuery = true)
    List<Price> findAllByPlanet(Long planetId);

    @Query(value = "SELECT * FROM price where price_id = ?1", nativeQuery = true)
    Price findByPriceId(Long priceId);
}
