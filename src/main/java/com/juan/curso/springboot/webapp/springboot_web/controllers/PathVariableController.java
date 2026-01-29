package com.juan.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @GetMapping("/baz/{message}") // esto es para que el nombre de la variable sea diferente al nombre del
                                  // parametro
    public ParamDto baz(@PathVariable(name = "message") String messageOtro) {

        ParamDto param = new ParamDto();
        param.setMessage(messageOtro);
        return param;
    }
}
