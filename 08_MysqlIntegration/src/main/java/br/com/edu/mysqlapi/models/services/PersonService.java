package br.com.edu.mysqlapi.models.services;

import br.com.edu.mysqlapi.models.entities.Person;
import br.com.edu.mysqlapi.models.exceptions.ResourceNotFound;
import br.com.edu.mysqlapi.models.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findById(long id){
        return personRepository.findById(id).orElseThrow(()-> new ResourceNotFound("No records found for this id"));
    }

    public Person create(Person person){
        return personRepository.save(person);
    }

    public void deleteById(long id){
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this id"));
        personRepository.delete(entity);
    }

    public Person update(Person person){
        var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFound("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return personRepository.save(person);
    }
}
