package com.softplan.crudapp.listener;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.softplan.crudapp.domain.Audit;
import com.softplan.crudapp.domain.Person;
import com.softplan.crudapp.repository.AuditRepository;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;


@Component
public class AuditListener implements AuditorAware < String > {

    static private AuditRepository auditRepository;

    @Autowired
    public void init ( AuditRepository evenementPliRepository ) {
        AuditListener.auditRepository = evenementPliRepository;
    }

    private String personToJson ( Person person ) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        String json = null;

        try {
            json = objectMapper.writeValueAsString( person );
        } catch ( JsonProcessingException e ) {
            throw e;
        }

        return json;
    }

    @PrePersist
    public void prePersist ( Object entity ) throws JsonProcessingException {

        if ( entity instanceof Person ) {
            Person person = ( Person ) entity;

            Audit audit = new Audit();

            audit.setAction( "insert" );
            audit.setPersonJson( personToJson( person ) );
            audit.setUser( getCurrentAuditor().get() );
            audit.setModifyDate( Instant.now() );

            auditRepository.save( audit );
        }
    }

    @PreUpdate
    public void preUpdate ( Object entity ) throws JsonProcessingException {

        if ( entity instanceof Person ) {
            Person person = ( Person ) entity;

            Audit audit = new Audit();

            audit.setAction( "update" );
            audit.setPersonJson( personToJson( person ) );
            audit.setUser( getCurrentAuditor().get() );
            audit.setModifyDate( Instant.now() );

            auditRepository.save( audit );
        }
    }

    @PreRemove
    public void preRemove ( Object entity ) throws JsonProcessingException {

        if ( entity instanceof Person ) {
            Person person = ( Person ) entity;

            Audit audit = new Audit();

            audit.setAction( "remove" );
            audit.setPersonJson( personToJson( person ) );
            audit.setUser( getCurrentAuditor().get() );
            audit.setModifyDate( Instant.now() );

            auditRepository.save( audit );
        }
    }

    @Override
    public Optional < String > getCurrentAuditor () {
        return Optional.of( "SystemUser" );
    }
}
