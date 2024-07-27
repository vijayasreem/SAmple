
package com.sacral.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "azbj_account_details")
public class BankDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "POLICY_REF")
    private String policyRef;

    @Column(name = "CONTRACT_ID")
    private String contractId;

    @Column(name = "PARTNER_ID")
    private String partnerId;

    @Column(name = "ACCOUNT_NO")
    private String accountNo;

    @Column(name = "COLL_BRANCH")
    private String collBranch;

    @Column(name = "IFSC_CODE")
    private String ifscCode;

    @Column(name = "ACC_HOLDER_NAME")
    private String accHolderName;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "PAYEE_RELATION")
    private String payeeRelation;

    @Column(name = "MICR")
    private String micr;

    @Column(name = "Pay_mode")
    private String payMode;

    @Column(name = "ACC_TPP_RELATION")
    private String accTppRelation;

    @Column(name = "RRB_BANK_ACCOUNT")
    private String rrbBankAccount;

    @Column(name = "ip_rel_with_pp")
    private String ipRelWithPp;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyRef() {
        return policyRef;
    }

    public void setPolicyRef(String policyRef) {
        this.policyRef = policyRef;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getCollBranch() {
        return collBranch;
    }

    public void setCollBranch(String collBranch) {
        this.collBranch = collBranch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPayeeRelation() {
        return payeeRelation;
    }

    public void setPayeeRelation(String payeeRelation) {
        this.payeeRelation = payeeRelation;
    }

    public String getMicr() {
        return micr;
    }

    public void setMicr(String micr) {
        this.micr = micr;
    }

    public String getPayMode() {
        return payMode;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getAccTppRelation() {
        return accTppRelation;
    }

    public void setAccTppRelation(String accTppRelation) {
        this.accTppRelation = accTppRelation;
    }

    public String getRrbBankAccount() {
        return rrbBankAccount;
    }

    public void setRrbBankAccount(String rrbBankAccount) {
        this.rrbBankAccount = rrbBankAccount;
    }

    public String getIpRelWithPp() {
        return ipRelWithPp;
    }

    public void setIpRelWithPp(String ipRelWithPp) {
        this.ipRelWithPp = ipRelWithPp;
    }
}
