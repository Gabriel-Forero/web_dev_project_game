package com.javeriana.Game.service;
import com.javeriana.Game.model.Ship;
import com.javeriana.Game.model.Team;
import com.javeriana.Game.repository.ShipRepository;
//import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

//@Slf4j
@Service
public class ShipService {
    private final ShipRepository shipRepo;

    public  ShipService(ShipRepository shipRepo) {
        this.shipRepo=shipRepo;
    }

    public Ship addShip(Ship ship) {
        return shipRepo.save(ship);
    }

    public List<Ship> findAllShips(){
        return shipRepo.findAll();
    }

    public Ship updateShip(Ship ship) {
        return shipRepo.save(ship);
    }

    public void deleteShipById(Long id) {
        shipRepo.deleteById(id);
    }

    public Ship findByShipId(Long shipId){
        return shipRepo.findByShipId(shipId);
    }

    public Team addTeam(Ship ship, Team team){
        ship.getTeams().add(team);
        //log.info("New team named: {} with id {} added to the ship {}",team.getTeamName(), String.valueOf(team.getTeamId()), ship.getShipType());
        shipRepo.save(ship);
        return team;
    }


}
