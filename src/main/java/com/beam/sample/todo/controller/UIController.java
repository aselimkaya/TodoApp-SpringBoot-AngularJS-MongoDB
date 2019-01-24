package com.beam.sample.todo.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UIController {
    @GetMapping(value = {"/", "/task/{id}"}, produces = MediaType.TEXT_HTML_VALUE)
    public String index(){
        return "index";
    }
}