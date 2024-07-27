
package com.sacral.model;

import javax.persistence.*;

@Entity
@Table(name = "kyc_document")
public class KycDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Add your entity fields here

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Add getters and setters for your entity fields here

}
