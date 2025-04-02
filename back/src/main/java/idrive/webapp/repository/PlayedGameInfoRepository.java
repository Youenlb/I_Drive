package idrive.webapp.repository;

import idrive.webapp.model.PlayedGamesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayedGameInfoRepository extends JpaRepository<PlayedGamesInfo, Long> {
}
