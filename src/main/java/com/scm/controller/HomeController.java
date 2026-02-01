package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.enums.Providers;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("name", "Vishnu Thakur");
        model.addAttribute("github", "https://github.com/Vishnu22632/Smart-Contact-Manager");
        return "home";
    }

    @RequestMapping("/services")
    public String servicesPage() {
        return "services";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @RequestMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @RequestMapping("/login")
    public String logIn() {
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @RequestMapping(value = "/do_register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm, HttpSession session) {
        System.out.println("Processing Register form !!!");

        System.out.println(userForm);

        // fetch form data
        // UserForm

        // User user = new User();
        // validate form data
        // save to database

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());

        userService.saveUser(user);

        // message = "Sugisteration Successful "

        Message message = Message.builder().content("Registration Successful").type(MessageType.blue).build();

        session.setAttribute("message", message);

        // redirection login page

        return "redirect:/register";
    }

}
