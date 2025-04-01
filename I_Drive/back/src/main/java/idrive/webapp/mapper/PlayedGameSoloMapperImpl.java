package idrive.webapp.mapper;

import idrive.webapp.dto.PlayedGameSoloDTO;
import idrive.webapp.dto.PlayedGameThemeDTO;
import idrive.webapp.dto.PlayedGamesInfoDTO;
import idrive.webapp.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlayedGameSoloMapperImpl implements PlayedGameSoloMapper {
    @Override
    public PlayedGameSoloDTO toDTO(PlayedGameSolo playedGameSolo) {
        PlayedGameSoloDTO dto = new PlayedGameSoloDTO();
        dto.setIdGamePlayed(playedGameSolo.getId());
        dto.setIdUser(playedGameSolo.getIdUser().getId());
        dto.setUsername(playedGameSolo.getIdUser().getUsername());
        dto.setPlayedGameThemes(playedGameSolo.getPlayedGameThemes().stream()
                .map(this::toPlayedGameThemeDTO)
                .collect(Collectors.toList()));
        dto.setPlayedGamesInfos(playedGameSolo.getPlayedGamesInfos().stream()
                .map(this::toPlayedGamesInfoDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    @Override
    public PlayedGameThemeDTO toPlayedGameThemeDTO(PlayedGameTheme playedGamesTheme) {
        PlayedGameThemeDTO dto = new PlayedGameThemeDTO();
        dto.setIdTheme(playedGamesTheme.getId().getIdTheme());
        dto.setThemeName(playedGamesTheme.getIdTheme().getTheme());
        return dto;
    }
    
    @Override
    public PlayedGamesInfoDTO toPlayedGamesInfoDTO(PlayedGamesInfo playedGamesInfo) {
        PlayedGamesInfoDTO dto = new PlayedGamesInfoDTO();
        dto.setNbQuestions(playedGamesInfo.getNbQuestions());
        dto.setDifficulty(playedGamesInfo.getId().getDifficulty());
        dto.setScore(playedGamesInfo.getScore());
        return dto;
    }



    @Override
    public PlayedGameSolo toEntity(PlayedGameSoloDTO playedGameSoloDTO) {
        PlayedGameSolo entity = new PlayedGameSolo();
        entity.setId(playedGameSoloDTO.getIdGamePlayed());
        User user = new User();
        user.setId(playedGameSoloDTO.getIdUser());
        user.setUsername(playedGameSoloDTO.getUsername());
        entity.setIdUser(user);
        entity.setPlayedGamesInfos(playedGameSoloDTO.getPlayedGamesInfos().stream()
                .map(this::toPlayedGamesInfoEntity)
                .collect(Collectors.toList()));
        entity.setPlayedGameThemes(playedGameSoloDTO.getPlayedGameThemes().stream()
                .map(this::toPlayedGameThemeEntity)
                .collect(Collectors.toList()));
        return entity;
    }

    @Override
    public PlayedGamesInfo toPlayedGamesInfoEntity(PlayedGamesInfoDTO playedGamesInfoDTO) {
        PlayedGamesInfo entity = new PlayedGamesInfo();
        PlayedGamesInfoId id = new PlayedGamesInfoId();
        id.setDifficulty(playedGamesInfoDTO.getDifficulty());
        entity.setId(id);
        entity.setNbQuestions(playedGamesInfoDTO.getNbQuestions());
        entity.setScore(playedGamesInfoDTO.getScore());
        return entity;
    }

    @Override
    public PlayedGameTheme toPlayedGameThemeEntity(PlayedGameThemeDTO playedGameThemeDTO) {
        PlayedGameTheme entity = new PlayedGameTheme();
        PlayedGameThemeId id = new PlayedGameThemeId();
        id.setIdTheme(playedGameThemeDTO.getIdTheme());
        entity.setId(id);

        Theme theme = new Theme();
        theme.setId(playedGameThemeDTO.getIdTheme());
        theme.setTheme(playedGameThemeDTO.getThemeName());
        entity.setIdTheme(theme);

        return entity;
    }

    @Override
    public List<PlayedGameSoloDTO> toDTOList(List<PlayedGameSolo> playedGameSolos) {
        return playedGameSolos.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
