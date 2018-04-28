package com.yom.multidatasources.dto;

import com.yom.multidatasources.banking.enums.AccountStatus;
import com.yom.multidatasources.banking.enums.AccountType;
import com.yom.multidatasources.insurance.enums.InsuranceStatus;
import com.yom.multidatasources.insurance.enums.InsuranceType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Created by yogendra on 28/4/18.
 */
@Setter
@Getter
@ToString
public class UserInfo {

    private String userId;
    private String accountNumber;
    private AccountType accountType;
    private AccountStatus accountStatus;
    private BigDecimal accountBalance;

    private String policyNumber;
    private InsuranceStatus insuranceStatus;
    private InsuranceType insuranceType;
    private String policyOwner;

}
