package com.example.fitness.mapper;

import com.example.fitness.entity.Activity;

import java.util.List;

public interface ActivityMapper {
    List<Activity> selectList(Activity activity);

    int insert(Activity activity);
    int delete(Long id);
    int update(Activity activity);
}

//MyBatis 为它创建动态代理，将方法调用转换为对 XML 中定义的 SQL 语句的执行。
//接口的全限定名关联到 XML 文件，接口的方法名关联到 XML 中的 id，
// 方法的参数和返回值类型指导 MyBatis 进行参数绑定和结果映射。
