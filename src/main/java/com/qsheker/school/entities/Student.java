package com.qsheker.school.entities;

import com.qsheker.school.listeners.AuditListener;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

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
@ToString(exclude = {"grades","courses"})
@Audited
public class Student extends BaseEntity<Long> {

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @NotAudited
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @NotAudited
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Grade> grades = new ArrayList<>();

    @NotAudited
    @ManyToMany(mappedBy = "students")
    @Builder.Default
    private List<Course> courses = new ArrayList<>();
}
