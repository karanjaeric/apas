package com.apas.model;

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
@Table(name = "benefit_details")
@EntityListeners(AuditingEntityListener.class)
public class BenefitDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal employee;
    private BigDecimal employer;
    private BigDecimal avc;
    private BigDecimal interest;
    private BigDecimal total;
    private String memberNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getEmployee() {
        return employee;
    }

    public void setEmployee(BigDecimal employee) {
        this.employee = employee;
    }

    public BigDecimal getEmployer() {
        return employer;
    }

    public void setEmployer(BigDecimal employer) {
        this.employer = employer;
    }

    public BigDecimal getAvc() {
        return avc;
    }

    public void setAvc(BigDecimal avc) {
        this.avc = avc;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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
        if (!(object instanceof BenefitDetails)) {
            return false;
        }
        BenefitDetails other = (BenefitDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apas.model.BenefitDetails[ id=" + id + " ]";
    }

}
