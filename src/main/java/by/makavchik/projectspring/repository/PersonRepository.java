package by.makavchik.projectspring.repository;

import by.makavchik.projectspring.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
    Optional<Person> findAllByID(Long personaID);
}
