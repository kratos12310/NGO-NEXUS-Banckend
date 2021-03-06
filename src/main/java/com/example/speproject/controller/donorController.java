package com.example.speproject.controller;


import com.example.speproject.bean.Donor;
import com.example.speproject.bean.Ngo;
import com.example.speproject.service.donorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/")
@CrossOrigin("*")
public class donorController {
    Logger logger= LoggerFactory.getLogger(donorController.class);
   @Autowired
    private donorService donorservice;

    @PostMapping("/savedonor")
    public Donor saveDonor(@RequestBody Donor donor) {

        logger.info("Donor saved with name "+donor.getName());
        return donorservice.saveDonor(donor);
    }


    @PostMapping("/donorlogin")
    public Donor dlogin(@RequestBody Donor credentials) {
        Donor d = donorservice.dlogin(credentials.getEmail(),credentials.getPassword());
        System.out.println(d.getName());
        logger.info("Donor "+d.getName()+" logged in");
        return d;
    }

    @GetMapping("/donor/{id}")
    public Donor FetchDonorById(@PathVariable("id") Long id) {
    logger.info("Getting Donor Details of Donor ID "+id );
        return donorservice.FetchDonorById(id);
    }

}
