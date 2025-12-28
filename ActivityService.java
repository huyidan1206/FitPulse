package com.example.fitness.service;

import com.example.fitness.entity.Activity;

import java.util.List;

public interface ActivityService {
    List<Activity> selectList(Activity activity);
    int insert(Activity activity);
    int delete(Long id);
    int update(Activity activity);
}
