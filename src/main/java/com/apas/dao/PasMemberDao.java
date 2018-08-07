/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apas.dao;

import com.apas.model.PasMember;
import com.apas.repository.PasMemberRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ekaranja
 */
@Service
public class PasMemberDao {

    @Autowired
    PasMemberRepository pasMemberRepository;

    public PasMember save(PasMember member) {
        return pasMemberRepository.save(member);
    }
    
     public PasMember findByEmailAddressAndPassword(String emailAddress,String Password) {
        return pasMemberRepository.findByEmailAddressAndPassword(emailAddress, Password);
    }
     
     public List<PasMember> findAll(){
         return pasMemberRepository.findAll();
         
     }

}
