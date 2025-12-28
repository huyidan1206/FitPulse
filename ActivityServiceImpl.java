package com.example.fitness.service;

import com.example.fitness.entity.Activity;
import com.example.fitness.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

//服务层组件
@Service
public class ActivityServiceImpl implements ActivityService{
    @Autowired//依赖注入注解
    private ActivityMapper activityMapper;

    @Override
    public List<Activity> selectList(Activity activity) {
        return activityMapper.selectList(activity);
    }

    @Override
    public int insert(Activity activity) {
        return activityMapper.insert(activity);
    }

    @Override
    public int delete(Long id) {
        return activityMapper.delete(id);
    }

    @Override
    @Transactional
    public int update(Activity activity) {
        if(activity.getId() == null){
            throw new RuntimeException("更新失败：活动id不能为空");
        }
        return activityMapper.update(activity);
    }
}
