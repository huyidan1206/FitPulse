package com.example.fitness.service;

import com.example.fitness.entity.Channel;
import com.example.fitness.mapper.ChannelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService{
    @Autowired
    private ChannelMapper channelMapper;

//在程序中，所有的业务逻辑处理，都是放在这个文件中的，这个文件就是业务逻辑处理类
    @Override
    public List<Channel> selectList(Channel channel) {
        return channelMapper.selectList((channel));
    }

    @Override
    public int insert(Channel channel) {
        return channelMapper.insert(channel);
    }

    @Override
    public int delete(Long id){
        return channelMapper.delete(id);
    }

    @Override
    @Transactional
    public int update(Channel channel) {
        if(channel.getId() == null){
            throw new RuntimeException("更新失败：渠道id不能为空");
        }
        return channelMapper.update(channel);
    }


}
