package idrive.webapp.controller;

import idrive.webapp.dto.PlayedGameThemeDTO;
import idrive.webapp.service.PlayedGameThemeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games_played_themes")
@AllArgsConstructor
public class PlayedGameThemeController {
    private final PlayedGameThemeService playedGameThemeService;

    @PostMapping("/create")
    public void createPlayedGameTheme(@RequestBody PlayedGameThemeDTO playedGameThemeDTO) {
        playedGameThemeService.createPlayedGameTheme(playedGameThemeDTO);
    }

    @GetMapping("/getAll")
    public List<PlayedGameThemeDTO> getAllPlayedGamesThemes() {
        return playedGameThemeService.getAllPlayedGamesThemes();
    }

    @GetMapping("/getByGameId/{gameId}")
    public List<PlayedGameThemeDTO> getPlayedGamesThemesByGameId(@PathVariable Integer gameId) {
        return playedGameThemeService.getPlayedGamesThemesByGameId(gameId);
    }







}
