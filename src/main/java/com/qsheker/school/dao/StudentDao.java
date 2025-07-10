package com.qsheker.school.dao;

import com.qsheker.school.entities.*;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;

import static com.qsheker.school.entities.QStudent.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentDao {
    private static final StudentDao INSTANCE  = new StudentDao();
    /**
     * Найти студентов по имени и фамилии, игнорируя регистр.
     * Используется `LOWER()` или `ILIKE`.
     */
    public List<Student> findByFullNameIgnoreCase(Session session,String firstName, String lastName){
//        return session.createQuery("select s from Student as s " +
//                "where lower(s.firstName) = ?1 AND lower(s.lastName) = ?2",Student.class)
//                .setParameter(1,firstName.toLowerCase())
//                .setParameter(2,lastName.toLowerCase())
//                .list();
        QStudent qStudent = student;
        return new JPAQuery<Student>(session)
                .select(qStudent)
                .from(qStudent)
                .where(
                        qStudent.firstName.lower().eq(firstName.toLowerCase()).
                        and(qStudent.lastName.lower().eq(lastName.toLowerCase())))
                .fetch();
    }


    /**
     * Найти студентов, записанных на определённый курс по названию.
     * JOIN с таблицей course по имени.
     */
    public List<Student> findByCourseName(Session session, String courseName){
//        return session.createQuery("select s from Student s " +
//                "join s.courses as c where c.courseName = :courseName", Student.class)
//                .setParameter("courseName", courseName)
//                .list();

        QStudent student = QStudent.student;
        QCourse course = QCourse.course;
        return new JPAQuery<Student>(session)
                .select(student)
                .from(student)
                .join(student.courses, course)
                .where(course.courseName.eq(courseName))
                .fetch();
    }

    /**
     * Найти студентов, у которых больше 2 курсов.
     * Фильтрация по размеру списка courses.
     */
    public List<Student> findStudentsWithMultipleCourses(Session session){
//        return session.createQuery("select s from Student as s where (select count(c) from s.courses c)>=2", Student.class)
//                .list();

        QStudent student = QStudent.student;
        QCourse course = QCourse.course;
        return new JPAQuery<Student>(session)
                .select(student)
                .from(student)
                .join(student.courses, course)
                .groupBy(student.id)
                .having(course.count().goe(2))
                .fetch();
    }
}
