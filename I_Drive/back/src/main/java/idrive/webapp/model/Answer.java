package idrive.webapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_answer", nullable = false)
    private Integer id;

    @Column(name = "answer", nullable = false, length = 1000)
    private String answer;

    @Column(name = "correct", nullable = false)
    private Boolean correct = false;

    @JoinColumn(name = "id_question")
    @Column(name = "id_question", nullable = false)
    private Integer idQuestion;
}