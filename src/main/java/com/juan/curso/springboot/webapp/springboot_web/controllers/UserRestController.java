package com.juan.curso.springboot.webapp.springboot_web.controllers;

// import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    @GetMapping(path = "/list")
    public List<User> list() {
        User user = new User("Juan", "Florez");
        User user2 = new User("Ana", "Gomez");
        User user3 = new User("Pedro", "Perez");
        User user4 = new User("Maria", "Lopez");
        User user5 = new User("Luis", "Rodriguez");

        List<User> users = Arrays.asList(user, user2, user3, user4, user5);
        // List<User> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);
        // users.add(user4);
        // users.add(user5);
        return users;
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
