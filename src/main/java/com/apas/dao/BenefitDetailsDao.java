package com.apas.dao;

import com.apas.model.BenefitDetails;
import com.apas.repository.BenefitDetailsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BenefitDetailsDao {
    
    @Autowired
    BenefitDetailsRepository benefitDetailsRepository;
    
     public BenefitDetails save(BenefitDetails benefitDetails){
        return benefitDetailsRepository.save(benefitDetails);
    
    }
    
    public List<BenefitDetails>findBeneficiariesByMemberId(String memberNo){
        return benefitDetailsRepository.findByMemberNo(memberNo);
    
    }
    
    
}
