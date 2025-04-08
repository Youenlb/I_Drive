package idrive.webapp.controller;

import idrive.webapp.dto.PlayedGameSoloDTO;
import idrive.webapp.service.PlayedGameSoloService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/played_game_solo")
@AllArgsConstructor
public class PlayedGameSoloController {
    private final PlayedGameSoloService playedGameSoloService;

    @PostMapping("/create")
    public PlayedGameSoloDTO createPlayedGameSolo(@RequestBody PlayedGameSoloDTO playedGameSoloDTO) {
            return playedGameSoloService.createPlayedGameSolo(playedGameSoloDTO);
    }

    @GetMapping("/getAll")
    public List<PlayedGameSoloDTO> getAllPlayedGameSolo() {
        return playedGameSoloService.getAllPlayedGameSolo();
    }

    @GetMapping("/getByUserId/{id}")
    public List<PlayedGameSoloDTO> getPlayedGameSoloByUserId(@PathVariable Integer id) {
        return playedGameSoloService.getPlayedGameSoloByUserId(id);
    }

    @GetMapping("/getMostRecentGames")
    public List<PlayedGameSoloDTO> getMostRecentGames() {
        return playedGameSoloService.getMostRecentGames();
    }
}

