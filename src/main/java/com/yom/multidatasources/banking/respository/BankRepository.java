package com.yom.multidatasources.banking.respository;

import com.yom.multidatasources.banking.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yogendra on 24/4/18.
 */
@Repository
public interface BankRepository extends JpaRepository<Bank,Long> {

    Bank findByUserId(String userId);
}
