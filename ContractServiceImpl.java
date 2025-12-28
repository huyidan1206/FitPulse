package com.example.fitness.service;

import com.example.fitness.entity.Contract;
import com.example.fitness.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Override
    public List<Contract> selectList(Contract contract) {
        return contractMapper.selectList(contract);
    }

    @Override
    @Transactional
    public int insert(Contract contract) {
        // 验证商机是否已存在合同
        Contract exist = contractMapper.selectByBusinessId(contract.getBusinessId());
        if (exist != null) {
            throw new RuntimeException("该商机已存在合同");
        }
        return contractMapper.insert(contract);
    }

    @Override
    @Transactional
    public int update(Contract contract) {
        if (contract.getId() == null) {
            throw new RuntimeException("合同ID不能为空");
        }
        return contractMapper.update(contract);
    }

    @Override
    @Transactional
    public int sign(Contract contract) {
        if (contract.getId() == null) {
            throw new RuntimeException("合同ID不能为空");
        }
        return contractMapper.sign(contract);
    }

    @Override
    public Contract selectByBusinessId(Long businessId) {
        return contractMapper.selectByBusinessId(businessId);
    }
}