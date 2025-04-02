package idrive.webapp.repository;

import idrive.webapp.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Teams, Integer> {


    @Query("SELECT t FROM Teams t WHERE t.name = :name")
    Teams findByName(@Param("name") String name);

    @Query("SELECT t FROM Teams t ORDER BY t.gamesWon DESC ")
    List<Teams> findTop10Teams();
}