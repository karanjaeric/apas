/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.repository;

import com.apas.model.ClosingBalance;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ekaranja
 */
public interface ClosingBalanceRepository extends JpaRepository<ClosingBalance,Long>  {
    List<ClosingBalance>findByMemberNo(String memberNo);
    
}
