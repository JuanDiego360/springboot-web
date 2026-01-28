package com.juan.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.juan.curso.springboot.webapp.springboot_web.models.User;
import com.juan.curso.springboot.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping(path = "/details")
    public UserDto details() {

        UserDto userDto = new UserDto();
        User user = new User("Juan", "Florez");
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo Sprint boot");

        return userDto;
    }

    @GetMapping(path = "/details-map")
    public Map<String, Object> detailsMap() {
        User user = new User("Juan", "Florez");
        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo Sprint boot");
        body.put("user", user);
        return body;
    }
}
