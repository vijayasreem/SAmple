
package com.sacral.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "azbj_bank_ifsc_detail")
public class AccountDet {

    @Id
    @Column(name = "BANK_IFSC")
    private String ifscCode;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "BANK_BRANCH")
    private String bankBranch;

    @Column(name = "BANK_MICR")
    private String bankMicr;

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankMicr() {
        return bankMicr;
    }

    public void setBankMicr(String bankMicr) {
        this.bankMicr = bankMicr;
    }
}
