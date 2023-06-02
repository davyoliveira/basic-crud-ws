package com.softplan.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softplan.crudapp.domain.Person;

public interface PersonRepository extends JpaRepository < Person , Long > {

}
