
package com.sacral.repository;

import com.sacral.model.ApplicationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ApplicationDetailsRepository extends JpaRepository<ApplicationDetails, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE ApplicationDetails ad SET ad.status = 'PENDING_FOR_AUTO_BBU' WHERE ad.applicationNumber = :applicationNumber")
    void updateStatusToPendingForAutoBbu(String applicationNumber);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ApplicationDetails ad SET ad.status = 'FR-AR' WHERE ad.applicationNumber = :applicationNumber")
    void updateStatusToFrAr(String applicationNumber);

    @Query(value = "SELECT ad.contractId FROM ApplicationDetails ad WHERE ad.applicationNumber = :applicationNumber")
    String getContractId(String applicationNumber);

    @Query(value = "SELECT COUNT(btd) FROM BbuTransDtls btd WHERE btd.transId = :activityId AND btd.actionId = 2 AND btd.ruleConfigId IS NOT NULL AND btd.versionNo = (SELECT MAX(btd2.versionNo) FROM BbuTransDtls btd2 WHERE btd2.transId = :activityId)")
    int getRuleErrorCount(Long activityId);

    // Add more custom queries as needed
}
