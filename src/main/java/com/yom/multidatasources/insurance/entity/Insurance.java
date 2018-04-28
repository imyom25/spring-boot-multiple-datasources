package com.yom.multidatasources.insurance.entity;

import com.yom.multidatasources.insurance.enums.InsuranceStatus;
import com.yom.multidatasources.insurance.enums.InsuranceType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by yogendra on 19/4/18.
 */
@Entity
@Setter
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Insurance implements Serializable {

    private static final long serialVersionUID = 5L;

    @Id
    private String policyId;

    private String userId;

    private String createdBy;

    private Timestamp createdOn;

    private String modifiedBy;

    private Timestamp modifiedOn;

    @Enumerated(EnumType.STRING)
    private InsuranceStatus status;

    @Enumerated(EnumType.STRING)
    private InsuranceType insuranceType;

    private String policyOwner;

    private Date policyExpiresOn;

}
