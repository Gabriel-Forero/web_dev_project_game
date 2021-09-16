package com.javeriana.Game.repository;

import com.javeriana.Game.model.StarConected;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StarConectedRepository extends JpaRepository<StarConected, Long> {
    @Query(value = "SELECT * FROM star_conected where starFrom = ?1 and starTo = ?2 ", nativeQuery = true)
    StarConected findByStarFromAndStarTo(Long starFrom, Long starTo);

    @Query(value = "SELECT * FROM star_conected where team_id = ?1 ", nativeQuery = true)
    List<StarConected> findAllByStar(Long starConectedId);

}






   

