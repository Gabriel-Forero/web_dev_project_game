package com.javeriana.Game.service;
import com.javeriana.Game.dto.AddPlanetDTO;
import com.javeriana.Game.model.Planet;
import com.javeriana.Game.model.Star;
import com.javeriana.Game.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    private final PlanetRepository planetRepo;

    public  PlanetService(PlanetRepository planetRepo) {
        this.planetRepo=planetRepo;
    }

    public Planet addPlanet(AddPlanetDTO planet) {

        Planet newPlanet = new Planet();
        newPlanet.setPlanetName(planet.getPlanetName());
        newPlanet.setStar(planet.getStar());
        return planetRepo.save(newPlanet);
    }

    public List<Planet> findAllPlanets(){
        return (List<Planet>) planetRepo.findAll();
    }

    public Planet updatePlanet(Planet planet) {
        return planetRepo.save(planet);
    }

    public void deletePlanetById(Long id) {
        planetRepo.deleteById(id);
    }

    public Planet findPlanetById(Long planetId) {return planetRepo.findPlanetById(planetId);}


}
