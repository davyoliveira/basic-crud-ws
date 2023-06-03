package com.softplan.crudapp.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.softplan.crudapp.dto.PersonDTO;
import com.softplan.crudapp.dto.ServiceResult;
import com.softplan.crudapp.dto.ServiceResultEnum;
import com.softplan.crudapp.service.PersonService;

@RunWith ( SpringRunner.class )
public class PersonControllerTest {

    @Mock
    private PersonService personService;

    @InjectMocks
    private PersonController personController;
    
    @BeforeEach
    public void setup () {
        MockitoAnnotations.openMocks( this );
    }

    private PersonDTO createPersonDTO ( int i ) {

        PersonDTO person = new PersonDTO();
        person.setId( Long.valueOf( i ) );
        person.setAddress( "Endereço de teste" );
        person.setName( "João_" + i );
        person.setPosition( "Desenvolvedor nível " + i );

        return person;
    }

    private List < PersonDTO > getListPersonEntityTest () {

        List < PersonDTO > persons = new ArrayList < PersonDTO >();

        for ( int i = 1 ; i < 5 ; i++ ) {
            persons.add( createPersonDTO( i ) );
        }

        return persons;
    }

    @Test
    public void getAllPersons_test_ok () {

        List < PersonDTO > dtoList = getListPersonEntityTest();

        ServiceResult expectedServiceResult = new ServiceResult();
        expectedServiceResult.setData( dtoList );
        expectedServiceResult.set( ServiceResultEnum.SUCCESS );

        Mockito.when( personService.getAllPersons() ).thenReturn( dtoList );

        ResponseEntity < ServiceResult > result = personController.getallPersons();

        assertEquals( HttpStatus.OK , result.getStatusCode() );

        assertEquals( expectedServiceResult.getData() , result.getBody().getData() );

        verify( personService , times( 1 ) ).getAllPersons();
    }

    @Test
    public void getAllPersons_test_exception () {

        ServiceResult expectedServiceResult = new ServiceResult();
        expectedServiceResult.set( ServiceResultEnum.ERROR );

        given( personService.getAllPersons() ).willThrow( new RuntimeException() );

        ResponseEntity < ServiceResult > result = personController.getallPersons();

        assertEquals( HttpStatus.BAD_REQUEST , result.getStatusCode() );

    }

    @Test
    public void getPerson_test_ok () {

        PersonDTO dto = createPersonDTO( 1 );

        ServiceResult expectedServiceResult = new ServiceResult();
        expectedServiceResult.setData( dto );
        expectedServiceResult.set( ServiceResultEnum.SUCCESS );

        Mockito.when( personService.getPersonById( 1L ) ).thenReturn( dto );

        ResponseEntity < ServiceResult > result = personController.getPerson( 1L );

        assertEquals( HttpStatus.OK , result.getStatusCode() );

        assertEquals( expectedServiceResult.getData() , result.getBody().getData() );

        verify( personService , times( 1 ) ).getPersonById( 1L );
    }

    @Test
    public void getPerson_test_exception () {

        ServiceResult expectedServiceResult = new ServiceResult();
        expectedServiceResult.set( ServiceResultEnum.ERROR );

        given( personService.getPersonById( 1L ) ).willThrow( new RuntimeException() );

        ResponseEntity < ServiceResult > result = personController.getPerson( 1L );

        assertEquals( HttpStatus.BAD_REQUEST , result.getStatusCode() );

    }

    @Test
    public void addPerson_test_ok () {

        ServiceResult expectedServiceResult = new ServiceResult();
        expectedServiceResult.set( ServiceResultEnum.SUCCESS );

        ResponseEntity < ServiceResult > result = personController.addPerson( new PersonDTO() );

        assertEquals( HttpStatus.OK , result.getStatusCode() );

        verify( personService , times( 1 ) ).addPerson( Mockito.any( PersonDTO.class ) );
    }

    @Test
    public void addPerson_test_exception () {

        ServiceResult expectedServiceResult = new ServiceResult();
        expectedServiceResult.set( ServiceResultEnum.ERROR );

        Mockito.doThrow( new RuntimeException() ).when( personService ).addPerson( Mockito.any( PersonDTO.class ) );

        ResponseEntity < ServiceResult > result = personController.addPerson( new PersonDTO() );

        assertEquals( HttpStatus.BAD_REQUEST , result.getStatusCode() );

    }

    @Test
    public void updatePerson_test_ok () {

        ServiceResult expectedServiceResult = new ServiceResult();
        expectedServiceResult.set( ServiceResultEnum.SUCCESS );

        ResponseEntity < ServiceResult > result = personController.updatePerson( new PersonDTO() );

        assertEquals( HttpStatus.OK , result.getStatusCode() );

        verify( personService , times( 1 ) ).editPerson( Mockito.any( PersonDTO.class ) );
    }

    @Test
    public void updatePerson_test_exception () {

        ServiceResult expectedServiceResult = new ServiceResult();
        expectedServiceResult.set( ServiceResultEnum.ERROR );

        Mockito.doThrow( new RuntimeException() ).when( personService ).editPerson( Mockito.any( PersonDTO.class ) );

        ResponseEntity < ServiceResult > result = personController.updatePerson( new PersonDTO() );

        assertEquals( HttpStatus.BAD_REQUEST , result.getStatusCode() );

    }

    @Test
    public void deletePerson_test_ok () {

        ServiceResult expectedServiceResult = new ServiceResult();
        expectedServiceResult.set( ServiceResultEnum.SUCCESS );

        ResponseEntity < ServiceResult > result = personController.deletePerson( 1L );

        assertEquals( HttpStatus.OK , result.getStatusCode() );

        verify( personService , times( 1 ) ).deletePerson( 1L );
    }

    @Test
    public void deletePerson_test_exception () {

        ServiceResult expectedServiceResult = new ServiceResult();
        expectedServiceResult.set( ServiceResultEnum.ERROR );

        Mockito.doThrow( new RuntimeException() ).when( personService ).deletePerson( 1L );

        ResponseEntity < ServiceResult > result = personController.deletePerson( 1L );

        assertEquals( HttpStatus.BAD_REQUEST , result.getStatusCode() );

    }

}
