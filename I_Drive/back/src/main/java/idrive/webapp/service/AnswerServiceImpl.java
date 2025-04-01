package idrive.webapp.service;

import idrive.webapp.dto.AnswerDTO;
import idrive.webapp.mapper.AnswerMapper;
import idrive.webapp.model.Answer;
import idrive.webapp.repository.AnswerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    @Transactional
    @Override
    public AnswerDTO createAnswer(AnswerDTO answerDTO) {
        Answer answer = answerMapper.toEntity(answerDTO);
        answer = answerRepository.save(answer);
        return answerMapper.toDto(answer);
    }

    @Override
    public List<AnswerDTO> getAllAnswers() {
        return answerRepository.findAll().stream()
                .map(answerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AnswerDTO updateAnswer(Integer id, AnswerDTO answerDTO) {
        Answer answer = answerRepository.findById(id).orElseThrow(() -> new RuntimeException("Answer not found"));
        answer.setAnswer(answerDTO.getAnswer());
        answer.setCorrect(answerDTO.getCorrect());
        answer = answerRepository.save(answer);
        return answerMapper.toDto(answer);
    }

    @Override
    public String deleteAnswer(Integer id) {
        answerRepository.deleteById(id);
        return "Answer deleted successfully";
    }


}