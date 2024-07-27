
package com.sacral.repository;

import com.sacral.model.ApplicationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ApplicationDetailsRepository extends JpaRepository<ApplicationDetails, Long> {

    @Query(value = "SELECT apt.application_no AS appno, apt.proposal_status AS appstatus, abi.perm_receipt_no AS receiptno, abi.perm_receipt_date AS receiptdate, " +
            "apad.ip_title || ' ' || apad.ip_first_name || ' ' || apad.ip_middle_name || ' ' || apad.ip_last_name AS laname, " +
            "apad.ph_title || ' ' || apad.ph_first_name || ' ' || apad.ph_middle_name || ' ' || apad.ph_last_name AS phname, " +
            "azsc.sys_desc AS partnername, apt.received_user AS recuser " +
            "FROM azbj_batch_items abi, azbj_phub_tracker apt, azbj_proposal_appln_det apad, azbj_system_constants azsc " +
            "WHERE apt.application_no = NVL(:applicationNo, apt.application_no) " +
            "AND abi.agent_code = NVL(TRIM(:partnerType), abi.agent_code) " +
            "AND abi.perm_receipt_date BETWEEN NVL(:fromDate, abi.perm_receipt_date) AND NVL(:toDate, abi.perm_receipt_date) " +
            "AND TO_NUMBER(apt.application_no) = apad.appln_no " +
            "AND apad.appln_no = TO_NUMBER(abi.application_no) " +
            "AND apt.application_no = abi.application_no " +
            "AND apt.agent_code = apad.agent_code " +
            "AND apt.agent_code = abi.agent_code " +
            "AND apad.agent_code = abi.agent_code " +
            "AND abi.agent_code = azsc.char_value " +
            "AND apt.agent_code = azsc.char_value " +
            "AND apad.agent_code = azsc.char_value " +
            "AND apt.perm_receipt_no = abi.perm_receipt_no " +
            "AND apt.perm_receipt_no IS NOT NULL " +
            "AND abi.perm_receipt_no IS NOT NULL " +
            "AND azsc.sys_type = 'OTC' " +
            "AND azsc.sys_code = 'OTC_WEB_PARTNERS' " +
            "AND de_flag = 'D2' " +
            "AND proposal_status IN ('PENDING_FOR_BBU', 'PROPOSAL_INVOKED', 'PROPOSAL_UPDATED') " +
            "AND apt.proposal_no IS NULL", nativeQuery = true)
    List<ApplicationDetails> searchApplicationDetails(String applicationNo, String partnerType, Date fromDate, Date toDate);

    @Query(value = "SELECT COUNT(0) FROM azbj_cq_doc_upload_dtls WHERE application_no = TO_CHAR(:appno) AND UPPER(doc_type) NOT IN ('BI', 'PF')", nativeQuery = true)
    int countMissingDocuments(String appno);

    @Query(value = "SELECT COUNT(0) FROM azbj_cq_doc_upload_dtls WHERE application_no = TO_CHAR(:appno) AND UPPER(doc_type) = 'BI'", nativeQuery = true)
    int countBIDocuments(String appno);

    @Query(value = "SELECT COUNT(0) FROM azbj_cq_doc_upload_dtls WHERE application_no = TO_CHAR(:appno) AND UPPER(doc_type) = 'PF'", nativeQuery = true)
    int countPFDocuments(String appno);

    @Query(value = "SELECT COUNT(0) FROM azbj_cq_doc_upload_dtls WHERE application_no = TO_CHAR(:appno) AND UPPER(doc_type) = 'RP'", nativeQuery = true)
    int countPhotoDocuments(String appno);

    @Query(value = "SELECT COUNT(0) FROM azbj_cq_doc_upload_dtls WHERE application_no = TO_CHAR(:appno) AND UPPER(doc_type) = 'M017'", nativeQuery = true)
    int countAgeProofDocuments(String appno);

    @Query(value = "SELECT COUNT(0) FROM azbj_cq_doc_upload_dtls WHERE application_no = TO_CHAR(:appno) AND UPPER(doc_type) = 'M202'", nativeQuery = true)
    int countAddressProofDocuments(String appno);
}
