package com.softplan.crudapp.dto;

import java.util.ArrayList;
import java.util.List;

import com.softplan.crudapp.domain.Person;

public class PersonDTO {

    private Long id;

    private String name;

    private String address;

    private String position;

    public static PersonDTO entityToDto ( Person person ) {

        PersonDTO dto = new PersonDTO();

        dto.setId( person.getId() );
        dto.setName( person.getName() );
        dto.setAddress( person.getAddress() );
        dto.setPosition( person.getPosition() );

        return dto;
    }

    public static Person dtoToEntity ( PersonDTO dto ) {

        Person person = new Person();

        person.setId( dto.getId() );
        person.setName( dto.getName() );
        person.setAddress( dto.getAddress() );
        person.setPosition( dto.getPosition() );

        return person;
    }

    public static List < PersonDTO > entityListToDtoList ( List < Person > persons ) {
        
        List < PersonDTO > dtoList = new ArrayList < PersonDTO >();

        persons.stream().forEach( person -> {
            dtoList.add( PersonDTO.entityToDto( person ) );
        } );

        return dtoList;
    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress ( String address ) {
        this.address = address;
    }

    public String getPosition () {
        return position;
    }

    public void setPosition ( String position ) {
        this.position = position;
    }

}
