package idrive.webapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlayedGameSoloDTO {
    private Integer idGamePlayed;
    private Integer idUser;
    private String username;
    private List<PlayedGamesInfoDTO> playedGamesInfos;
    private List<PlayedGameThemeDTO> playedGameThemes;
}
