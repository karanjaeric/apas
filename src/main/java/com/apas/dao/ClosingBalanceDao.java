package com.apas.dao;

import com.apas.model.ClosingBalance;
import com.apas.repository.ClosingBalanceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClosingBalanceDao {

    @Autowired
    ClosingBalanceRepository closingBalanceRepository;

    public ClosingBalance save(ClosingBalance closingBalance) {
        return closingBalanceRepository.save(closingBalance);
    }

    public List<ClosingBalance> findByMemberNo(String memberNo) {
        return closingBalanceRepository.findByMemberNo(memberNo);
    }

}
