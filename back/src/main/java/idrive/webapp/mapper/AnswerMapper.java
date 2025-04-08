package idrive.webapp.mapper;

import idrive.webapp.dto.AnswerDTO;
import idrive.webapp.model.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "answer", target = "answer")
    @Mapping(source = "correct", target = "correct")
    @Mapping(source = "idQuestion.id", target = "idQuestion")
    AnswerDTO toDto(Answer answer);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "answer", target = "answer")
    @Mapping(source = "correct", target = "correct")
    @Mapping(source = "idQuestion", target = "idQuestion.id")
    Answer toEntity(AnswerDTO answerDTO);

    List<AnswerDTO> toDtoList(List<Answer> answers);
}