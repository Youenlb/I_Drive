package idrive.webapp.service;

import idrive.webapp.dto.ThemeDTO;
import idrive.webapp.mapper.ThemeMapper;
import idrive.webapp.repository.ThemeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ThemeServiceImpl implements ThemeService{
    private final ThemeRepository themeRepository;
    private final ThemeMapper themeMapper;

    @Override
    public void createTheme(ThemeDTO theme) {
        themeRepository.save(themeMapper.toEntity(theme));
    }

    @Override
    public List<ThemeDTO> getAllThemes() {
        return themeMapper.toDtoList(themeRepository.findAll());
    }

    @Override
    public ThemeDTO getThemeById(Integer id) {
        return themeMapper.toDto(themeRepository.findById(id).orElse(null));
    }
}
