package idrive.webapp.service;

import idrive.webapp.dto.PlayedGameThemeDTO;
import idrive.webapp.mapper.PlayedGameThemeMapper;
import idrive.webapp.model.PlayedGameTheme;
import idrive.webapp.repository.PlayedGameThemeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayedGameThemeServiceImpl implements PlayedGameThemeService{
    private final PlayedGameThemeRepository playedGameThemeRepository;
    private final PlayedGameThemeMapper playedGameThemeMapper;


    /**
     * @param playedGameThemeDTO
     */
    @Override
    public void createPlayedGameTheme(PlayedGameThemeDTO playedGameThemeDTO) {
        PlayedGameTheme playedGameTheme = playedGameThemeMapper.toEntity(playedGameThemeDTO);
        playedGameThemeRepository.save(playedGameTheme);
    }

    /**
     * @return
     */
    @Override
    public List<PlayedGameThemeDTO> getAllPlayedGamesThemes() {
        return playedGameThemeMapper.toDtoList(playedGameThemeRepository.findAll());
    }

    /**
     * @param idGamePlayed
     * @return
     */
    @Override
    public List<PlayedGameThemeDTO> getPlayedGamesThemesByGameId(Integer idGamePlayed) {
        return playedGameThemeMapper.toDtoList(playedGameThemeRepository.findByIdGamePlayed_Id(idGamePlayed));
    }
}
