package idrive.webapp.mapper;

import idrive.webapp.dto.ThemeDTO;
import idrive.webapp.model.Theme;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ThemeMapperImpl implements ThemeMapper{


    @Override
    public ThemeDTO toDto(Theme theme) {
        ThemeDTO dto = new ThemeDTO();
        dto.setId(theme.getId());
        dto.setThemeName(theme.getTheme());
        return dto;
    }

    @Override
    public Theme toEntity(ThemeDTO themeDTO) {
        Theme theme = new Theme();
        theme.setId(themeDTO.getId());
        theme.setTheme(themeDTO.getThemeName());
        return theme;
    }


    @Override
    public List<ThemeDTO> toDtoList(List<Theme> themes) {
        return themes.stream().map(this::toDto).toList();

    }


}
