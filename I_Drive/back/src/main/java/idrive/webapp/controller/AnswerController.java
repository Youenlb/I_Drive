package idrive.webapp.controller;

import idrive.webapp.dto.AnswerDTO;
import idrive.webapp.service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
@AllArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping("/create")
    public AnswerDTO createAnswer(@RequestBody AnswerDTO answerDTO) {
        return answerService.createAnswer(answerDTO);
    }

    @GetMapping("/getAll")
    public List<AnswerDTO> getAllAnswers() {
        return answerService.getAllAnswers();
    }

    @PutMapping("/update/{id}")
    public AnswerDTO updateAnswer(@PathVariable Integer id, @RequestBody AnswerDTO answerDTO) {
        return answerService.updateAnswer(id, answerDTO);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAnswer(@PathVariable Integer id) {
        return answerService.deleteAnswer(id);
    }

}