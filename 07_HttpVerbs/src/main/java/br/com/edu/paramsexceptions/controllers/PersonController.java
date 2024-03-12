package br.com.edu.paramsexceptions.controllers;

import br.com.edu.paramsexceptions.models.Person;
import br.com.edu.paramsexceptions.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping()
    public List<Person> findByAll() throws Exception {
        try {
            return personService.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable String id) throws Exception{
        return personService.findById(id);
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return personService.create(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable long id, @RequestBody Person person){
        //procure a person pelo Id  para fazer a alteracao
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        personService.deleting(id);
    }
}
