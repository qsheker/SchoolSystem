package com.qsheker.school.dao;


import com.qsheker.school.entities.Course;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import javax.persistence.criteria.Root;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseDao {
    private final static CourseDao INSTANCE = new CourseDao();
    /**
     * Найти все курсы, которые влияют на GPA.
     * Используется наследование: affectForGPA (тип).
     */
    public List<Course> findAllAffectingGPA(Session session){
//        select all from courses where c.affect true
        var cb = session.getCriteriaBuilder();
        var criteria = cb.createQuery(Course.class);
        var course = criteria.from(Course.class);
        criteria.select(course).where(cb.equal(course.get("affect"),true));
        return session.createQuery(criteria).list();
    }

    /**
     * Найти курсы по части названия (case-insensitive).
     * Пример: "math" найдёт "Mathematics", "MATH 101", и т.д.
     */
    public List<Course> findByNameLikeIgnoreCase(Session session, String pattern){
        var cb = session.getCriteriaBuilder();
        var criteria = cb.createQuery(Course.class);
        Root<Course> course = criteria.from(Course.class);
        criteria.select(course).where(cb.like(course.get("courseName"),"%"+pattern.toLowerCase()+"%"));
        return session.createQuery(criteria).list();
    }

    /**
     * Найти курсы, на которые не записан ни один студент.
     */
    public List<Course> findCoursesWithoutStudents(Session session){
        var cb = session.getCriteriaBuilder();
        var criteria = cb.createQuery(Course.class);
        Root<Course> courseRoot = criteria.from(Course.class);
        criteria.select(courseRoot).where(cb.equal(cb.size(courseRoot.get("students")),0));

        return session.createQuery(criteria).list();
    }

    /**
     * Найти курсы, на которые записано больше N студентов.
     */
    public List<Course> findPopularCourses(Session session, int minStudents){
        var cb = session.getCriteriaBuilder();
        var criteria = cb.createQuery(Course.class);
        Root<Course> courseRoot = criteria.from(Course.class);
        criteria.select(courseRoot).where(cb.greaterThanOrEqualTo(cb.size(courseRoot.get("students")),minStudents));

        return session.createQuery(criteria).list();
    }

    /**
     * Найти курсы, у которых нет связанных оценок (если есть связь с Grade).
     */
    public List<Course> findCoursesWithoutGrades(Session session) {
        return Collections.emptyList();
    }

    /**
     * Найти курсы, на которые записан студент с заданным ID.
     */
    public List<Course> findCoursesByStudentId(Session session, Long studentId){
        var cb = session.getCriteriaBuilder();
        var criteria = cb.createQuery(Course.class);
        Root<Course> course = criteria.from(Course.class);
        var students = course.join("students");
        criteria.select(course).where(cb.equal(students.get("id"),studentId));

        return session.createQuery(criteria).list();
    }

    /**
     * Найти курсы определённого подтипа (например, affectForGPA или NoAffectForGPA).
     */
    public List<Course> findByCourseType(Session session, Class<? extends Course> courseType){
        return Collections.emptyList();
    }
}
