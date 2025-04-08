package idrive.webapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "played_games_themes")
public class PlayedGameTheme {
    @EmbeddedId
    private PlayedGameThemeId id;

    @MapsId("idGamePlayed")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_game_played", nullable = false)
    private PlayedGameSolo idGamePlayed;

    @MapsId("idTheme")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_theme", nullable = false)
    private Theme idTheme;
}