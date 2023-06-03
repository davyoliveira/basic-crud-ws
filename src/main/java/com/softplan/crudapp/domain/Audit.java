package com.softplan.crudapp.domain;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Audit {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column ( length = 20 )
    private String action;

    @Column
    private String personJson;

    @Column
    private String user;

    @Column
    private Instant modifyDate;

    public Instant getModifyDate () {
        return modifyDate;
    }

    public void setModifyDate ( Instant modifyDate ) {
        this.modifyDate = modifyDate;
    }

    public String getUser () {
        return user;
    }

    public void setUser ( String user ) {
        this.user = user;
    }

    public Long getId () {
        return id;
    }

    public void setId ( Long id ) {
        this.id = id;
    }

    public String getAction () {
        return action;
    }

    public void setAction ( String action ) {
        this.action = action;
    }

    public String getPersonJson () {
        return personJson;
    }

    public void setPersonJson ( String personJson ) {
        this.personJson = personJson;
    }
}
