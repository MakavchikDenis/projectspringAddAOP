package by.makavchik.projectspring.service;


import by.makavchik.projectspring.dto.PersonDto;
import by.makavchik.projectspring.entity.Person;
import by.makavchik.projectspring.exception.ResourceNotFoundException;
import by.makavchik.projectspring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.lang.Long;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }
    public void addNewPerson(Person person){
        personRepository.save(person);
    }
    public void deletePerson(Person person ){
        personRepository.delete(person);
    }
    public void editPerson(Person person, Long id){ person.setID(id); personRepository.save(person); }
    public Person getById(Long id) throws ResourceNotFoundException
    {
        return personRepository.findAllByID(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

}

