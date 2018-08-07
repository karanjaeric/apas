/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apas.model.Beneficiary;
import java.util.List;

/**
 *
 * @author ekaranja
 */

public interface BeneficiaryRepository extends JpaRepository<Beneficiary,Long> {
     List<Beneficiary>findByMemberNo(String memberNo);
    
}
