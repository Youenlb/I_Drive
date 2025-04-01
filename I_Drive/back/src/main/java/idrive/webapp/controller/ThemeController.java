package idrive.webapp.controller;

import idrive.webapp.dto.ThemeDTO;
import idrive.webapp.service.ThemeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/themes")
public class ThemeController {
    private final ThemeService themeService;

    @PostMapping("/create")
    public void createTheme(@RequestBody ThemeDTO themeDTO) {
        themeService.createTheme(themeDTO);
    }

    @GetMapping("/getAll")
    public List<ThemeDTO> getAllThemes() {
        return themeService.getAllThemes();
    }

    @GetMapping("/getById/{id}")
    public ThemeDTO getThemeById(@PathVariable Integer id) {
        return themeService.getThemeById(id);
    }
}
