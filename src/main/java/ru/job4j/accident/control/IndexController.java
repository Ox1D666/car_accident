package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.repository.AccidentMem;

@Controller
public class IndexController {
    private AccidentMem store;

    public IndexController(AccidentMem accidentMem) {
        store = accidentMem;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", store.getAccidents());
        return "index";
    }
}
