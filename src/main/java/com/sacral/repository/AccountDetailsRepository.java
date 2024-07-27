
package com.sacral.repository;

import com.sacral.model.AccountDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {

    @Query(value = "SELECT a.bankIfsc, a.bankName, a.bankBranch, a.bankMicr FROM AccountDetails a WHERE a.bankIfsc = :ifscCode")
    Object[] getBankDetailsByIfscCode(String ifscCode);

    // Add other custom queries or methods as needed

}
