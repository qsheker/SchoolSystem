package com.qsheker.school.listeners;

import com.qsheker.school.entities.AuditableEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.Instant;

public class AuditListener {
    @PrePersist
    public void prePersist(AuditableEntity<?> entity){
        entity.setCreatedAt(Instant.now());
    }
    @PreUpdate
    public void postUpdate(AuditableEntity<?> entity){
        entity.setUpdatedAt(Instant.now());
    }
}
