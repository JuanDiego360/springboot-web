package com.juan.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.juan.curso.springboot.webapp.springboot_web.models.User;


@RestController
@RequestMapping("/api")
public class UserRestController {
    
    @GetMapping(path="/details")
    public Map<String, Object> details() {
        User user = new User("Juan","Florez");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Sprint boot");
        body.put("user", user);
        return body;
    }
}
