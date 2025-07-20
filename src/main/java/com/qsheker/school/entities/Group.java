package com.qsheker.school.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "groups")
@Builder
@ToString(exclude = {"students"})
public class Group{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String groupName;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Student> students = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "teacher_groups",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    @Builder.Default
    private List<Teacher> teachers = new ArrayList<>();

}

