package com.example.fitness.mapper;

import com.example.fitness.entity.Business;

import java.util.List;

public interface BusinessMapper {
    List<Business> selectList(Business business);
    int insert(Business business);
    int delete(Long id);
    int update(Business business);
    Business selectById(Long id);

}
