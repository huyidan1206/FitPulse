package com.example.fitness.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Business {
    private Long id;
    // 客户信息
    private String customerName; // 客户姓名(必填)
    private String customerPhone; // 客户电话(必填)
    private String idCard; // 身份证号(必填)
    private Integer age; // 年龄(必填)
    private String gender; // 性别(必填)
    private String occupation; // 职业
    private String education; // 学历
    private String wechat; // 微信号(必填)
    private String qq; // QQ号
    private String address; // 地址(必填)
    private BigDecimal height; // 身高(必填)
    private BigDecimal weight; // 体重(必填)
    private Long channelId; // 渠道来源(必填)
    private Long activityId; // 活动信息(非必填)
    private String remark; // 备注

    // 客户意向
    private String intentionType; // 意向类型(必填)
    private String intentionContent; // 意向内容(必填)
    private String fitnessReason; // 健身原因
    private String weeklyTime; // 每周健身时间(必填)
    private BigDecimal intentionAmount; // 意向金额(必填)
    private String otherIntention; // 其他意向

    // 跟踪记录
    private String trackStatus; // 跟踪状态(必填)
    private LocalDate nextTrackTime; // 下次跟进时间(必填)
    private String communicationPoints; // 沟通要点(必填)
    private String communicationSummary; // 沟通纪要

    // 公共字段
    private String createBy;
    private LocalDate createTime;
    private String updateBy;
    private LocalDate updateTime;

    public Business(Long id, String customerName, String customerPhone, String idCard, Integer age, String gender, String occupation, String education, String wechat, String qq, String address, BigDecimal height, BigDecimal weight, Long channelId, Long activityId, String remark, String intentionType, String intentionContent, String fitnessReason, String weeklyTime, BigDecimal intentionAmount, String otherIntention, String trackStatus, LocalDate nextTrackTime, String communicationPoints, String communicationSummary, String createBy, LocalDate createTime, String updateBy, LocalDate updateTime) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.idCard = idCard;
        this.age = age;
        this.gender = gender;
        this.occupation = occupation;
        this.education = education;
        this.wechat = wechat;
        this.qq = qq;
        this.address = address;
        this.height = height;
        this.weight = weight;
        this.channelId = channelId;
        this.activityId = activityId;
        this.remark = remark;
        this.intentionType = intentionType;
        this.intentionContent = intentionContent;
        this.fitnessReason = fitnessReason;
        this.weeklyTime = weeklyTime;
        this.intentionAmount = intentionAmount;
        this.otherIntention = otherIntention;
        this.trackStatus = trackStatus;
        this.nextTrackTime = nextTrackTime;
        this.communicationPoints = communicationPoints;
        this.communicationSummary = communicationSummary;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
    }

    public Business() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIntentionType() {
        return intentionType;
    }

    public void setIntentionType(String intentionType) {
        this.intentionType = intentionType;
    }

    public String getIntentionContent() {
        return intentionContent;
    }

    public void setIntentionContent(String intentionContent) {
        this.intentionContent = intentionContent;
    }

    public String getFitnessReason() {
        return fitnessReason;
    }

    public void setFitnessReason(String fitnessReason) {
        this.fitnessReason = fitnessReason;
    }

    public String getWeeklyTime() {
        return weeklyTime;
    }

    public void setWeeklyTime(String weeklyTime) {
        this.weeklyTime = weeklyTime;
    }

    public BigDecimal getIntentionAmount() {
        return intentionAmount;
    }

    public void setIntentionAmount(BigDecimal intentionAmount) {
        this.intentionAmount = intentionAmount;
    }

    public String getOtherIntention() {
        return otherIntention;
    }

    public void setOtherIntention(String otherIntention) {
        this.otherIntention = otherIntention;
    }

    public String getTrackStatus() {
        return trackStatus;
    }

    public void setTrackStatus(String trackStatus) {
        this.trackStatus = trackStatus;
    }

    public LocalDate getNextTrackTime() {
        return nextTrackTime;
    }

    public void setNextTrackTime(LocalDate nextTrackTime) {
        this.nextTrackTime = nextTrackTime;
    }

    public String getCommunicationPoints() {
        return communicationPoints;
    }

    public void setCommunicationPoints(String communicationPoints) {
        this.communicationPoints = communicationPoints;
    }

    public String getCommunicationSummary() {
        return communicationSummary;
    }

    public void setCommunicationSummary(String communicationSummary) {
        this.communicationSummary = communicationSummary;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }
}
