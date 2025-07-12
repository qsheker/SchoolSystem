package com.qsheker.school.util;


import com.qsheker.school.listeners.AuditTableListener;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;

@UtilityClass
public class HibernateUtil {

    public static SessionFactory buildSessionFactory() {
        Configuration configuration = buildConfiguration();
        var sf = configuration.buildSessionFactory();
        registerListeners(sf);
        return sf;
    }
    public void registerListeners(SessionFactory sessionFactory){
        var sessionFactoryImpl = sessionFactory.unwrap(SessionFactoryImpl.class);
        var listenerRegistry = sessionFactoryImpl.getServiceRegistry().getService(EventListenerRegistry.class);
        var auditListener = new AuditTableListener();
        listenerRegistry.appendListeners(EventType.PRE_DELETE,auditListener);
        listenerRegistry.appendListeners(EventType.PRE_INSERT,auditListener);
        listenerRegistry.appendListeners(EventType.PRE_UPDATE,auditListener);
    }

    public static Configuration buildConfiguration(){
        Configuration configuration = new Configuration();
        configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
        configuration.registerTypeOverride(new JsonBinaryType());
        configuration.configure();

        return configuration;
    }
}
