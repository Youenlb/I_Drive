package idrive.webapp.service;

import idrive.webapp.dto.PlayedGameThemeDTO;

import java.util.List;

public interface PlayedGameThemeService {
    void createPlayedGameTheme(PlayedGameThemeDTO playedGameThemeDTO);
    List<PlayedGameThemeDTO> getAllPlayedGamesThemes();
    List<PlayedGameThemeDTO> getPlayedGamesThemesByGameId(Integer idGamePlayed);


}
