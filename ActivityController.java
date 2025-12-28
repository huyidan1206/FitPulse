package com.example.fitness.controller;

import com.example.fitness.entity.Activity;
import com.example.fitness.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/selectList")
    public Map<String, Object> selectList(Activity activity) {
        List<Activity> activities = activityService.selectList(activity);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "查询成功");
        map.put("data", activities);
        return map;
    }

    @PostMapping("/insert")
    public Map<String, Object> insert(@RequestBody Activity activity) {
        int result = activityService.insert(activity);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "添加成功");
        map.put("data", result);
        return map;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        int result = activityService.delete(id);
        Map<String, Object> map = new HashMap<>();
        if (result > 0) {
            map.put("code", 200);
            map.put("msg", "删除成功");
        } else {
            map.put("code", 404);
            map.put("msg", "删除失败");
        }
        map.put("data", result);
        return map;
    }

    @PostMapping("/update")
    public Map<String, Object> update(@RequestBody Activity activity) {
        int result = activityService.update(activity);
        Map<String, Object> map = new HashMap<>();
        if (result > 0) {
            map.put("code", 200);
            map.put("msg", "更新成功");
        } else {
            map.put("code", 404);
            map.put("msg", "更新失败");
        }
        map.put("data", result);
        return map;
    }
}

//这是一个基于 Spring MVC 的 ** 控制层（Controller）** 类，它负责接收来自前端的 HTTP 请求，
// 调用相应的业务逻辑（Service 层），并将处理结果以 JSON 格式返回给前端。
