package com.qsheker.school;

import com.qsheker.school.entities.Student;
import com.qsheker.school.entities.Teacher;
import com.qsheker.school.util.HibernateUtil;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

@Slf4j
public class SchoolRunner {
    @Transactional
    public static void main(String[] args) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();){
            Teacher teacher = null;
            try(var session = sessionFactory.openSession();){
            session.beginTransaction();
            teacher = session.find(Teacher.class,1L);
            var teacher1 = session.find(Teacher.class,1L);
                System.out.println(teacher1);
            session.getTransaction().commit();
        }
            try(var session2 = sessionFactory.openSession();){
                session2.beginTransaction();
                var teacher2 = session2.find(Teacher.class,1L);
                System.out.println(teacher2);
                session2.getTransaction().commit();
            }

        }
    }


}
