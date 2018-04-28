package com.yom.multidatasources.insurance.repository;

import com.yom.multidatasources.insurance.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {

    Insurance findByUserId(String userId);
}