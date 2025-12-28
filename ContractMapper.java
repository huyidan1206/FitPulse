package com.example.fitness.mapper;

import com.example.fitness.entity.Contract;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ContractMapper {
    List<Contract> selectList(Contract contract);
    int insert(Contract contract);
    int update(Contract contract);
    int sign(Contract contract); // 签订合同专用
    Contract selectByBusinessId(Long businessId); // 按商机ID查询
}
