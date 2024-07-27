
package com.sacral.repository;

import com.sacral.model.AccountDet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountDetRepository extends JpaRepository<AccountDet, Long> {

    @Query(value = "SELECT BANK_NAME, BANK_BRANCH, BANK_MICR FROM azbj_bank_ifsc_detail WHERE BANK_IFSC = :ifscCode", nativeQuery = true)
    AccountDet findByIfscCode(String ifscCode);

    @Query(value = "SELECT BANK_IFSC, BANK_NAME, BANK_BRANCH, BANK_MICR FROM azbj_bank_ifsc_detail WHERE BANK_IFSC = :ifscCode", nativeQuery = true)
    List<AccountDet> findPossibleIfscCodes(String ifscCode);
}
