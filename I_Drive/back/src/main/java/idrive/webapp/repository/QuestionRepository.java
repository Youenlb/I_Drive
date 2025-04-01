package idrive.webapp.repository;

import idrive.webapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByTheme_Id(Long themeId);
}
