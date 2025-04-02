package idrive.webapp.service;

import idrive.webapp.dto.PlayedGameSoloDTO;
import idrive.webapp.exception.IdUserNotExistException;
import idrive.webapp.exception.NoGamesPlayedForUserException;
import idrive.webapp.mapper.PlayedGameSoloMapper;
import idrive.webapp.model.PlayedGameSolo;
import idrive.webapp.model.Theme;
import idrive.webapp.repository.PlayedGameInfoRepository;
import idrive.webapp.repository.PlayedGameSoloRepository;
import idrive.webapp.repository.PlayedGameThemeRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayedGameSoloServiceImpl implements PlayedGameSoloService {
    private final PlayedGameSoloRepository playedGameSoloRepository;
    private final PlayedGameInfoRepository playedGameInfoRepository;
    private final PlayedGameThemeRepository playedGameThemeRepository;
    private final PlayedGameSoloMapper playedGameSoloMapper;

    @Override
    public List<PlayedGameSoloDTO> getAllPlayedGameSolo() {
        List<PlayedGameSolo> playedGameSolos = playedGameSoloRepository.findAll();
        return playedGameSoloMapper.toDTOList(playedGameSolos);
    }


    @Override
    public PlayedGameSoloDTO createPlayedGameSolo(PlayedGameSoloDTO playedGameSoloDTO) {
        try {
            PlayedGameSolo playedGameSolo = playedGameSoloMapper.toEntity(playedGameSoloDTO);
            playedGameSoloRepository.save(playedGameSolo);

            // Save the PlayedGamesInfo entities
            playedGameSolo.getPlayedGamesInfos().forEach(info -> {
                info.setIdGamePlayed(playedGameSolo);
                playedGameInfoRepository.save(info);
            });

            playedGameSolo.getPlayedGameThemes().forEach(playedGameTheme -> {
                playedGameTheme.setIdGamePlayed(playedGameSolo);
                Theme theme = new Theme();
                theme.setId(playedGameTheme.getId().getIdTheme());
                playedGameThemeRepository.save(playedGameTheme);
            });

            return playedGameSoloMapper.toDTO(playedGameSolo);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("FOREIGN KEY (`id_user`)")) {
                throw new IdUserNotExistException("User with id " + playedGameSoloDTO.getIdUser() + " does not exist");
            }
            throw e;
        }
    }

    @Override
    public List<PlayedGameSoloDTO> getPlayedGameSoloByUserId(Integer idUser) {
        List<PlayedGameSolo> playedGameSolos = playedGameSoloRepository.findByIdUser_Id(idUser);
        if (playedGameSolos.isEmpty()) {
            throw new NoGamesPlayedForUserException("No games played by user with id " + idUser);
        }
        return playedGameSoloMapper.toDTOList(playedGameSolos);
    }

    @Override
    public List<PlayedGameSoloDTO> getMostRecentGames() {
        List<PlayedGameSolo> playedGameSolos = playedGameSoloRepository.findTop10ByOrderByIdDesc();
        return playedGameSoloMapper.toDTOList(playedGameSolos);
    }
}
