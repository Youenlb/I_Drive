package idrive.webapp.service;

import idrive.webapp.model.Teams;

import java.util.List;

public interface TeamsService {

    Teams addWin(String nomEquipe);
    List<Teams> getTopTeams();
}
