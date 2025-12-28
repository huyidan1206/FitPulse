package com.example.fitness.controller;

import com.example.fitness.entity.Contract;
import com.example.fitness.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

// 确保注解正确，路径映射无误
@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    // 文件上传路径（确保目录存在，或自动创建）
    @Value("${file.upload.path:D:/uploads/contract/}")
    private String uploadPath;

    // ========== 修复查询接口 ==========
    @GetMapping("/selectList")
    public Map<String, Object> selectList(
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) String customerPhone,
            @RequestParam(required = false) String idCard,
            @RequestParam(required = false) Integer contractStatus
    ) {
        Map<String, Object> result = new HashMap<>();
        try {
            // 构建查询条件
            Contract contract = new Contract();
            contract.setCustomerName(customerName);
            contract.setCustomerPhone(customerPhone);
            contract.setIdCard(idCard);
            contract.setContractStatus(contractStatus);

            List<Contract> list = contractService.selectList(contract);
            result.put("code", 200);
            result.put("msg", "查询成功");
            result.put("data", list);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "查询失败：" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    // ========== 修复LocalDate反序列化问题 ==========
    @PostMapping("/insert")
    public Map<String, Object> insert(@RequestBody Contract contract) {
        Map<String, Object> result = new HashMap<>();
        try {
            // 手动设置时间（避免前端传递的时间格式问题）
            contract.setCreateTime(LocalDate.now());
            contract.setUpdateTime(LocalDate.now());
            // 补充默认值
            if (contract.getContractStatus() == null) {
                contract.setContractStatus(1); // 新增默认已签约
            }

            int count = contractService.insert(contract);
            result.put("code", 200);
            result.put("msg", "新增成功");
            result.put("data", count);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "新增失败：" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/update")
    public Map<String, Object> update(@RequestBody Contract contract) {
        Map<String, Object> result = new HashMap<>();
        try {
            contract.setUpdateTime(LocalDate.now()); // 手动设置更新时间
            int count = contractService.update(contract);
            result.put("code", 200);
            result.put("msg", "更新成功");
            result.put("data", count);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "更新失败：" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    @PostMapping("/sign")
    public Map<String, Object> sign(@RequestBody Contract contract) {
        Map<String, Object> result = new HashMap<>();
        try {
            contract.setUpdateTime(LocalDate.now());
            contract.setContractStatus(1); // 签订后改为已签约
            int count = contractService.sign(contract);
            result.put("code", 200);
            result.put("msg", "签订成功");
            result.put("data", count);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "签订失败：" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    // ========== 修复文件上传接口 ==========
    @PostMapping("/upload")
    public Map<String, Object> upload(@RequestParam("file") MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (file.isEmpty()) {
                result.put("code", 500);
                result.put("msg", "上传文件不能为空");
                return result;
            }

            // 创建上传目录（确保目录存在）
            File dir = new File(uploadPath);
            if (!dir.exists()) {
                dir.mkdirs(); // 递归创建目录
            }

            // 生成唯一文件名
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = UUID.randomUUID() + suffix;

            // 保存文件
            File dest = new File(uploadPath + fileName);
            file.transferTo(dest);

            // 返回文件访问路径（前端可访问）
            String fileUrl = "/uploads/contract/" + fileName;

            result.put("code", 200);
            result.put("msg", "上传成功");
            result.put("data", Map.of(
                    "fileUrl", fileUrl,
                    "fileName", originalFilename
            ));
        } catch (IOException e) {
            result.put("code", 500);
            result.put("msg", "上传失败：" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    // ========== 新增：配置静态资源访问（让前端能访问上传的文件） ==========
    // 如需通过http://localhost:8080/uploads/contract/xxx.pdf访问文件，需添加此配置
    // 可在主类中添加，或单独创建配置类
}