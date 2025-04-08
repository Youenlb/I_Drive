package idrive.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@Getter
@Setter
@AllArgsConstructor
public class InfoQADTO {
    private Map nombreQuestionParDifficulte;
    private List<QuestionDTO> question;
}