package com.javeriana.Game.service;
import com.javeriana.Game.model.Planet;
import com.javeriana.Game.model.Star;
//import com.javeriana.Game.model.Team;
//import com.javeriana.Game.model.User;
import com.javeriana.Game.model.StarConected;
import com.javeriana.Game.repository.StarRepository;
//import com.javeriana.Game.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StarService {
    private final StarRepository starRepo;

    public  StarService(StarRepository starRepo) {
        this.starRepo=starRepo;
    }

    public Star addStar(Star star) {
        return starRepo.save(star);
    }

    public Star findByStarId(Long starId) {return starRepo.findByStarId(starId);}

    public List<Star> findAllStars(){
        return (List<Star>) starRepo.findAll();
    }

    public Star updateStar(Star star) {
        return starRepo.save(star);
    }

    public void deleteStarById(Long id) {
        starRepo.deleteById(id);
    }

    public Planet addPlanetToStar(Star star, Planet planet){
        star.getPlanets().add(planet);
        log.info("New planet named: {} with id {} added to the star {}",planet.getPlanetName(), String.valueOf(planet.getPlanetId()), star.getStarName());
        starRepo.save(star);
        return planet;
    }

    public List<Planet> getPlanetsFromStar(Star star){
        return star.getPlanets();
    }
}
