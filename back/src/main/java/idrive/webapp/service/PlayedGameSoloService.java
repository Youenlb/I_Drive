package idrive.webapp.service;

import idrive.webapp.dto.PlayedGameSoloDTO;

import java.util.List;

public interface PlayedGameSoloService {
    List<PlayedGameSoloDTO> getAllPlayedGameSolo();
    PlayedGameSoloDTO createPlayedGameSolo(PlayedGameSoloDTO playedGameSoloDTO);
    List<PlayedGameSoloDTO> getPlayedGameSoloByUserId(Integer idUser);
    List<PlayedGameSoloDTO> getMostRecentGames();


}
