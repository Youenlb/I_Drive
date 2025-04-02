package idrive.webapp.controller;


import idrive.webapp.dto.InfoQADTO;
import idrive.webapp.model.Question;
import idrive.webapp.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/question")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/create")
    public Question createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    @GetMapping("/getAll")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @PutMapping("/update")
    public Boolean updateQuestion(@RequestBody Question question) {
        return questionService.updateQuestion(question);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteQuestion(@PathVariable Long id) {
        return questionService.deleteQuestion(id);
    }

    @GetMapping("/getByThemesAndDifficulty")
    public InfoQADTO getQandAByThemesAndDifficulty(@RequestParam String theme_ids, @RequestParam Integer difficulty, @RequestParam Integer nbQuestions) {
        List<Long> themeIds = Arrays.stream(theme_ids.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        return questionService.getQandAByThemesAndDifficulty(themeIds, difficulty, nbQuestions);
    }
}
