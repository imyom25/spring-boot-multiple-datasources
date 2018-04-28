package com.yom.multidatasources.service;

import com.yom.multidatasources.dto.InsuranceDTO;
import com.yom.multidatasources.insurance.entity.Insurance;
import com.yom.multidatasources.insurance.repository.InsuranceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yogendra on 28/4/18.
 */
@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    public InsuranceServiceImpl(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    private InsuranceRepository insuranceRepository;



    @Override
    public InsuranceDTO findByUserId(String userId) {

        Insurance insuranceEntity = insuranceRepository.findByUserId(userId);

        ModelMapper mapper = new ModelMapper();
        InsuranceDTO insuranceDTO = mapper.map(insuranceEntity,InsuranceDTO.class);

        return insuranceDTO;

    }
}
