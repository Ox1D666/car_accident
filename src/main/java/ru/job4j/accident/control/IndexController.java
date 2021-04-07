package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        List<String> example = Arrays.asList("Max", "Bob", "Peter");
        model.addAttribute("users", example);
        return "index";
    }
}
