package com.apas.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apas.model.Beneficiary;
import com.apas.repository.BeneficiaryRepository;
import java.util.List;

@Service
public class BeneficiaryDao {
    
    @Autowired
    BeneficiaryRepository beneficiaryRepository;
    
    public Beneficiary save(Beneficiary beneficiary){
        return beneficiaryRepository.save(beneficiary);
    
    }
    
    public List<Beneficiary>findBeneficiariesByMemberId(String memberNo){
        return beneficiaryRepository.findByMemberNo(memberNo);
    
    }
    
}
