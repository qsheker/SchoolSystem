package com.qsheker.school.dto;

public record StudentReadDto(
        String firstName,
        String lastName,
        String email,
        GroupReadDto group
){}
