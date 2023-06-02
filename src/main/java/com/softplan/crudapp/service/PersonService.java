package com.softplan.crudapp.service;

import java.util.List;

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
        return PersonDTO.entityListToDtoList( personRepository.findAll() );
    }

    public PersonDTO getPersonById ( Long id ) {
        return PersonDTO.entityToDto( personRepository.findById( id ).get() );
    }

    public void addPerson ( PersonDTO dto ) {
        
        Person person = PersonDTO.dtoToEntity(dto);
        
        personRepository.save( person );
    }

    public void editPerson ( PersonDTO dto ) {

        Person person = PersonDTO.dtoToEntity( dto );

        // verificar o que acontece aqui

        personRepository.save( person );
    }

    public void deletePerson ( Long id ) {

        // verificar auditoria aqui

        personRepository.deleteById( id );
    }
}
