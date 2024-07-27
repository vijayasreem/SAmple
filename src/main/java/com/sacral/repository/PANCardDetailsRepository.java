
package com.sacral.repository;

import com.sacral.model.PANCardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PANCardDetailsRepository extends JpaRepository<PANCardDetails, Long> {

    @Query(value = "SELECT ip_dob, ph_dob FROM azbj_proposal_appln_det WHERE appln_no = :applnNo AND de_flag = 'D2'", nativeQuery = true)
    Object[] getDateOfBirth(String applnNo);

    @Query(value = "SELECT ip_dob, ph_dob FROM azbj_proposal_appln_det WHERE appln_no = :applnNo AND de_flag = 'D1'", nativeQuery = true)
    Object[] getDateOfBirthFallback(String applnNo);

    @Query(value = "SELECT 'Y' FROM DUAL WHERE REGEXP_LIKE (UPPER(:panCard), '^[A-Z]{3}[C,P,H,F,A,T,B,L,J,G][A-Z][0-9]{4}[A-Z]')", nativeQuery = true)
    String validatePANCardFormat(String panCard);

    @Query(value = "SELECT father_name FROM azbj_partner_extn WHERE part_id = CASE WHEN :ipPh = 'IP' THEN :ipPartId ELSE :phPartId END", nativeQuery = true)
    String getFatherName(String ipPh, String ipPartId, String phPartId);

    @Query(value = "SELECT * FROM AZBJ_PAN_DTLS WHERE pan_seq_no = :panSeqNo", nativeQuery = true)
    Object[] getPanDetails(String panSeqNo);

    @Query(value = "SELECT TRIM(first_name), TRIM(middle_name), TRIM(surname) FROM cp_partners WHERE part_id = :partId", nativeQuery = true)
    Object[] getPartnerDetails(String partId);
}
