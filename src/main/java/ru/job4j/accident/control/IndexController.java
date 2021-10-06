package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentMem;

import java.util.List;

@Controller
public class IndexController {
    AccidentMem store = new AccidentMem();
    List<Accident> result =  store.getAccidents();
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", result);
        return "index";
    }
}
