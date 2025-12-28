package com.example.fitness.mapper;

import com.example.fitness.entity.Channel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChannelMapper {
    List<Channel> selectList(Channel channel);
    int insert(Channel channel);
    int delete(Long id);
    int update(Channel channel);

}
