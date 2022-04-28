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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin("*")
public class ngoController {
    Logger logger = LoggerFactory.getLogger(ngoController.class);
    @Autowired
    private ngoService ngoservice;


    @PostMapping("/saveNgo")
    public Ngo saveNgo(@RequestBody Ngo ngo) {
        logger.info("Ngo Saved: "+ngo.getName());
        return ngoservice.saveNgo(ngo);
    }


      @GetMapping("/ngolist")
      public List<Ngo> fetchNgoList(){
        logger.info("Fetched Ngo list");
        return ngoservice.fetchNgoList();

    }
    @PostMapping("/login")
    public Ngo login(@RequestBody Ngo credentials) {
        Ngo u = ngoservice.login(credentials.getEmail(),credentials.getPassword());
        System.out.println(u.getName());
        logger.info(u.getEmail()+" Signed in");
        return u;
    }
    @GetMapping("/ngocategory/{category}")
    public List<Ngo> fetchNgoByCategory(@PathVariable("category") String category){
        logger.info("Fetching Ngo by category");
        return ngoservice.fetchNgoByCategory(category);

    }
    @GetMapping("/ngoq/{search}")
    public List<Ngo> fetchNgoBySearch(@PathVariable("search") String category){
        String name=category;
        logger.info("Fetching Results based on: "+name);
        return ngoservice.fetchNgoBySearch(name,category);

    }

    //passing a path variable
    @GetMapping("/ngolist/{id}")
    public Ngo FetchNgoById(@PathVariable("id") Long id) {
        logger.info("Fetching Ngo Details of: "+id);
        return ngoservice.FetchNgoById(id);
    }

    @DeleteMapping("/ngolist/{id}")
    public String DeleteNgoById(@PathVariable("id") Long id) {
        ngoservice.DeleteNgoById(id);
        logger.info("Ngo "+id+" Deleted");
        return "Department Deleted Successfully";
    }

    @PutMapping("ngolist/{id}")
    public Ngo UpdateNgoById(@PathVariable("id") Long id, @RequestBody Ngo ngo) {
        logger.info("Ngo "+id+" Updated");
        return ngoservice.UpdateNgoById(id, ngo);
    }

    @PutMapping(path = "/uploadNgo/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Ngo uploadFile(@PathVariable("id") Long id, @RequestParam MultipartFile file, @RequestParam String name,
                          @RequestParam String category, @RequestParam String vision, @RequestParam String address,
                          @RequestParam String loc, @RequestParam String phoneno, @RequestParam String desc,
                          @RequestParam String email,@RequestParam String campaign1,@RequestParam String campaign2,
                          @RequestParam String campaign3) {

        Ngo ngo = new Ngo();
        System.out.println(id+" "+name+" "+desc+" "+phoneno+" ");
        ngo.setName(name);
        ngo.setDesc(desc);
        ngo.setPhoneno(phoneno);
        ngo.setCategory(category);
        ngo.setAddress(address);

        ngo.setVision(vision);
        ngo.setLoc(loc);
        ngo.setEmail(email);
        ngo.setCampaign1(campaign1);
        ngoservice.UpdateNgoById(id,ngo);
        String file_name = ngoservice.uploadImage(file, id);
        if (file_name != null) {
            ngo.setLogo(file_name);
        }
        logger.info("Updated Ngo with Banner Photo: "+file_name);

        ngoservice.UpdateNgoById(id, ngo);
        return ngo;
    }
    @PostMapping(path = "/addaNgo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Ngo AddNgo(@RequestParam MultipartFile file, @RequestParam String name,
                          @RequestParam String category, @RequestParam String vision, @RequestParam String address,
                          @RequestParam String loc, @RequestParam String phoneno, @RequestParam String desc,
                          @RequestParam String email,@RequestParam String campaign1,@RequestParam String campaign2,
                          @RequestParam String campaign3,@RequestParam String password) {

        Ngo ngo = new Ngo();
        System.out.println(name+" "+desc+" "+phoneno+" ");
        ngo.setName(name);
        ngo.setDesc(desc);
        ngo.setPhoneno(phoneno);
        ngo.setCategory(category);
        ngo.setAddress(address);
        ngo.setVision(vision);
        ngo.setLoc(loc);
        ngo.setEmail(email);
        ngo.setPassword(password);
        ngo.setCampaign1(campaign1);
        ngo.setCampaign2(campaign2);
        ngo.setCampaign3(campaign3);
        Ngo ng=ngoservice.saveNgo(ngo);
        Long id =ng.getId();
        String file_name = ngoservice.uploadImage(file, id);
        if (file_name != null) {
            ngo.setLogo(file_name);
        }
        logger.info("Added Ngo with Banner Photo: "+file_name);

        ngoservice.UpdateNgoById(id, ngo);
        return ngo;
    }


    @GetMapping(value = "/ngo/image/{id}")
    public ResponseEntity<Resource> getNgoImage(@PathVariable("id") String ngoId) {

        System.out.println(ngoId);
        Ngo ngo = ngoservice.FetchNgoById(Long.parseLong(ngoId));

        if (ngo == null) {
            return ResponseEntity.notFound().build();
        }

        Resource image = ngoservice.loadImage(ngo);
        logger.info("Getting Banner "+image.getFilename());
       // if (image == null) {
         //   return ResponseEntity.notFound().build();
        //}
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment;name=" + image.getFilename()).body(image);
    }


}
