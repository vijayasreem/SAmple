
package com.sacral.repository;

import com.sacral.model.DeqcSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeqcSearchRepository extends JpaRepository<DeqcSearch, Long> {

    @Query("SELECT d FROM DeqcSearch d WHERE d.moduleType = 'DEQC_SEARCH' AND d.title = 'Reject Applications from DEQC_SEARCH Module'")
    List<DeqcSearch> findRejectApplications();

    @Modifying
    @Transactional
    @Query("UPDATE DeqcSearch d SET d.comments = :comments WHERE d.applicationNumber = :applicationNumber")
    void updateComments(String comments, String applicationNumber);

    @Modifying
    @Transactional
    @Query("UPDATE DeqcSearch d SET d.status = 'Rejected' WHERE d.applicationNumber = :applicationNumber")
    void rejectApplication(String applicationNumber);

    @Query("SELECT d.applicationNumber FROM DeqcSearch d WHERE d.moduleType = 'DEQC_DISPLAY'")
    List<String> getApplicationNumbers();

    @Query("SELECT COUNT(d) FROM DeqcSearch d WHERE d.moduleType = 'DEQC_DISPLAY'")
    int getRecordCount();

    @Query("SELECT d FROM DeqcSearch d WHERE d.moduleType = 'DEQC_DISPLAY' AND d.ch = 'Y'")
    List<DeqcSearch> getRecordsWithChMarked();

    @Query("SELECT d FROM DeqcSearch d WHERE d.moduleType = 'DEQC_DISPLAY' AND d.applicationNumber = :applicationNumber AND d.transactionType = 'FRP'")
    DeqcSearch findByApplicationNumberAndTransactionType(String applicationNumber);

    @Query("SELECT d.reasonLink FROM DeqcSearch d WHERE d.moduleType = 'DEQC_SEARCH'")
    String getReasonLink();

    @Modifying
    @Transactional
    @Query("INSERT INTO DeqcSearchComments (eventNo, contractId, policyNo, moveCode, policyStatus, userId, commentDate, comments, flag) " +
            "VALUES (:eventNo, :contractId, :policyNo, 'AZBJ_WEB_OTC', :policyStatus, :userId, CURRENT_TIMESTAMP, :comments, 'N')")
    void insertComment(String eventNo, String contractId, String policyNo, String policyStatus, String userId, String comments);

    @Query("SELECT d.contractId FROM DeqcSearch d WHERE d.applicationNumber = :applicationNumber AND d.transactionType = 'FRP'")
    String getContractId(String applicationNumber);
}
