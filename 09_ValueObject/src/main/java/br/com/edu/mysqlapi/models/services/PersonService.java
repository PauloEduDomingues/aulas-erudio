package br.com.edu.mysqlapi.models.services;

import br.com.edu.mysqlapi.models.entities.Person;
import br.com.edu.mysqlapi.models.exceptions.ResourceNotFound;
import br.com.edu.mysqlapi.models.mapper.DozerMapper;
import br.com.edu.mysqlapi.models.repositories.PersonRepository;
import br.com.edu.mysqlapi.vo.v1.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<PersonVO> findAll(){
        return DozerMapper.parseListObject(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(long id){
        var entity = personRepository.findById(id).orElseThrow(()-> new ResourceNotFound("No records found for this id"));
        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person){
        var entity = DozerMapper.parseObject(person, Person.class);
        return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }

    public void deleteById(long id){
        var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFound("No records found for this id"));
        personRepository.delete(entity);
    }

    public PersonVO update(PersonVO person){
        var entity = personRepository.findById(person.getId()).orElseThrow(() -> new ResourceNotFound("No records found for this id"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
    }
}
