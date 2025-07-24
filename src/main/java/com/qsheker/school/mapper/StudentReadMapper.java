package com.qsheker.school.mapper;

import com.qsheker.school.dto.StudentReadDto;
import com.qsheker.school.entities.Student;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@RequiredArgsConstructor
public class StudentReadMapper implements Mapper<Student, StudentReadDto>{
    private final GroupReadMapper groupReadMapper;

    @Override
    public StudentReadDto mapFrom(Student entity) {
        return new StudentReadDto(
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                Optional.ofNullable(entity.getGroup())
                        .map(groupReadMapper::mapFrom)
                        .orElse(null)
        );
    }
}
