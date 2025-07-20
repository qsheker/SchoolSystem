package com.qsheker.school.dao;

import com.qsheker.school.entities.Teacher;
import org.hibernate.SessionFactory;

public class TeacherRepository extends RepositoryBase<Long, Teacher>{
    public TeacherRepository(SessionFactory sessionFactory){
        super(sessionFactory, Teacher.class);
    }
}
