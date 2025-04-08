package idrive.webapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "played_games_solo")
public class PlayedGameSolo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_game_played", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User idUser;

    @OneToMany(mappedBy = "idGamePlayed", fetch = FetchType.LAZY)
    private Collection<PlayedGamesInfo> playedGamesInfos;

    @OneToMany(mappedBy = "idGamePlayed", fetch = FetchType.LAZY)
    private List<PlayedGameTheme> playedGameThemes;

}