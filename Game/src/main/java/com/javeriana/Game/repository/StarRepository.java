package com.javeriana.Game.repository;
import java.util.List;

import com.javeriana.Game.model.Star;
import com.javeriana.Game.model.StarConected;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StarRepository  extends JpaRepository<Star, Long> {

	@Query(value = "SELECT * FROM star where star_id = ?1 ", nativeQuery = true)
	Star findByStarId(Long starId);


}
