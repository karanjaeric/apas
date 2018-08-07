package com.apas.model;
import com.apas.enumeration.PeriodStatus;
import com.apas.enumeration.PeriodType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "accounting_periods")
@EntityListeners(AuditingEntityListener.class)
public class AccountingPeriod implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int accountingPeriodSequence;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String name;
    
    @ManyToOne
    private FinancialYear financialYear;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private AccountingPeriod parentAccountingPeriod;
    
    @Enumerated(EnumType.STRING)
    private PeriodType periodType;
    
    @Enumerated(EnumType.STRING)
    private PeriodStatus periodStatus;
    
    private BigDecimal targetAmount;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccountingPeriodSequence() {
        return accountingPeriodSequence;
    }

    public void setAccountingPeriodSequence(int accountingPeriodSequence) {
        this.accountingPeriodSequence = accountingPeriodSequence;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FinancialYear getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(FinancialYear financialYear) {
        this.financialYear = financialYear;
    }

    public AccountingPeriod getParentAccountingPeriod() {
        return parentAccountingPeriod;
    }

    public void setParentAccountingPeriod(AccountingPeriod parentAccountingPeriod) {
        this.parentAccountingPeriod = parentAccountingPeriod;
    }

    public PeriodType getPeriodType() {
        return periodType;
    }

    public void setPeriodType(PeriodType periodType) {
        this.periodType = periodType;
    }

    public PeriodStatus getPeriodStatus() {
        return periodStatus;
    }

    public void setPeriodStatus(PeriodStatus periodStatus) {
        this.periodStatus = periodStatus;
    }

    public BigDecimal getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(BigDecimal targetAmount) {
        this.targetAmount = targetAmount;
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
        if (!(object instanceof AccountingPeriod)) {
            return false;
        }
        AccountingPeriod other = (AccountingPeriod) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apas.model.AccountingPeriod[ id=" + id + " ]";
    }
    
}
