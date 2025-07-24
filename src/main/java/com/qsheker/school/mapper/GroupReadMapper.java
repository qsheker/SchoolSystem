package com.qsheker.school.mapper;

import com.qsheker.school.dto.GroupReadDto;
import com.qsheker.school.entities.Group;

public class GroupReadMapper implements Mapper<Group, GroupReadDto>{
    @Override
    public GroupReadDto mapFrom(Group entity) {
        return new GroupReadDto(
                entity.getId(),
                entity.getGroupName()
        );
    }
}
