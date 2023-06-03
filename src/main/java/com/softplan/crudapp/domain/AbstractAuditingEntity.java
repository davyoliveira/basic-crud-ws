package com.softplan.crudapp.domain;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;

//@MappedSuperclass
// @EntityListeners ( AuditListener.class )
public class AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1288137595598318890L;

    @CreatedBy
    @Column ( nullable = false , length = 20 , updatable = false )
    private String createdBy;

    @CreatedDate
    @Column ( updatable = false )
    private Instant createdDate = Instant.now();

    @LastModifiedBy
    @Column ( length = 20 )
    private String lastModifiedBy;
    
    @LastModifiedDate
    @Column
    private Instant lastModifiedDate = Instant.now();

}
