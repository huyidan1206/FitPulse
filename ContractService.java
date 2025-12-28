package com.example.fitness.service;

import com.example.fitness.entity.Contract;
import java.util.List;

public interface ContractService {
    List<Contract> selectList(Contract contract);
    int insert(Contract contract);
    int update(Contract contract);
    int sign(Contract contract);
    Contract selectByBusinessId(Long businessId);
}
