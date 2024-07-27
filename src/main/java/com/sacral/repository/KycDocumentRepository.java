
package com.sacral.repository;

import com.sacral.model.KycDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KycDocumentRepository extends JpaRepository<KycDocument, Long> {

    @Query(value = "SELECT azbj_pk0_acc.get_contract_id(?1) FROM dual", nativeQuery = true)
    Long getContractId(String proposalNo);

    @Query(value = "SELECT TAX_ID, DATE_OF_BIRTH, SEX, FIRST_NAME, MIDDLE_NAME, SURNAME " +
            "FROM cp_partners a, wip_interested_parties b " +
            "WHERE CONTRACT_ID = ?1 " +
            "AND a.PART_ID = b.PARTNER_ID " +
            "AND b.IP_NO = 2", nativeQuery = true)
    Object[] getPersonalDetails(Long contractId);
}
