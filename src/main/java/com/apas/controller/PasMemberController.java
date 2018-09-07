package com.apas.controller;

import com.apas.dao.PasMemberDao;
import com.apas.model.PasMember;
import com.apas.storage.StorageService;
import com.apas.util.JsonUtil;
import com.apas.util.ResponseObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/member")
public class PasMemberController {

    private final StorageService storageService;

    @Autowired
    public PasMemberController(StorageService storageService) {
        this.storageService = storageService;
    }

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

    @PostMapping("/test")
    public ResponseObject handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam("desc") String desc,
            RedirectAttributes redirectAttributes) throws JsonProcessingException {
        System.out.println("Description of the file is " + desc);
        System.out.println("uploaded file is " + file.getOriginalFilename());
        storageService.store(file);
        ResponseObject responseObject = new ResponseObject();
        responseObject.setMessage("File saved successfully");
        responseObject.setSuccess(true);

        return responseObject;
        

    }
    
       @PostMapping("/test1")
    public ResponseObject test(
            RedirectAttributes redirectAttributes) throws JsonProcessingException {
      
        ResponseObject responseObject = new ResponseObject();
        responseObject.setMessage("File saved successfully");

        return responseObject;

    }

}
