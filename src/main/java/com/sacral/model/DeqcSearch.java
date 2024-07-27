
package com.sacral.model;

import javax.persistence.*;

@Entity
@Table(name = "DeqcSearch")
public class DeqcSearch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_number")
    private String applicationNumber;

    @Column(name = "reason_link")
    private String reasonLink;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getReasonLink() {
        return reasonLink;
    }

    public void setReasonLink(String reasonLink) {
        this.reasonLink = reasonLink;
    }
}
