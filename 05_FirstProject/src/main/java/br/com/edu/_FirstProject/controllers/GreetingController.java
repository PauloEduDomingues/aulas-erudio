package br.com.edu._FirstProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private String template = " Hello %s";

    //biblioteca que gera aumenta o contador toda vez que chamada dentro da mesma execução
    private AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public String greetingWithName(@RequestParam(name = "name", defaultValue = "World") String name){
        return String.valueOf(counter.incrementAndGet()) + String.format(template, name);
    }

}
