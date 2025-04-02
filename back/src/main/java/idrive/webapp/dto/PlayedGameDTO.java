package idrive.webapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlayedGameDTO {
    private Integer id;
    private Integer userId;
    private String username;
    private Integer difficulty;
    private Integer nbQuestions;
    private Integer score;
    private List<PlayedGameThemeDTO> playedGameThemes;
}