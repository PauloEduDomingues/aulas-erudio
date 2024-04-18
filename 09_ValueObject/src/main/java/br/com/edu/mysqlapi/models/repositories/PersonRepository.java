package br.com.edu.mysqlapi.models.repositories;

import br.com.edu.mysqlapi.models.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
