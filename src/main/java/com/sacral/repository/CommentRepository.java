
package com.sacral.repository;

import com.sacral.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT c.contractId FROM BatchItem c WHERE c.applicationNo = :applicationNo AND c.transactionType = 'FRP'")
    Long findContractIdByApplicationNo(String applicationNo);

    @Query(value = "SELECT COALESCE(MAX(c.eventNo) + 1, 1) FROM Comment c WHERE c.contractId = :contractId")
    Long generateNewEventNo(Long contractId);

    void save(Comment comment);

    @Query(value = "UPDATE Comment c SET c.status = 'REJECT' WHERE c.status = 'R'")
    void updateStatusToReject();

    @Query(value = "UPDATE Comment c SET c.status = 'LINK/SAVE' WHERE c.status = 'LS'")
    void updateStatusToLinkSave();

    @Query(value = "UPDATE Comment c SET c.status = 'PROPOSAL_INVOKED' WHERE c.status = 'QC'")
    void updateStatusToProposalInvoked();

    // Add any additional methods or queries as needed
}
