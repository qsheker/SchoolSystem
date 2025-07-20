    package com.qsheker.school.dao;

    import com.qsheker.school.entities.Student;
    import org.hibernate.SessionFactory;


    public class StudentRepository extends RepositoryBase<Long, Student> {
        public StudentRepository(SessionFactory sessionFactory){
            super(sessionFactory, Student.class);
        }
    }
