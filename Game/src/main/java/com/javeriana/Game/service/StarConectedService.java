
package com.javeriana.Game.service;
import com.javeriana.Game.model.StarConected;

import com.javeriana.Game.repository.StarConectedRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StarConectedService {
    private final StarConectedRepository starConectedRepository;

    public StarConectedService(StarConectedRepository starConectedRepository) {
        this.starConectedRepository = starConectedRepository;
    }

    public StarConected addConnection(StarConected starConected) {
        return starConectedRepository.save(starConected);
    }

    public List<StarConected> findAllStarConnected() {
        return (List<StarConected>) starConectedRepository.findAll();
    }

    public List<StarConected> findNearestStarsBySatrId(Long starId){
        return starConectedRepository.findNearestStarsBySatrId(starId);
    }

}





    

    






