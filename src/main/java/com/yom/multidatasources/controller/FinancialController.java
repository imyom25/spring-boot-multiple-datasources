package com.yom.multidatasources.controller;

import com.yom.multidatasources.dto.BankDTO;
import com.yom.multidatasources.dto.InsuranceDTO;
import com.yom.multidatasources.dto.UserInfo;
import com.yom.multidatasources.service.BankService;
import com.yom.multidatasources.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by yogendra on 28/4/18.
 */
@RestController
public class FinancialController {

    private BankService bankService;
    private InsuranceService insuranceService;

    @Autowired
    public FinancialController(BankService bankService, InsuranceService insuranceService) {
        this.bankService = bankService;
        this.insuranceService = insuranceService;
    }

    @GetMapping(value = "/users",consumes = APPLICATION_JSON_VALUE,produces = APPLICATION_JSON_VALUE)
    public UserInfo getUserInformation(@RequestParam("userId") String userId){

        BankDTO bankDTO = bankService.findByUserId(userId);
        InsuranceDTO insuranceDTO = insuranceService.findByUserId(userId);

        return buildUserInfo(bankDTO, insuranceDTO);

    }

    private UserInfo buildUserInfo(BankDTO bankDTO, InsuranceDTO insuranceDTO) {

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(bankDTO.getUserId());
        userInfo.setAccountNumber(bankDTO.getAccountId());
        userInfo.setAccountStatus(bankDTO.getStatus());
        userInfo.setAccountType(bankDTO.getAccountType());
        userInfo.setAccountBalance(bankDTO.getAccountBalance());

        userInfo.setPolicyNumber(insuranceDTO.getPolicyId());
        userInfo.setInsuranceType(insuranceDTO.getInsuranceType());
        userInfo.setInsuranceStatus(insuranceDTO.getStatus());
        userInfo.setPolicyOwner(insuranceDTO.getPolicyOwner());
        return userInfo;
    }

}
