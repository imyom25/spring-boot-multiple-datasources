package com.yom.multidatasources.service;

import com.yom.multidatasources.dto.InsuranceDTO;

/**
 * Created by yogendra on 28/4/18.
 */
public interface InsuranceService {

    InsuranceDTO findByUserId(String userId);
}
