package com.yom.multidatasources.dto;

import com.yom.multidatasources.insurance.enums.InsuranceStatus;
import com.yom.multidatasources.insurance.enums.InsuranceType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by yogendra on 28/4/18.
 */
@Setter
@Getter
@ToString
public class InsuranceDTO {

    private String policyId;

    private String userId;

    private String createdBy;

    private Timestamp createdOn;

    private String modifiedBy;

    private Timestamp modifiedOn;

    private InsuranceStatus status;

    private InsuranceType insuranceType;

    private String policyOwner;

    private Date policyExpiresOn;

}
