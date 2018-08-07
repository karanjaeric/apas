package com.apas.controller;
import com.apas.dao.ContributionDao;
import com.apas.model.Contribution;
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

public class ContributionController {

    @Autowired
    ContributionDao contributionDao;
    
    @GetMapping("/contributions/{memberNo}")
    public List<Contribution> getContributionsByMemberNo(@PathVariable(value = "memberNo") String memberNo) {
        return contributionDao.findByMemberNo(memberNo);
        
    }
    
     @PostMapping("/contributions")
    public Contribution saveContribution(@Valid @RequestBody Contribution contribution) {
        return contributionDao.save(contribution);

    }
    
}
