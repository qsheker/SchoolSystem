package com.qsheker.school;

import com.qsheker.school.entities.Course;
import com.qsheker.school.entities.Grade;
import com.qsheker.school.util.HibernateUtil;
import com.qsheker.school.entities.Student;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;

import javax.persistence.LockModeType;

class SchoolRunnerTest {
    @Test
    public void transactionTest(){
        @Cleanup SessionFactory sf = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sf.openSession();
        session.beginTransaction();
        session.find(Grade.class,1L);

        session.getTransaction().commit();
    }

    @Test
    public void hqlTest(){
        @Cleanup SessionFactory sf = HibernateUtil.buildSessionFactory();
        @Cleanup Session session = sf.openSession();
        session.beginTransaction();
        String name = "Aldiyar";

//        var query3 = session.createNamedQuery("findStudentById", Student.class)
//                .setParameter(1,1);

        var query1 = session.createQuery("select s from Student s where s.firstName = ?1",Student.class)
                .setParameter(1,name).list();
        var query2 = session.createQuery("select s from Student s where s.firstName = :username", Student.class)
                .setParameter("username", name);

        var query4 = session.createNativeQuery("select s.* from students s",Student.class);
        session.getTransaction().commit();
    }


    @Test
    public void checkTestContainers(){
//        @Cleanup SessionFactory sf = HibernateUtilTest.buildSessionFactory();
//        @Cleanup Session session = sf.openSession();
//
//        session.beginTransaction();
//
//        session.getTransaction().commit();
    }
}