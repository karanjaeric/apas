package com.apas.controller;

import com.apas.dao.PasMemberDao;
import com.apas.model.PasMember;
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
public class PasMemberController {

    @Autowired
    PasMemberDao pasMemberDao;

    @PostMapping("/members")
    public PasMember createMember(@Valid @RequestBody PasMember member) {
        return pasMemberDao.save(member);

    }

    @GetMapping("/members/{emailAddress}/{password}")
    public PasMember logInUsingEmailAddressAndPassword(@PathVariable(value = "emailAddress") String emailAdress, @PathVariable(value = "password") String password) {
        return pasMemberDao.findByEmailAddressAndPassword(emailAdress, password);

    }

    @GetMapping("/members")
    public JsonResponse findAll() {
//        Map<String, List<PasMember>> members = new HashMap<>();
//        members.put("members", pasMemberDao.findAll());
//        Map<Map<String,Integer>, Map<String, List<PasMember>>> finalOutput = new HashMap<>();
//        Map<String,Integer> totalCount=new HashMap<>();
//        totalCount.put("totalCount", pasMemberDao.findAll().size());
//        finalOutput.put(totalCount, members);
//        return finalOutput;.
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.setData(pasMemberDao.findAll());
        jsonResponse.setTotalCount(pasMemberDao.findAll().size());
        
        return jsonResponse;
    }

}
