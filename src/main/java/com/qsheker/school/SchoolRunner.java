package com.qsheker.school;

import com.qsheker.school.dao.StudentRepository;
import com.qsheker.school.mapper.GroupReadMapper;
import com.qsheker.school.mapper.StudentReadMapper;
import com.qsheker.school.service.StudentService;
import com.qsheker.school.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.lang.reflect.Proxy;

@Slf4j
public class SchoolRunner {
    @Transactional
    public static void main(String[] args) {
        try(var sessionFactory = HibernateUtil.buildSessionFactory();){
            var session = (Session) Proxy.newProxyInstance(SessionFactory.class.getClassLoader(), new Class[]{Session.class},
                    (proxy, method, args1) -> method.invoke(sessionFactory.getCurrentSession(), args1));
            session.beginTransaction();

            var studentRepository = new StudentRepository(session);
            var groupReadMapper = new GroupReadMapper();
            var studentReadMapper = new StudentReadMapper(groupReadMapper);
            var studentService = new StudentService(studentRepository,studentReadMapper);

            studentService.findById(1L).ifPresent(System.out::print);

            session.getTransaction().commit();
        }
    }


}
