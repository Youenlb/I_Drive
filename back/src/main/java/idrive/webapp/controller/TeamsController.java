package idrive.webapp.controller;


import idrive.webapp.model.Teams;
import idrive.webapp.service.TeamsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@AllArgsConstructor
public class TeamsController {

    private final TeamsService teamsService;

    @PostMapping("/incrementscore")
    public Teams incrementeScore(@RequestBody String nomEquipe) {
        return teamsService.addWin(nomEquipe);
    }

    @GetMapping("/bestTeam")
    public List<Teams> bestTeams() {
        return teamsService.getTopTeams();
    }
}
