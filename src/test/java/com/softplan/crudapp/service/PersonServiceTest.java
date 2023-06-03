package com.softplan.crudapp.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.softplan.crudapp.domain.Person;
import com.softplan.crudapp.dto.PersonDTO;
import com.softplan.crudapp.repository.PersonRepository;

@RunWith ( SpringRunner.class )
class PersonServiceTest {

    @Mock
    PersonRepository personRepository;


    @InjectMocks
    private PersonService personService;

    @BeforeEach
    public void setup () {
        MockitoAnnotations.openMocks( this );
    }

    @Test
    public void getAllPersons_test () {
        List <Person> persons = getListPersonEntityTest();
        Mockito.when( personRepository.findAll() ).thenReturn( persons );
        
        List<PersonDTO> result = personService.getAllPersons();
        
        assertEquals( persons.size() , result.size() );

        result.forEach( elementResult -> {
            Optional < Person > matchingPerson = persons.stream().filter( person -> person.getId() == elementResult.getId() ).findFirst();

            if ( matchingPerson.isPresent() ) {
                Person person = matchingPerson.get();

                assertEquals( elementResult.getId() , person.getId() );
                assertEquals( elementResult.getName() , person.getName() );
                assertEquals( elementResult.getAddress() , person.getAddress() );
                assertEquals( elementResult.getPosition() , person.getPosition() );
            }
        } );

    }

    @Test
    public void getPersonById_test () {

        Person person = createPerson( 1 );
        
        Optional<Person> optPerson = Optional.of( person );

        Mockito.when( personRepository.findById( person.getId() ) ).thenReturn( optPerson );

        PersonDTO result = personService.getPersonById( person.getId() );

        assertEquals( result.getId() , person.getId() );
        assertEquals( result.getName() , person.getName() );
        assertEquals( result.getAddress() , person.getAddress() );
        assertEquals( result.getPosition() , person.getPosition() );
    }

    @Test
    public void addPerson_test () {

        personService.addPerson( createPersonDTO( 1 ) );

        verify( personRepository , times( 1 ) ).save( any( Person.class ) );
    }

    @Test
    public void editPerson_test () {

        personService.editPerson( createPersonDTO( 1 ) );

        verify( personRepository , times( 1 ) ).save( any( Person.class ) );
    }

    @Test
    public void deletePerson_test () {

        Long id = 1L;

        personService.deletePerson( id );

        verify( personRepository , times( 1 ) ).deleteById( id );
    }

    private List < Person > getListPersonEntityTest () {

        List < Person > persons = new ArrayList < Person >();

        for ( int i = 1 ; i < 5 ; i++ ) {
            persons.add( createPerson( i ) );
        }

        return persons;
    }

    private Person createPerson ( int i ) {

        Person person = new Person();
        person.setId( Long.valueOf( i ) );
        person.setAddress( "Endereço de teste" );
        person.setName( "João_" + i );
        person.setPosition( "Desenvolvedor nível " + i );

        return person;
    }

    private PersonDTO createPersonDTO ( int i ) {

        PersonDTO person = new PersonDTO();
        person.setId( Long.valueOf( i ) );
        person.setAddress( "Endereço de teste" );
        person.setName( "João_" + i );
        person.setPosition( "Desenvolvedor nível " + i );

        return person;
    }
}
