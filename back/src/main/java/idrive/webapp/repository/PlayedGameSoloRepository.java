package idrive.webapp.repository;

import idrive.webapp.model.PlayedGameSolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PlayedGameSoloRepository extends JpaRepository<PlayedGameSolo, Integer> {
    List<PlayedGameSolo> findByIdUser_Id(Integer idUserId);
    List<PlayedGameSolo> findTop10ByOrderByIdDesc();
}
