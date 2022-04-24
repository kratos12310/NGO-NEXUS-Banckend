package com.example.speproject.controller;


import com.example.speproject.bean.Ngo;
import com.example.speproject.service.ngoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin("*")
public class ngoController {

    @Autowired
    private ngoService ngoservice;


    @PostMapping("/saveNgo")
    public Ngo saveNgo(@RequestBody Ngo ngo) {
        return ngoservice.saveNgo(ngo);
    }


      @GetMapping("/ngolist")
      public List<Ngo> fetchNgoList(){
        return ngoservice.fetchNgoList();
    }
    @PostMapping("/login")
    public Ngo login(@RequestBody Ngo credentials) {
        Ngo u = ngoservice.login(credentials.getEmail(),credentials.getPassword());
        System.out.println(u.getName());
        return u;
    }
    @GetMapping("/ngocategory/{category}")
    public List<Ngo> fetchNgoByCategory(@PathVariable("category") String category){
        return ngoservice.fetchNgoByCategory(category);

    }

    //passing a path variable
    @GetMapping("/ngolist/{id}")
    public Ngo FetchNgoById(@PathVariable("id") Long id) {

        return ngoservice.FetchNgoById(id);
    }

    @DeleteMapping("/ngolist/{id}")
    public String DeleteNgoById(@PathVariable("id") Long id) {
        ngoservice.DeleteNgoById(id);
        return "Department Deleted Successfully";
    }

    @PutMapping("ngolist/{id}")
    public Ngo UpdateNgoById(@PathVariable("id") Long id, @RequestBody Ngo ngo) {
        return ngoservice.UpdateNgoById(id, ngo);
    }

    @PostMapping(path = "/uploadNgo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Ngo uploadFile(@RequestParam MultipartFile file, @RequestParam String name,
                          @RequestParam String category, @RequestParam String vision, @RequestParam String address,
                          @RequestParam String loc, @RequestParam String phoneno, @RequestParam String desc,
                          @RequestParam String email,@RequestParam String campaign1,@RequestParam String campaign2,
                          @RequestParam String campaign3) {

        Ngo ngo = new Ngo();
        ngo.setName(name);
        ngo.setDesc(desc);
        ngo.setPhoneno(phoneno);
        ngo.setCategory(category);
        ngo.setAddress(address);

        ngo.setVision(vision);
        ngo.setLoc(loc);
        ngo.setEmail(email);
        ngo.setCampaign1(campaign1);
        ngoservice.saveNgo(ngo);
        Long id=ngo.getId();
        String file_name = ngoservice.uploadImage(file, ngo);
        if (file_name == null) {
            return null;
        }

        ngo.setLogo(file_name);
        ngoservice.UpdateNgoById(id, ngo);
        return ngo;
    }

    @GetMapping(value = "/ngo/{id}")
    public ResponseEntity<Resource> getNgoImage(@PathVariable("id") String ngoId) {

        System.out.println(ngoId);
        Ngo ngo = ngoservice.FetchNgoById(Long.parseLong(ngoId));

        if (ngo == null) {
            return ResponseEntity.notFound().build();
        }

        Resource image = ngoservice.loadImage(ngo);

        if (image == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;name=" + image.getFilename()).body(image);
    }


}
