package com.javeriana.Game.repository;
import com.javeriana.Game.model.Planet;
import com.javeriana.Game.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository  extends JpaRepository<Team, Long> {
	@Query(value = "SELECT * FROM team where team_id = ?1 ", nativeQuery = true)
	Team findByTeamId(Long teamId);
}
