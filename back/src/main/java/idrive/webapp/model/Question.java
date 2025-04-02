package idrive.webapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_question")
    private Long id;

    @Column(name = "question")
    private String question;

    @Column(name = "difficulty_question")
    private Long difficulte;

    @OneToOne
    @JoinColumn(name = "id_theme")
    private Theme theme;

    @OneToMany(mappedBy = "idQuestion", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;
}
