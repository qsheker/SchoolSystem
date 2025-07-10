package com.qsheker.school.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import javax.persistence.*;
import java.util.ArrayList;
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
public class Course{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String courseName;

    @Column(nullable = false, unique = true)
    private String courseCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Grade> grades = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @Builder.Default
    private List<Student > students = new ArrayList<>();
}
