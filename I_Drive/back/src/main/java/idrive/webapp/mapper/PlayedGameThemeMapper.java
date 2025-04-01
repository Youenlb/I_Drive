package idrive.webapp.mapper;

import idrive.webapp.dto.PlayedGameThemeDTO;
import idrive.webapp.model.PlayedGameTheme;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayedGameThemeMapper {

        @Mapping(source = "idGamePlayed.id", target = "idGamePlayed")
        @Mapping(source = "idTheme.id", target = "idTheme")
        @Mapping(source = "idTheme", target = "theme")
        PlayedGameThemeDTO toDto(PlayedGameTheme playedGameTheme);

        @Mapping(source = "idGamePlayed", target = "idGamePlayed.id")
        @Mapping(source = "idTheme", target = "idTheme.id")
        @Mapping(source = "theme", target = "idTheme")
        PlayedGameTheme toEntity(PlayedGameThemeDTO playedGameThemeDTO);

        List<PlayedGameThemeDTO> toDtoList(List<PlayedGameTheme> playedGameThemes);

}