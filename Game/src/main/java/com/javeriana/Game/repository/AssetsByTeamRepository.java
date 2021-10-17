package com.javeriana.Game.repository;
import com.javeriana.Game.model.AssetsByTeam;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AssetsByTeamRepository extends JpaRepository<AssetsByTeam, Long>{

    @Query(value = "SELECT * FROM assets_by_team where assets_by_team_id = ?1 ", nativeQuery = true)
    AssetsByTeam findByAsset(Long assetsByTeamId);

    @Query(value = "SELECT * FROM assets_by_team where team_id = ?1 ", nativeQuery = true)
    List<AssetsByTeam> findAllByTeam(Long teamId);
}
