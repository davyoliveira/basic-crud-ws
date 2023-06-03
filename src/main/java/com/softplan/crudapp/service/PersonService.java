package com.softplan.crudapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softplan.crudapp.domain.Person;
import com.softplan.crudapp.dto.PersonDTO;
import com.softplan.crudapp.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List < PersonDTO > getAllPersons () {
        List < Person > persons = personRepository.findAll();
        return PersonDTO.entityListToDtoList( persons );
    }

    public PersonDTO getPersonById ( Long id ) {

        Optional < Person > optPerson = personRepository.findById( id );

        return PersonDTO.entityToDto( optPerson.get() );
    }

    public void addPerson ( PersonDTO dto ) {
        
        Person person = PersonDTO.dtoToEntity(dto);
        
        personRepository.save( person );
    }

    public void editPerson ( PersonDTO dto ) {

        Person person = PersonDTO.dtoToEntity( dto );

        personRepository.save( person );
    }

    public void deletePerson ( Long id ) {

        personRepository.deleteById( id );
    }
}
