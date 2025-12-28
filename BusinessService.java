package com.example.fitness.service;

import com.example.fitness.entity.Business;

import java.util.List;

public interface BusinessService {
    List<Business> selectList(Business business);
    Business selectById(Long id);
    int insert(Business business);
    int delete(Long id);
    int update(Business business);


}
