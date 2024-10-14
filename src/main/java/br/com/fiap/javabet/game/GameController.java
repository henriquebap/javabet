package br.com.fiap.javabet.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/games")
    public String getGames(Model model) {
        List<Game> games = gameRepository.findAll();
        model.addAttribute("games", games);
        return "games";
    }

    @GetMapping("/games/new")
    public String newGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "new_game";
    }

    @PostMapping("/games")
    public String saveGame(@ModelAttribute Game game) {
        gameRepository.save(game);
        return "redirect:/games";
    }
}