package com.javeriana.Game.repository;
import com.javeriana.Game.model.Planet;
import com.javeriana.Game.model.Star;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlanetRepository  extends JpaRepository<Planet, Long> {

    @Query(value = "SELECT * FROM planet where planet_id = ?1 ", nativeQuery = true)
    Planet findPlanetById(Long planetId);

}
