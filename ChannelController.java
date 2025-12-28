package com.example.fitness.controller;

import com.example.fitness.entity.Channel;
import com.example.fitness.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/channel")
public class ChannelController {
    //crl+alt+L 代码的格式化
    //ctrl+alt+O 优化包的导入
    @Autowired
    private ChannelService channelService;

    @RequestMapping(value="/selectList",method= RequestMethod.GET)
    public Map<String,Object> selectList(Channel channel) {
        List<Channel> channels =channelService.selectList(channel);
        Map<String ,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","查询成功");
        map.put("data",channels);
        return map;
    }

    //PostMapping==RequestMapping(method=RequestMethod.POST)
    //RequestBody是所有将数据放在body中的请求都需要加这个注解，Get请求方式不需要，应为他将参数拼接到了浏览器的地址栏里
    @PostMapping("/insert")
    public Map<String,Object> insert(@RequestBody Channel channel){
        int insert= channelService.insert(channel);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","添加成功");
        map.put("data",insert);
        return map;
    }

    //PathVariable读取请求路径上的参数 参数的格式：{param}
    @DeleteMapping("/delete/{id}")
    public Map<String,Object> delete(@PathVariable Long id){
        int result = channelService.delete(id);
        Map<String,Object> map = new HashMap<>();
        if(result>0){
            map.put("code",200);
            map.put("msg","删除成功");
        } else {
            map.put("code",404);
            map.put("msg","删除失败");
        }
        map.put("data",result);
        return map;
    }

    @PostMapping("/update")
    public Map<String,Object> update(@RequestBody Channel channel){
        int result = channelService.update(channel);
        Map<String,Object> map = new HashMap<>();
        if(result>0){
            map.put("code",200);
            map.put("msg","更新成功");
        } else {
            map.put("code",404);
            map.put("msg","更新失败");
        }
        map.put("data",result);
        return map;
    }

    //常见的响应状态：404请求路径丢失找不到解决方法：检查自己的路径是否正确（有可能你写了代码，但是忘了重启后段的程序）
    //405 bad request 一般发生在前后端不一致的时候，比如前段是get请求，但是后端是post 请求，就会报405错误
    //500 服务器内部错误 后端程序代码执行有问题，检查idea的控制台，查看报错信息（假如说代码部署到了服务器上，那么可以查看程序的运行日志）
    //network error 网络错误 一般是后端程序没启动
    //get 请求路径：/channel/query?id=1
    //delete 请求路径（可选），也可以把参数放在body体中，就像post一样：/channel/delete/1
}
