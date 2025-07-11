package com.qsheker.school.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teachers")
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;



    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Course> courses = new ArrayList<>();


    @ManyToMany(mappedBy = "teachers")
    @Builder.Default
    private List<Group> groups = new ArrayList<>();


    /*
     * 1. @OrderBy - Sorts collection by entity field when loading from DB
     *    - Uses SQL ORDER BY clause
     *    - Works with List/Set
     */
//    @OrderBy("courseName ASC") // Sorts courses by name in ascending order


    /*
     * 2. @OrderColumn - Maintains persistent ordering using a dedicated DB column
     *    - Only works with List/array
     *    - Manages order manually (not by entity fields)
     */
//    @ManyToMany
//    @JoinTable(
//            name = "teacher_group",
//            joinColumns = @JoinColumn(name = "teacher_id"),
//            inverseJoinColumns = @JoinColumn(name = "group_id")
//    )
//    @OrderColumn(name = "group_order") // Adds column to store list index
//    private List<Group> orderedGroups;

    /*
     * 3. @SortNatural - For SortedSet using natural ordering (Comparable)
     *    - Requires entities to implement Comparable
     *    - Sorting happens in memory
     */
//    @ManyToMany
//    @JoinTable(
//            name = "teacher_group_natural",
//            joinColumns = @JoinColumn(name = "teacher_id"),
//            inverseJoinColumns = @JoinColumn(name = "group_id")
//    )
//    @SortNatural
//    private SortedSet<Group> naturallySortedGroups = new TreeSet<>();

    /*
     * 4. @SortComparator - For SortedSet with custom Comparator
     *    - Sorting happens in memory
     *    - More flexible than @SortNatural
     */
//    @ManyToMany
//    @JoinTable(
//            name = "teacher_group_comparator",
//            joinColumns = @JoinColumn(name = "teacher_id"),
//            inverseJoinColumns = @JoinColumn(name = "group_id")
//    )
//    @SortComparator(GroupNameComparator.class) // Uses custom comparator
//    private SortedSet<Group> comparatorSortedGroups = new TreeSet<>();
}