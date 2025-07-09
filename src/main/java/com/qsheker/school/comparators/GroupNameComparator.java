package com.qsheker.school.comparators;

import com.qsheker.school.entities.Course;
import com.qsheker.school.entities.Group;

import java.util.Comparator;

public class GroupNameComparator implements Comparator<Group> {
    @Override
    public int compare(Group o1, Group o2) {
        return o1.getGroupName().compareToIgnoreCase(o2.getGroupName());
    }

    @Override
    public Comparator<Group> reversed() {
        return Comparator.super.reversed();
    }
}
