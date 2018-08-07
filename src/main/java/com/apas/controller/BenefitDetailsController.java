package com.apas.controller;

import com.apas.dao.BenefitDetailsDao;
import com.apas.model.BenefitDetails;
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
public class BenefitDetailsController {
      @Autowired
    BenefitDetailsDao benefitDetailsDao;
    
    @PostMapping("/benefitdetails")
    public BenefitDetails createBenefitDetails(@Valid @RequestBody  BenefitDetails benefitDetails) {
        return benefitDetailsDao.save(benefitDetails);

    }
   
      @GetMapping("/benefitdetails/{memberNo}")
    public List<BenefitDetails> getBenefitDetailsByMemberNo(@PathVariable(value = "memberNo") String memberNo) {
        return benefitDetailsDao.findBeneficiariesByMemberId(memberNo);

    }
    
}
