
package com.sacral.repository;

import com.sacral.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails, Long> {

    @Query(value = "SELECT COUNT(*) FROM azbj_account_details WHERE policy_ref = :policyRef", nativeQuery = true)
    int countByPolicyRef(String policyRef);

    @Modifying
    @Query(value = "DELETE FROM azbj_account_details WHERE policy_ref = :policyRef", nativeQuery = true)
    void deleteByPolicyRef(String policyRef);

    @Modifying
    @Query(value = "INSERT INTO azbj_account_details (POLICY_REF, CONTRACT_ID, PARTNER_ID, ACCOUNT_NO, COLL_BRANCH, IFSC_CODE, ACC_HOLDER_NAME, BANK_NAME, PAYEE_RELATION, MICR, TIME_STAMP, userid, Pay_mode, ACC_TPP_RELATION, RRB_BANK_ACCOUNT, ip_rel_with_pp) " +
            "VALUES (:policyRef, :contractId, :partnerId, :accountNo, :collBranch, :ifscCode, :accHolderName, :bankName, :payeeRelation, :micr, SYSDATE, USER, :payMode, :accTppRelation, :rrbBankAccount, :ipRelWithPp)", nativeQuery = true)
    void saveBankDetails(String policyRef, String contractId, String partnerId, String accountNo, String collBranch, String ifscCode, String accHolderName, String bankName, String payeeRelation, String micr, String payMode, String accTppRelation, String rrbBankAccount, String ipRelWithPp);
}
