package com.example.fitness.service;

import com.example.fitness.entity.Business;
import com.example.fitness.mapper.BusinessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public List<Business> selectList(Business business) {
        return businessMapper.selectList(business);
    }

    @Override
    public Business selectById(Long id) {
        return businessMapper.selectById(id);
    }

    @Override
    public int insert(Business business) {
        // 可添加参数校验逻辑
        return businessMapper.insert(business);
    }

    @Override
    public int delete(Long id) {
        return businessMapper.delete(id);
    }

    @Override
    @Transactional
    public int update(Business business) {
        if (business.getId() == null) {
            throw new RuntimeException("更新失败：商机ID不能为空");
        }
        return businessMapper.update(business);
    }
}