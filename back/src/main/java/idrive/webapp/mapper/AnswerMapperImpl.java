package idrive.webapp.mapper;

import idrive.webapp.dto.AnswerDTO;
import idrive.webapp.model.Answer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public AnswerDTO toDto(Answer answer) {
        if (answer == null) {
            return null;
        }

        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setId(answer.getId());
        answerDTO.setAnswer(answer.getAnswer());
        answerDTO.setCorrect(answer.getCorrect());

        return answerDTO;
    }

    @Override
    public Answer toEntity(AnswerDTO answerDTO) {
        if (answerDTO == null) {
            return null;
        }

        Answer answer = new Answer();
        answer.setId(answerDTO.getId());
        answer.setAnswer(answerDTO.getAnswer());
        answer.setCorrect(answerDTO.getCorrect());


        return answer;
    }

    @Override
    public List<AnswerDTO> toDtoList(List<Answer> answers) {
        if (answers == null) {
            return null;
        }

        return answers.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}