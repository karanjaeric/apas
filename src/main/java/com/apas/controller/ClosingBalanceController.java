package com.apas.controller;

import com.apas.dao.ClosingBalanceDao;
import com.apas.model.ClosingBalance;
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
public class ClosingBalanceController {

    @Autowired
    ClosingBalanceDao closingBalanceDao;

    @PostMapping("/closingbalances")
    public ClosingBalance createClosingBalance(@Valid @RequestBody ClosingBalance closingBalance) {
        return closingBalanceDao.save(closingBalance);

    }

    @GetMapping("/closingbalances/{memberNo}")
    public List<ClosingBalance> getClosingBalanceByMemberNo(@PathVariable(value = "memberNo") String memberNo) {
        return closingBalanceDao.findByMemberNo(memberNo);

    }

}
