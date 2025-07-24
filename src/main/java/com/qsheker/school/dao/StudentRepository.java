    package com.qsheker.school.dao;

    import com.qsheker.school.entities.Student;
    import org.hibernate.SessionFactory;

    import javax.persistence.EntityManager;


    public class StudentRepository extends RepositoryBase<Long, Student> {
        public StudentRepository(EntityManager entityManager){
            super(entityManager, Student.class);
        }
    }
