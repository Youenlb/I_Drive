package idrive.webapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "played_games_info")
public class PlayedGamesInfo {
    @EmbeddedId
    private PlayedGamesInfoId id;

    @MapsId("idGamePlayed")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_game_played", nullable = false)
    private PlayedGameSolo idGamePlayed;

    @Column(name = "nb_questions", nullable = false)
    private Integer nbQuestions;

    @Column(name = "score", nullable = false)
    private Integer score;

}