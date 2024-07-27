
package com.sacral.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contract_id")
    private Long contractId;

    @Column(name = "event_no")
    private Long eventNo;

    @Column(name = "status")
    private String status;

    // Add any additional fields or relationships as needed

    public Comment() {
    }

    public Comment(Long contractId, Long eventNo, String status) {
        this.contractId = contractId;
        this.eventNo = eventNo;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getEventNo() {
        return eventNo;
    }

    public void setEventNo(Long eventNo) {
        this.eventNo = eventNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Add any additional getters and setters as needed

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", contractId=" + contractId +
                ", eventNo=" + eventNo +
                ", status='" + status + '\'' +
                '}';
    }
}
