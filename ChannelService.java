package com.example.fitness.service;

import com.example.fitness.entity.Channel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChannelService {
    List<Channel> selectList(Channel channel);

    int insert(Channel channel);

    int delete(Long id);

    int update(Channel channel);
}
