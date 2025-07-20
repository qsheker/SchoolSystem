package com.qsheker.school;

import com.qsheker.school.dao.StudentRepository;
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
            var session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            var studentRepository = new StudentRepository(sessionFactory);
            studentRepository.findById(1L).ifPresent(System.out::print);

            session.getTransaction().commit();
        }
    }


}
