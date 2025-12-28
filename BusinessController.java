package com.example.fitness.controller;

import com.example.fitness.entity.Business;
import com.example.fitness.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/business") // 基础路径
public class BusinessController {



    @Autowired
    private BusinessService businessService;

    @GetMapping("/selectList")
    public Map<String, Object> selectList(Business business) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Business> list = businessService.selectList(business);
            result.put("code", 200);
            result.put("msg", "查询成功");
            result.put("data", list);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "查询失败：" + e.getMessage());
            result.put("data", null);
        }
        return result;
    }

    @GetMapping("/selectById/{id}")
    public Map<String, Object> selectById(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            Business business = businessService.selectById(id);
            result.put("code", 200);
            result.put("msg", "查询成功");
            result.put("data", business);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "查询失败：" + e.getMessage());
            result.put("data", null);
        }
        return result;
    }

    @PostMapping("/insert")
    public Map<String, Object> insert(@RequestBody Business business) {
        Map<String, Object> result = new HashMap<>();
        try {
            // ========== 关键：强制兜底nextTrackTime ==========
            if (business.getNextTrackTime() == null) {
                business.setNextTrackTime(LocalDate.now());
            }
            // 其他必填字段兜底
            if (business.getCreateTime() == null) business.setCreateTime(LocalDate.now());
            if (business.getUpdateTime() == null) business.setUpdateTime(LocalDate.now());
            if (business.getIntentionAmount() == null) business.setIntentionAmount(BigDecimal.ZERO);
            if (business.getTrackStatus() == null) business.setTrackStatus("0"); // 默认未跟进

            int count = businessService.insert(business);
            result.put("code", 200);
            result.put("msg", "新增成功");
            result.put("data", count);
        } catch (Exception e) {
            e.printStackTrace(); // 打印完整异常栈
            result.put("code", 500);
            result.put("msg", "新增失败：" + e.getMessage());
            result.put("data", 0);
        }
        return result;
    }

    @PostMapping("/update")
    public Map<String, Object> update(@RequestBody Business business) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (business.getId() == null) {
                throw new RuntimeException("ID不能为空");
            }
            business.setUpdateTime(LocalDate.now());
            int count = businessService.update(business);
            result.put("code", 200);
            result.put("msg", "更新成功");
            result.put("data", count);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 500);
            result.put("msg", "更新失败：" + e.getMessage());
            result.put("data", 0);
        }
        return result;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            int count = businessService.delete(id);
            result.put("code", 200);
            result.put("msg", "删除成功");
            result.put("data", count);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "删除失败：" + e.getMessage());
            result.put("data", 0);
        }
        return result;
    }

    /**
     * 暂存商机（前端POST /business/saveDraft）
     */
    @PostMapping("/saveDraft")
    public Map<String, Object> saveDraft(@RequestBody Business business) {
        Map<String, Object> result = new HashMap<>();
        try {
            // 强制兜底所有必填字段
            if (business.getNextTrackTime() == null) business.setNextTrackTime(LocalDate.now());
            if (business.getCreateTime() == null) business.setCreateTime(LocalDate.now());
            if (business.getUpdateTime() == null) business.setUpdateTime(LocalDate.now());
            if (business.getTrackStatus() == null) business.setTrackStatus("0");

            int count;
            if (business.getId() == null) {
                count = businessService.insert(business);
            } else {
                count = businessService.update(business);
            }
            result.put("code", 200);
            result.put("msg", "暂存成功");
            result.put("data", count);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 500);
            result.put("msg", "暂存失败：" + e.getMessage());
            result.put("data", 0);
        }
        return result;
    }

    /**
     * 转为成交客户（前端POST /business/convertDeal）
     */
    @PostMapping("/convertDeal")
    public Map<String, Object> convertDeal(@RequestBody Business business) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (business.getId() == null) {
                throw new RuntimeException("商机ID不能为空");
            }
            // 强制设置成交状态
            business.setTrackStatus("2");
            business.setUpdateTime(LocalDate.now());
            int count = businessService.update(business);

            result.put("code", 200);
            result.put("msg", "转为成交客户成功");
            result.put("data", count);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", 500);
            result.put("msg", "转换失败：" + e.getMessage());
            result.put("data", 0);
        }
        return result;
    }
}