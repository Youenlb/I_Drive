package idrive.webapp.mapper;

import idrive.webapp.dto.ThemeDTO;
import idrive.webapp.model.Theme;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThemeMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "theme", target = "theme")
    ThemeDTO toDto(Theme theme);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "theme", target = "theme")
    Theme toEntity(ThemeDTO themeDTO);

    List<ThemeDTO> toDtoList(List<Theme> themes);

}
