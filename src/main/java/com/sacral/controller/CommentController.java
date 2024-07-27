package com.sacral.controller;

import com.sacral.model.Comment;
import com.sacral.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/contractId")
    public Long findContractIdByApplicationNo(@RequestParam String applicationNo) {
        return commentService.findContractIdByApplicationNo(applicationNo);
    }

    @GetMapping("/eventNo")
    public Long generateNewEventNo(@RequestParam Long contractId) {
        return commentService.generateNewEventNo(contractId);
    }

    @PostMapping("/")
    public void saveComment(@RequestBody Comment comment) {
        commentService.saveComment(comment);
    }

    @PutMapping("/status/reject")
    public void updateStatusToReject() {
        commentService.updateStatusToReject();
    }

    @PutMapping("/status/linkSave")
    public void updateStatusToLinkSave() {
        commentService.updateStatusToLinkSave();
    }

    @PutMapping("/status/proposalInvoked")
    public void updateStatusToProposalInvoked() {
        commentService.updateStatusToProposalInvoked();
    }

    // Add any additional methods or business logic as needed
}
