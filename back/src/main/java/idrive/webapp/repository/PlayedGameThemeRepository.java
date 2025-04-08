package idrive.webapp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import idrive.webapp.model.PlayedGameTheme;

import java.util.List;

@Repository
public interface PlayedGameThemeRepository extends JpaRepository<PlayedGameTheme, Long> {
    List<PlayedGameTheme> findByIdGamePlayed_Id(Integer idGamePlayed);
}
