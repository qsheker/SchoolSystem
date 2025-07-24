package com.qsheker.school.dao;

import com.qsheker.school.entities.Teacher;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;

public class TeacherRepository extends RepositoryBase<Long, Teacher>{
    public TeacherRepository(EntityManager entityManager){
        super(entityManager, Teacher.class);
    }
}
