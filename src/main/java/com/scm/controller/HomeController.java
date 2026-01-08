package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name", "Vishnu Thakur");
        model.addAttribute("github", "https://github.com/Vishnu22632/Smart-Contact-Manager");
        return "home";
    }


}
