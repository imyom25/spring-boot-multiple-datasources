package com.yom.multidatasources.banking.entity;

import com.yom.multidatasources.banking.enums.AccountStatus;
import com.yom.multidatasources.banking.enums.AccountType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by yogendra on 19/4/18.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
public class Bank implements Serializable {

    private static final long serialVersionUID = 6L;

    @Id
    private String accountId;

    private String userId;

    private String createdBy;

    private Timestamp createdOn;

    private String modifiedBy;

    private Timestamp modifiedOn;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private String accountOwner;

    private BigDecimal accountBalance;

}
