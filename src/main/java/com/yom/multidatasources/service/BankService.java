package com.yom.multidatasources.service;

import com.yom.multidatasources.dto.BankDTO;

/**
 * Created by yogendra on 28/4/18.
 */
public interface BankService {

    BankDTO findByUserId(String userId);
}
