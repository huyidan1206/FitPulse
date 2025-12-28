package com.example.fitness.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Contract {
    private Long id;
    private String customerName;
    private String customerPhone;
    private String idCard;
    private String channelName;
    private String activityName;
    private BigDecimal contractAmount;
    private String contractFile; // 合同文件URL
    private String contractFileName; // 合同文件名
    private Integer contractStatus; // 1-已签约 0-未签约
    private Long businessId; // 关联商机ID（一对一）
    private String createBy;
    private LocalDate createTime;
    private String updateBy;
    private LocalDate updateTime;

    // 构造方法
    public Contract() {}

    public Contract(Long id, String customerName, String customerPhone, String idCard,
                    String channelName, String activityName, BigDecimal contractAmount,
                    String contractFile, String contractFileName, Integer contractStatus,
                    Long businessId, String createBy, LocalDate createTime,
                    String updateBy, LocalDate updateTime) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.idCard = idCard;
        this.channelName = channelName;
        this.activityName = activityName;
        this.contractAmount = contractAmount;
        this.contractFile = contractFile;
        this.contractFileName = contractFileName;
        this.contractStatus = contractStatus;
        this.businessId = businessId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    // getter和setter方法
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCustomerPhone() { return customerPhone; }
    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }
    public String getIdCard() { return idCard; }
    public void setIdCard(String idCard) { this.idCard = idCard; }
    public String getChannelName() { return channelName; }
    public void setChannelName(String channelName) { this.channelName = channelName; }
    public String getActivityName() { return activityName; }
    public void setActivityName(String activityName) { this.activityName = activityName; }
    public BigDecimal getContractAmount() { return contractAmount; }
    public void setContractAmount(BigDecimal contractAmount) { this.contractAmount = contractAmount; }
    public String getContractFile() { return contractFile; }
    public void setContractFile(String contractFile) { this.contractFile = contractFile; }
    public String getContractFileName() { return contractFileName; }
    public void setContractFileName(String contractFileName) { this.contractFileName = contractFileName; }
    public Integer getContractStatus() { return contractStatus; }
    public void setContractStatus(Integer contractStatus) { this.contractStatus = contractStatus; }
    public Long getBusinessId() { return businessId; }
    public void setBusinessId(Long businessId) { this.businessId = businessId; }
    public String getCreateBy() { return createBy; }
    public void setCreateBy(String createBy) { this.createBy = createBy; }
    public LocalDate getCreateTime() { return createTime; }
    public void setCreateTime(LocalDate createTime) { this.createTime = createTime; }
    public String getUpdateBy() { return updateBy; }
    public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }
    public LocalDate getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalDate updateTime) { this.updateTime = updateTime; }
}