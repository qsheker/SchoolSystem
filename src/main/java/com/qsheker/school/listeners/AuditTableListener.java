package com.qsheker.school.listeners;

import com.qsheker.school.entities.Audit;
import org.hibernate.event.spi.*;

public class AuditTableListener implements PreInsertEventListener, PreDeleteEventListener, PreUpdateEventListener {
    @Override
    public boolean onPreDelete(PreDeleteEvent event) {
        auditEntity(event, Audit.Operation.DELETE);
        return false;
    }

    @Override
    public boolean onPreInsert(PreInsertEvent event) {
        auditEntity(event, Audit.Operation.INSERT);
        return false;
    }

    @Override
    public boolean onPreUpdate(PreUpdateEvent event) {
        auditEntity(event, Audit.Operation.UPDATE);
        return false;
    }
    public void auditEntity(AbstractPreDatabaseOperationEvent event, Audit.Operation operation){
        if(event.getEntity().getClass()!= Audit.class){
            var auditEntity = Audit.builder()
                    .entityId(event.getId())
                    .entityName(event.getEntityName())
                    .entityContent(event.getEntity().toString())
                    .operation(operation)
                    .build();
            event.getSession().save(auditEntity);
        }
    }
}
