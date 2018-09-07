/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.pensionmanagement.model;

/**
 *
 * @author ekaranja
 */
public enum ContributionStatus {
    REGISTERED("Registered"),
    UNREGISTERED("Unregistered");
    
    private String name;

    private ContributionStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
