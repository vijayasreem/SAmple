
package com.sacral.repository;

import com.sacral.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    @Query(value = "SELECT p.first_name, p.middle_name, p.surname, p.date_of_birth " +
            "FROM cp_partners p " +
            "WHERE p.part_id = CASE WHEN :ipPh = 'IP' THEN :ipPartId ELSE :phPartId END",
            nativeQuery = true)
    Partner findPartnerDetailsByPanCard(String ipPh, Long ipPartId, Long phPartId);

    @Query(value = "SELECT COUNT(1) " +
            "FROM ocp_policy_bases a, ocp_interested_parties b, cp_partners c " +
            "WHERE a.contract_id = b.contract_id " +
            "AND b.partner_id = c.part_id " +
            "AND c.tax_id = :panCard " +
            "AND a.top_indicator = 'Y' " +
            "AND c.part_id <> :phPartId " +
            "AND a.action_code <> 'D' " +
            "AND b.top_indicator = 'Y' " +
            "AND b.action_code <> 'D' " +
            "AND c.tax_id NOT IN ('AG/NRI/60A', 'AG/NRI/61A') " +
            "AND rownum = 1",
            nativeQuery = true)
    int validatePanCardAgainstPolicies(String panCard, Long phPartId);
}
