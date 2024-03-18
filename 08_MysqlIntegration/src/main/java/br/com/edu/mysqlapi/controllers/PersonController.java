package br.com.edu.mysqlapi.controllers;

import br.com.edu.mysqlapi.models.entities.Person;
import br.com.edu.mysqlapi.models.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;
    @GetMapping
    public List<Person> findAll(){
        return personService.findAll();
    }
    @PostMapping
    public Person create(@RequestBody Person person){
        return personService.create(person);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public Person update(@RequestBody Person person){
        personService.update(person);
        return personService.update(person);
    }
}
