package com.qsheker.school.entities;

import com.qsheker.school.listeners.AuditListener;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
@Builder
@EntityListeners(value = AuditListener.class)
@ToString(exclude = {"group","courses"})
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Grade> grades = new ArrayList<>();

    @ManyToMany(mappedBy = "students")
    @Builder.Default
    private List<Course> courses = new ArrayList<>();
}
