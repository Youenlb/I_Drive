package idrive.webapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serial;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PlayedGamesInfoId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = -1067012855364650531L;
    @Column(name = "id_game_played", nullable = false)
    private Integer idGamePlayed;

    @Column(name = "difficulty", nullable = false)
    private Integer difficulty;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlayedGamesInfoId entity = (PlayedGamesInfoId) o;
        return Objects.equals(this.difficulty, entity.difficulty) &&
                Objects.equals(this.idGamePlayed, entity.idGamePlayed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(difficulty, idGamePlayed);
    }

}