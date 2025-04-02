package idrive.webapp.mapper;

import idrive.webapp.dto.PlayedGameThemeDTO;
import idrive.webapp.model.PlayedGameSolo;
import idrive.webapp.model.PlayedGameTheme;
import idrive.webapp.model.Theme;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayedGameThemeMapperImpl implements PlayedGameThemeMapper {

    @Override
    public PlayedGameThemeDTO toDto(PlayedGameTheme playedGameTheme) {
        PlayedGameThemeDTO dto = new PlayedGameThemeDTO();
        dto.setIdTheme(playedGameTheme.getIdTheme().getId());
        dto.setThemeName(playedGameTheme.getIdTheme().getTheme());
        return dto;
    }

    @Override
    public PlayedGameTheme toEntity(PlayedGameThemeDTO playedGameThemeDTO) {
        PlayedGameTheme entity = new PlayedGameTheme();
        PlayedGameSolo playedGame = new PlayedGameSolo();

        Theme theme = new Theme();
        theme.setId(playedGameThemeDTO.getIdTheme());
        theme.setTheme(playedGameThemeDTO.getThemeName());

        entity.setIdGamePlayed(playedGame);
        entity.setIdTheme(theme);
        return entity;
    }

    @Override
    public List<PlayedGameThemeDTO> toDtoList(List<PlayedGameTheme> playedGameThemes) {
        return playedGameThemes.stream().map(this::toDto).collect(Collectors.toList());
    }


}