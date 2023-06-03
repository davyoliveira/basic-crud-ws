package com.softplan.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softplan.crudapp.domain.Audit;

public interface AuditRepository extends JpaRepository < Audit , Long > {

}
