package idrive.webapp.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "teams")
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_team", nullable = false)
    private Integer idTeam;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "games_won", nullable = false)
    private Integer gamesWon;

    public Teams(String nomEquipe, int i) {
        this.name = nomEquipe;
        this.gamesWon = i;
    }
}
