package com.softplan.crudapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softplan.crudapp.dto.PersonDTO;
import com.softplan.crudapp.dto.ServiceResult;
import com.softplan.crudapp.dto.ServiceResultEnum;
import com.softplan.crudapp.service.PersonService;

@RestController
@CrossOrigin ( origins = "http://localhost:8080" )
public class PersonController {

    private static final Logger logger = LogManager.getLogger( PersonController.class );
    
    @Autowired
    PersonService personService;
    
    @GetMapping ( "/person/list" )
    public ResponseEntity < ServiceResult > getallPersons () {
        
        ServiceResult result = new ServiceResult();
        
        try {
            
            result.setData( personService.getAllPersons() );
            result.set( ServiceResultEnum.SUCCESS );
            
        } catch ( Exception e ) {
            
            logger.error( "Falha em operação" , e );
            result.set( ServiceResultEnum.ERROR );
        }
        
        return new ResponseEntity < ServiceResult >( result , result.getHttpStatus() );
    }

    @GetMapping ( "/person" )
    public ResponseEntity < ServiceResult > getPerson ( @RequestParam Long id ) {

        ServiceResult result = new ServiceResult();

        try {

            result.setData( personService.getPersonById( id ) );
            result.set( ServiceResultEnum.SUCCESS );

        } catch ( Exception e ) {

            logger.error( "Falha em operação" , e );
            result.set( ServiceResultEnum.ERROR );
        }

        return new ResponseEntity < ServiceResult >( result , result.getHttpStatus() );
    }

    @PostMapping ( "/person" )
    public ResponseEntity < ServiceResult > addPerson ( @RequestBody PersonDTO request ) {

        ServiceResult result = new ServiceResult();

        try {

            personService.addPerson( request );
            result.set( ServiceResultEnum.SUCCESS );
            result.setMessage( "Pessoa adicionada com sucesso!" );

        } catch ( Exception e ) {

            logger.error( "Falha em operação" , e );
            result.set( ServiceResultEnum.ERROR );
            result.setMessage( "Erro ao adicionar pessoa!" );
        }

        return new ResponseEntity < ServiceResult >( result , result.getHttpStatus() );
    }

    @PutMapping ( "/person" )
    public ResponseEntity < ServiceResult > updatePerson ( @RequestBody PersonDTO request ) {

        ServiceResult result = new ServiceResult();

        try {

            personService.editPerson( request );
            result.set( ServiceResultEnum.SUCCESS );
            result.setMessage( "Pessoa editada com sucesso!" );

        } catch ( Exception e ) {

            logger.error( "Falha em operação" , e );
            result.set( ServiceResultEnum.ERROR );
            result.setMessage( "Erro ao editar pessoa!" );
        }

        return new ResponseEntity < ServiceResult >( result , result.getHttpStatus() );
    }

    @DeleteMapping ( "/person/{id}" )
    public ResponseEntity < ServiceResult > deletePerson ( @PathVariable Long id ) {

        ServiceResult result = new ServiceResult();

        try {

            personService.deletePerson( id );
            result.setMessage( "Pessoa removida com sucesso!" );
            result.set( ServiceResultEnum.SUCCESS );

        } catch ( Exception e ) {

            logger.error( "Falha em operação" , e );
            result.set( ServiceResultEnum.ERROR );
            result.setMessage( "Erro ao remover pessoa!" );
        }

        return new ResponseEntity < ServiceResult >( result , result.getHttpStatus() );
    }
}
