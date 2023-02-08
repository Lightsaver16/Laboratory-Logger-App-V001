package com.LaboratoryApp.labappv001.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("message", "THYMELEAF APP");

        return "home";
    }

}
