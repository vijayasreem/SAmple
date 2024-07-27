
package com.sacral.repository;

import com.sacral.model.DeqcSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DeqcSearchRepository extends JpaRepository<DeqcSearch, Long> {

    @Query("SELECT COUNT(*) FROM DeqcDisplay")
    int countRecordsInDeqcDisplay();

    @Query("SELECT d.applicationNumber FROM DeqcDisplay d WHERE d.ch = 'Y'")
    List<String> getApplicationNumbersWithChY();

    @Query("SELECT d.reasonLink FROM DeqcSearch d WHERE d.applicationNumber = :applicationNumber")
    String getReasonLinkByApplicationNumber(String applicationNumber);

    @Modifying
    @Transactional
    @Query("UPDATE DeqcSearch SET reasonLink = :reasonLink WHERE applicationNumber = :applicationNumber")
    void updateReasonLinkByApplicationNumber(String reasonLink, String applicationNumber);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "CALL auto_reject_application(:applicationNumber)")
    void autoRejectApplication(String applicationNumber);

    @Query(nativeQuery = true, value = "SELECT CONT_ID FROM azbj_batch_items WHERE APPLICATION_NO = :applicationNumber AND TRANSACTION_TYPE = 'FRP'")
    String getContractIdByApplicationNumber(String applicationNumber);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "INSERT INTO azbj_uw_comments (event_no, contract_id, policy_no, move_code, policy_status, user_id, comment_date, comments, flag) VALUES (:eventNo, :contractId, :policyNo, 'AZBJ_WEB_OTC', :policyStatus, USER, SYSDATE, :comments, 'N')")
    void insertNewComment(String eventNo, String contractId, String policyNo, String policyStatus, String comments);

}
