package com.apas.controller;

import com.apas.dao.BeneficiaryDao;
import com.apas.model.Beneficiary;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BeneficiaryController {
    @Autowired
    BeneficiaryDao beneficiaryDao;
    
    @PostMapping("/beneficiaries")
    public Beneficiary createClosingBalance(@Valid @RequestBody Beneficiary beneficiary) {
        return beneficiaryDao.save(beneficiary);

    }
   
      @GetMapping("/beneficiaries/{memberNo}")
    public List<Beneficiary> getClosingBalanceByMemberNo(@PathVariable(value = "memberNo") String memberNo) {
        return beneficiaryDao.findBeneficiariesByMemberId(memberNo);

    }
    
}
