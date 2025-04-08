package idrive.webapp.service;

import idrive.webapp.dto.InfoQADTO;
import idrive.webapp.model.Question;

import java.util.List;

public interface QuestionService {

    Question createQuestion(Question question);

    List<Question> getAllQuestions();

    Boolean updateQuestion(Question question);

    boolean deleteQuestion(Long id);

    InfoQADTO getQandAByThemesAndDifficulty(List<Long> theme_ids, Integer difficulty, Integer nbQuestions);

}
