package idrive.webapp.service;


import idrive.webapp.model.Teams;
import idrive.webapp.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamsService {

    private final TeamRepository teamRepository;

    @Override
    public Teams addWin(String nomEquipe) {
        Teams teamsEnBase = teamRepository.findByName(nomEquipe);
        if (teamsEnBase != null) {
            teamsEnBase.setGamesWon(teamsEnBase.getGamesWon() + 1);
            teamRepository.save(teamsEnBase);
        }
        else{
            teamsEnBase = new Teams(nomEquipe,1);
            teamRepository.save(teamsEnBase);
        }
        return teamsEnBase;
    }

    @Override
    public List<Teams> getTopTeams() {
        return teamRepository.findTop10Teams();
    }
}
