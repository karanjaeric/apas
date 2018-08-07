/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author ekaranja
 */
@Entity
@Table(name = "members")
@EntityListeners(AuditingEntityListener.class)
public class PasMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonProperty("MemberNo")
    private String memberNo;

    @JsonProperty("Surname")
    private String surname;
    @JsonIgnore
    private String firstName;
    @JsonProperty("OtherNames")
    private String otherNames;
    @JsonProperty("EmailAddress")
    private String emailAddress;
    @JsonProperty("PhoneNumber")
    private String phoneNumber;
     @JsonProperty("Password")
    private String password;
    @JsonProperty("Designation")
    private String designation;
    @JsonProperty("Department")
    private String department;
    @Transient
    @JsonProperty("MemberName")
    private String memberName;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("DateEmployed")
    private LocalDate employmentDate;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("BirthDate")
    private LocalDate dateOfBirth;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("SchemeJoin")
    private LocalDate dateJoinedScheme;
    
    @JsonProperty("PIN")
    private String pin;
    @JsonProperty("Payroll")
    private String payrollNumber;
   @JsonProperty("Title")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMemberName() {
        return this.title + " " + this.surname + " " + this.otherNames;
        // return this.memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = title + " " + this.surname + " " + this.otherNames;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateJoinedScheme() {
        return dateJoinedScheme;
    }

    public void setDateJoinedScheme(LocalDate dateJoinedScheme) {
        this.dateJoinedScheme = dateJoinedScheme;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPayrollNumber() {
        return payrollNumber;
    }

    public void setPayrollNumber(String payrollNumber) {
        this.payrollNumber = payrollNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof PasMember)) {
            return false;
        }
        PasMember other = (PasMember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.apas.model.Member[ id=" + id + " ]";
    }

}
