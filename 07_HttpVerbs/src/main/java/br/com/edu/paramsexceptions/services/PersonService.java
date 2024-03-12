package br.com.edu.paramsexceptions.services;

import br.com.edu.paramsexceptions.models.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() throws Exception{
        logger.info("Find all people!");
        List<Person> persons = new ArrayList<Person>();
        for (int i=0;i<8;i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }
    public Person findById(String id){
        logger.info("return one person");

        Person person =  new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Paulo");
        person.setLastName("Domingues");
        person.setAddress("São paulo - SP");
        person.setGender("male");
        return person;
    }

    public Person create(Person person){
         logger.info("creating person");
         return person;
    }

    public Person update(Person person){
        logger.info("updating person");
        return person;
    }

    public void deleting(long id){
        logger.info("deleting person");
    }

    public Person mockPerson(int i){
        logger.info("return one person");

        Person person =  new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name: " + i);
        person.setLastName("Last name:" + i);
        person.setAddress("Address: " + i);
        person.setGender("Gender: " + i);
        return person;
    }

}
