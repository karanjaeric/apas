package com.apas.model;

import com.apas.enumeration.ContributionStatus;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "closing_balances")
@EntityListeners(AuditingEntityListener.class)
public class ClosingBalance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //opening balances
    private BigDecimal openingEe;
    private BigDecimal openingEr;
    private BigDecimal openingAvc;
    //contributions made
    private BigDecimal eeContributions;
    private BigDecimal erContributions;
    private BigDecimal avcContributions;
    //interst on opening balances
    private BigDecimal interstonOpeningee;
    private BigDecimal interstonOpeninger;
    private BigDecimal interstonOpeningavc;
    //Interst on contributions
    private BigDecimal interstonContributionsee;
    private BigDecimal interstonContributionser;
    private BigDecimal interstonContributionsavc;
    
    
    private Long accountingPeriodId;
    private String memberNo;
    private BigDecimal totalBalance;
    private ContributionStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getOpeningEe() {
        return openingEe;
    }

    public void setOpeningEe(BigDecimal openingEe) {
        this.openingEe = openingEe;
    }

    public BigDecimal getOpeningEr() {
        return openingEr;
    }

    public void setOpeningEr(BigDecimal openingEr) {
        this.openingEr = openingEr;
    }

    public BigDecimal getOpeningAvc() {
        return openingAvc;
    }

    public void setOpeningAvc(BigDecimal openingAvc) {
        this.openingAvc = openingAvc;
    }

    public BigDecimal getEeContributions() {
        return eeContributions;
    }

    public void setEeContributions(BigDecimal eeContributions) {
        this.eeContributions = eeContributions;
    }

    public BigDecimal getErContributions() {
        return erContributions;
    }

    public void setErContributions(BigDecimal erContributions) {
        this.erContributions = erContributions;
    }

    public BigDecimal getAvcContributions() {
        return avcContributions;
    }

    public void setAvcContributions(BigDecimal avcContributions) {
        this.avcContributions = avcContributions;
    }

    public BigDecimal getInterstonOpeningee() {
        return interstonOpeningee;
    }

    public void setInterstonOpeningee(BigDecimal interstonOpeningee) {
        this.interstonOpeningee = interstonOpeningee;
    }

    public BigDecimal getInterstonOpeninger() {
        return interstonOpeninger;
    }

    public void setInterstonOpeninger(BigDecimal interstonOpeninger) {
        this.interstonOpeninger = interstonOpeninger;
    }

    public BigDecimal getInterstonOpeningavc() {
        return interstonOpeningavc;
    }

    public void setInterstonOpeningavc(BigDecimal interstonOpeningavc) {
        this.interstonOpeningavc = interstonOpeningavc;
    }

    public BigDecimal getInterstonContributionsee() {
        return interstonContributionsee;
    }

    public void setInterstonContributionsee(BigDecimal interstonContributionsee) {
        this.interstonContributionsee = interstonContributionsee;
    }

    public BigDecimal getInterstonContributionser() {
        return interstonContributionser;
    }

    public void setInterstonContributionser(BigDecimal interstonContributionser) {
        this.interstonContributionser = interstonContributionser;
    }

    public BigDecimal getInterstonContributionsavc() {
        return interstonContributionsavc;
    }

    public void setInterstonContributionsavc(BigDecimal interstonContributionsavc) {
        this.interstonContributionsavc = interstonContributionsavc;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    public ContributionStatus getStatus() {
        return status;
    }

    public void setStatus(ContributionStatus status) {
        this.status = status;
    }

    public Long getAccountingPeriodId() {
        return accountingPeriodId;
    }

    public void setAccountingPeriodId(Long accountingPeriodId) {
        this.accountingPeriodId = accountingPeriodId;
    }



    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClosingBalance)) {
            return false;
        }
        ClosingBalance other = (ClosingBalance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apas.model.ClosingBalance[ id=" + id + " ]";
    }

}
