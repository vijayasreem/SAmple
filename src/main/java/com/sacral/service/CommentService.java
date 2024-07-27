
package com.sacral.service;

import com.sacral.model.Comment;
import com.sacral.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Long findContractIdByApplicationNo(String applicationNo) {
        return commentRepository.findContractIdByApplicationNo(applicationNo);
    }

    public Long generateNewEventNo(Long contractId) {
        return commentRepository.generateNewEventNo(contractId);
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void updateStatusToReject() {
        commentRepository.updateStatusToReject();
    }

    public void updateStatusToLinkSave() {
        commentRepository.updateStatusToLinkSave();
    }

    public void updateStatusToProposalInvoked() {
        commentRepository.updateStatusToProposalInvoked();
    }

    // Add any additional methods or business logic as needed
}
