package com.qsheker.school;

import com.qsheker.school.entities.Group;
import com.qsheker.school.entities.Student;
import com.qsheker.school.util.HibernateUtil;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.jpa.event.spi.CallbackType;

import javax.transaction.Transactional;

@Slf4j
public class SchoolRunner {
    @Transactional
    public static void main(String[] args) {
        @Cleanup var sessionFactory = HibernateUtil.buildSessionFactory();
        @Cleanup var session = sessionFactory.openSession();
        
        session.beginTransaction();
        session.getTransaction().commit();
    }


}
