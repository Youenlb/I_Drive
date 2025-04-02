package idrive.webapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PlayedGameThemeId implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 2070834886663782955L;
    @Column(name = "id_game_played", nullable = false)
    private Integer idGamePlayed;


    @Column(name = "id_theme", nullable = false)
    private Long idTheme;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayedGameThemeId entity = (PlayedGameThemeId) o;
        return Objects.equals(this.idGamePlayed, entity.idGamePlayed) &&
                Objects.equals(this.idTheme, entity.idTheme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGamePlayed, idTheme);
    }

}