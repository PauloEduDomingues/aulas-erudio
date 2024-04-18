package br.com.edu.mysqlapi.controllers;

import br.com.edu.mysqlapi.models.entities.Person;
import br.com.edu.mysqlapi.models.services.PersonService;
import br.com.edu.mysqlapi.vo.v1.PersonVO;
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
    public List<PersonVO> findAll(){
        return personService.findAll();
    }
    @PostMapping
    public PersonVO create(@RequestBody PersonVO person){
        return personService.create(person);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public PersonVO update(@RequestBody PersonVO person){
        personService.update(person);
        return personService.update(person);
    }
}
