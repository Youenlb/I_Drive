package idrive.webapp.mapper;

import idrive.webapp.dto.PlayedGameSoloDTO;
import idrive.webapp.dto.PlayedGameThemeDTO;
import idrive.webapp.dto.PlayedGamesInfoDTO;
import idrive.webapp.model.PlayedGameTheme;
import idrive.webapp.model.PlayedGamesInfo;
import org.mapstruct.Mapper;
import idrive.webapp.model.PlayedGameSolo;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayedGameSoloMapper {

    @Mapping(source = "id", target = "idGamePlayed")
    @Mapping(source = "idUser", target = "idUser")
    @Mapping(source = "username", target = "username")
    PlayedGameSoloDTO toDTO(PlayedGameSolo playedGameSolo);

    @Mapping(source = "idGamePlayed", target = "id")
    @Mapping(source = "idUser", target = "idUser")
    @Mapping(source = "username", target = "username")
    PlayedGameSolo toEntity(PlayedGameSoloDTO playedGameSoloDTO);

    List<PlayedGameSoloDTO> toDTOList(List<PlayedGameSolo> playedGameSolos);

    PlayedGamesInfoDTO toPlayedGamesInfoDTO(PlayedGamesInfo playedGamesInfo);

    PlayedGameThemeDTO toPlayedGameThemeDTO(PlayedGameTheme playedGamesTheme);

    PlayedGameTheme toPlayedGameThemeEntity(PlayedGameThemeDTO playedGameThemeDTO);

    PlayedGamesInfo toPlayedGamesInfoEntity(PlayedGamesInfoDTO playedGamesInfoDTO);
}

