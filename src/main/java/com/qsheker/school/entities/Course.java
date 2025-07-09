package com.qsheker.school.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;
import org.hibernate.annotations.FetchProfiles;

import javax.persistence.*;
import java.util.List;


@FetchProfile(name = "forStudentsAndTeacher",fetchOverrides ={
        @FetchProfile.FetchOverride
                (
                entity = Course.class, association = "students", mode = FetchMode.JOIN
                ),
        @FetchProfile.FetchOverride
                (
                        entity = Course.class, association = "teacher", mode = FetchMode.JOIN
                )
}
)

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
@Builder
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "affect_for_gpa")
public class Course extends BaseEntity<Long>{
    private String courseName;

    private boolean affect = true;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}
