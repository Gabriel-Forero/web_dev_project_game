package com.javeriana.Game.repository;
import com.javeriana.Game.model.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PriceRepository  extends CrudRepository<Price, Long> {

    @Query(value = "SELECT * FROM price where planet_id = ?1 and asset_id = ?2 ", nativeQuery = true)
    Price findByPlanetAndAsset(Long planetId, Long assetId);
}
