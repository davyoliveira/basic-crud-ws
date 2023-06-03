package com.softplan.crudapp.domain;

import com.softplan.crudapp.listener.AuditListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@EntityListeners ( AuditListener.class )
public class Person {

    private static final long serialVersionUID = - 7314511371407644708L;

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private String position;

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
