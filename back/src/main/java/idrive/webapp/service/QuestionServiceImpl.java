package idrive.webapp.service;

import idrive.webapp.dto.InfoQADTO;
import idrive.webapp.dto.QuestionDTO;
import idrive.webapp.mapper.AnswerMapper;
import idrive.webapp.model.Answer;
import idrive.webapp.model.Question;
import idrive.webapp.repository.AnswerRepository;
import idrive.webapp.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;

    @Override
    public Question createQuestion(Question question) {
        List<Answer> answers = question.getAnswers();
        question.setAnswers(null);
        Question savedQuestion = questionRepository.save(question);
        for (Answer answer : answers) {
            answer.setIdQuestion(savedQuestion.getId().intValue());
            answerRepository.save(answer);
        }
        return savedQuestion;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Boolean updateQuestion(Question question) {
        Optional<Question> questionPotentiel = questionRepository.findById(question.getId().intValue());
        if (questionPotentiel.isPresent()){
            questionRepository.save(question);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteQuestion(Long id) {
        Optional<Question> questionPotentiel = questionRepository.findById(id.intValue());
        if (questionPotentiel.isPresent()){
            questionRepository.delete(questionPotentiel.get());
            return true;
        }
        return false;
    }

    @Override
    public InfoQADTO getQandAByThemesAndDifficulty(List<Long> theme_ids, Integer difficulty, Integer nbQuestions) {
        List<Question> questions = questionRepository.findAll();

        //Filtre des questions
        questions = questions.stream()
                .filter(question -> question.getDifficulte() <= difficulty && theme_ids.contains(question.getTheme().getId()))
                .collect(Collectors.toList());

        // Mélange les questions
        Collections.shuffle(questions);

        // Retourne le nombre de questions demandées
        List<QuestionDTO> listeRetour = questions.stream()
                .limit(nbQuestions)
                .map(this::mapToQuestionDTO)
                .toList();

        return new InfoQADTO(listeRetour.stream().collect(Collectors.groupingBy(
                QuestionDTO::getDifficulty, // Clé : difficulté
                Collectors.counting() // Valeur : nombre d'éléments
        )),listeRetour);
    }

    private QuestionDTO mapToQuestionDTO(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setQuestion(question.getQuestion());
        questionDTO.setDifficulty(question.getDifficulte());
        questionDTO.setThemeId(question.getTheme().getId());
        questionDTO.setAnswers(answerMapper.toDtoList(question.getAnswers()));
        return questionDTO;
    }
}
