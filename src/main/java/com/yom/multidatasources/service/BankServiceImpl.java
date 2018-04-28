package com.yom.multidatasources.service;

import com.yom.multidatasources.banking.entity.Bank;
import com.yom.multidatasources.banking.respository.BankRepository;
import com.yom.multidatasources.dto.BankDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yogendra on 28/4/18.
 */
@Service
public class BankServiceImpl implements BankService {

    private BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }


    @Override
    public BankDTO findByUserId(String userId) {

        Bank bank = bankRepository.findByUserId(userId);
        ModelMapper mapper = new ModelMapper();
        return mapper.map(bank, BankDTO.class);

    }
}
