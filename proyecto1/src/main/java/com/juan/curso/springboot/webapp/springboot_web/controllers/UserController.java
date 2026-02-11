package com.juan.curso.springboot.webapp.springboot_web.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.juan.curso.springboot.webapp.springboot_web.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Juan", "Florez");
        user.setEmail("juan@correo.com");
        model.addAttribute("title", "Hola Mundo Sprint boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        // List<User> users = Arrays.asList(
        // new User("Juan", "Florez"),
        // new User("Maria", "Perez", "Maria123@correo.com"),
        // new User("Pedro", "Gomez"),
        // new User("Ana", "Lopez", "Ana123@correo.com"),
        // new User("Luis", "Rodriguez", "Luis123@correo.com"));

        model.addAttribute("title", "Listado de usuarios");
        // model.addAttribute("users", users);
        return "list"; // si modifico el return tengo que modificar el nombre del html en
                       // resources/templates
    }

    @ModelAttribute("users")
    public List<User> userModel() {
        List<User> users = Arrays.asList(
                new User("Juan", "Florez"),
                new User("Maria", "Perez", "Maria123@correo.com"),
                new User("Pedro", "Gomez"),
                new User("Ana", "Lopez", "Ana123@correo.com"),
                new User("Luis", "Rodriguez", "Luis123@correo.com"));
        return users;
    }
}
