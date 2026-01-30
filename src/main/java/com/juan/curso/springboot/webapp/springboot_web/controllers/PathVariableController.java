package com.juan.curso.springboot.webapp.springboot_web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.curso.springboot.webapp.springboot_web.models.User;
import com.juan.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String name;
    // @Value("${config.message}")
    // private String message;
    @Value("${config.code}")
    private Integer code;

    @Value("${config.listOfValues}")
    private List<String> listOfValues;

    @Value("#{ '${config.listOfValues}'.toUpperCase().split(',')}")
    private List<String> valuesList;

    @Value("#{ '${config.listOfValues}'.toUpperCase()}")
    private String valuesString;

    @GetMapping("/baz/{message}") // esto es para que el nombre de la variable sea diferente al nombre del
                                  // parametro
    public ParamDto baz(@PathVariable(name = "message") String messageOtro) {

        ParamDto param = new ParamDto();
        param.setMessage(messageOtro);
        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        // hacer algo con el usuario save en la base de datos
        user.setName(user.getName().toUpperCase());
        user.setLastname(user.getLastname().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.message}") String message) {
        Map<String, Object> json = new HashMap<>();
        json.put("username", name);
        json.put("message", message);
        json.put("code", code);
        json.put("listOfValues", listOfValues);
        json.put("valuesList", valuesList);
        json.put("valuesString", valuesString);
        return json;
    }
}
