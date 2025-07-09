package com.qsheker.school.entities;

import com.qsheker.school.comparators.GroupNameComparator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SortNatural;
import org.hibernate.annotations.SortComparator;


import javax.persistence.*;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teachers")
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    /*
     * 1. @OrderBy - Sorts collection by entity field when loading from DB
     *    - Uses SQL ORDER BY clause
     *    - Works with List/Set
     */
    @OneToMany(mappedBy = "teacher")
//    @OrderBy("courseName ASC") // Sorts courses by name in ascending order
    private List<Course> courses;

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