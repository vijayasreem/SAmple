
package com.sacral.repository;

import com.sacral.model.DeqcDisplay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeqcDisplayRepository extends JpaRepository<DeqcDisplay, Long> {

    @Query(value = "SELECT perm_receipt_no, proposal_no, proposal_status " +
            "FROM azbj_phub_tracker " +
            "WHERE application_no = :applicationNumber", nativeQuery = true)
    void getCaseDetails(String applicationNumber);

    @Query(value = "SELECT TO_NUMBER(product_code) " +
            "FROM azbj_batch_items " +
            "WHERE application_no = :applicationNumber " +
            "AND transaction_type = 'FRP' " +
            "AND NVL(PRINT, 'X') <> 'C'", nativeQuery = true)
    void getProductId(String applicationNumber);

    @Query(value = "SELECT COUNT() " +
            "FROM azbj_phub_scrutiny_prop " +
            "WHERE application_no = :applicationNumber", nativeQuery = true)
    void getCaseCount(String applicationNumber);

    @Query(value = "INSERT INTO azbj_landing_form_data (user_id, appln_no, start_time, flag) " +
            "VALUES (USER, :applicationNumber, SYSDATE, 'DEQC')", nativeQuery = true)
    void insertFormData(String applicationNumber);

    @Query(value = "SELECT COUNT() " +
            "FROM azbj_system_constants " +
            "WHERE sys_type = 'QC' AND sys_code = 'QC_RIGHTS'", nativeQuery = true)
    void getQcCount();
}
