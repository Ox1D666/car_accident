package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        AccidentMem store = new AccidentMem();
        model.addAttribute("accidents", store.getAccidents().entrySet().toArray());
        return "index";
    }
}
