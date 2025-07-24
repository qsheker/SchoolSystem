package com.qsheker.school.mapper;

public interface Mapper<F,T>{
    T mapFrom(F entity);
}
