package com.sacral.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PANCardDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ipDob;
    private String phDob;

    public PANCardDetails() {
    }

    public PANCardDetails(String ipDob, String phDob) {
        this.ipDob = ipDob;
        this.phDob = phDob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIpDob() {
        return ipDob;
    }

    public void setIpDob(String ipDob) {
        this.ipDob = ipDob;
    }

    public String getPhDob() {
        return phDob;
    }

    public void setPhDob(String phDob) {
        this.phDob = phDob;
    }
}