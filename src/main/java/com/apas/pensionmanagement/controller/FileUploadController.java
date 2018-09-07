package com.apas.pensionmanagement.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/")
public class FileUploadController {

    @PostMapping("/test")
    public String handleFileUpload(@RequestParam("file") String file, @RequestParam("desc") String desc,
            RedirectAttributes redirectAttributes) {
        System.out.println("Description of the file is " + desc);

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded "+ "!");

        return "redirect:/";
    }

}
