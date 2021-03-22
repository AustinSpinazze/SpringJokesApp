package austinspinazze.springframework.springjokesapp.controllers;

import austinspinazze.springframework.springjokesapp.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {
    private final JokeService jokeService;

    //Because we only have single constructor in class no reason for @Autowired annotation
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    // When app makes call to page that is at "/" it will run this method
    @RequestMapping({"/", ""})
    public String showJoke(Model model) {
        model.addAttribute("joke",jokeService.getJoke());
        return "index";
    }
}
