package idrive.webapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDTO {
    Integer id;
    String answer;
    Boolean correct;
}
