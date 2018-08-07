/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.dao;

import com.apas.model.Contribution;
import com.apas.repository.ContributionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ekaranja
 */
@Service
public class ContributionDao {

    @Autowired
    ContributionRepository contributionRepository;

    public Contribution save(Contribution contribution) {
        return contributionRepository.save(contribution);
    }
    
    public List<Contribution> findByMemberNo(String memberNo){
        return contributionRepository.findByMemberNo(memberNo);
    }

}
