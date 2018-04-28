package com.yom.multidatasources.dto;

import com.yom.multidatasources.banking.enums.AccountStatus;
import com.yom.multidatasources.banking.enums.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by yogendra on 28/4/18.
 */
@Setter
@Getter
@ToString
public class BankDTO {

    private String accountId;

    private String userId;

    private String createdBy;

    private Timestamp createdOn;

    private String modifiedBy;

    private Timestamp modifiedOn;

    private AccountStatus status;

    private AccountType accountType;

    private String accountOwner;

    private BigDecimal accountBalance;

}
