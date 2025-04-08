package idrive.webapp.service;

import idrive.webapp.dto.ThemeDTO;

import java.util.List;

public interface ThemeService {
    void createTheme(ThemeDTO themeDTO);

    List<ThemeDTO> getAllThemes();

    ThemeDTO getThemeById(Integer id);
}
