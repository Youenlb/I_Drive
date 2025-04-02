package idrive.webapp.service;

import idrive.webapp.dto.AnswerDTO;

import java.util.List;

public interface AnswerService {
    AnswerDTO createAnswer(AnswerDTO answerDTO);
    List<AnswerDTO> getAllAnswers();
    AnswerDTO updateAnswer(Integer id, AnswerDTO answerDTO);
    String deleteAnswer(Integer id);
}