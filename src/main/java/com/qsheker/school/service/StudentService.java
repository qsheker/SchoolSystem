package com.qsheker.school.service;

import com.qsheker.school.dao.StudentRepository;
import com.qsheker.school.dto.StudentReadDto;
import com.qsheker.school.mapper.StudentReadMapper;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentReadMapper studentReadMapper;


    public Optional<StudentReadDto> findById(Long id){
        return studentRepository.findById(id)
                .map(studentReadMapper::mapFrom);
    }

    public boolean delete(Long id){
        var maybeStudent = studentRepository.findById(id);
        maybeStudent.ifPresent(student->studentRepository.delete(id));
        return maybeStudent.isPresent();
    }

}
