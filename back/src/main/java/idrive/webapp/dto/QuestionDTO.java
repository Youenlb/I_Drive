package idrive.webapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class QuestionDTO {
    private Long id;
    private String question;
    private Long difficulty;
    private Long themeId;
    private List<AnswerDTO> answers;
}