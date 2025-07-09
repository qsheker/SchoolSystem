package com.qsheker.school.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;

    private String lastName;

    @Builder.Default
    @ElementCollection
    @CollectionTable(
            name = "contact_info",
            joinColumns = @JoinColumn(name = "student_id")
    )
    private List<ContactInfo> contactInfos = new ArrayList<>();


    @ManyToMany
    @Builder.Default
    @JoinTable(
            name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses =new ArrayList<>();

    @OneToMany(mappedBy = "student")
    @Builder.Default
    private List<Grade> grades = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group studentGroup;
}
