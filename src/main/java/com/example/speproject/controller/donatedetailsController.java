package com.example.speproject.controller;

import com.example.speproject.bean.DonateDetails;
import com.example.speproject.bean.Ngo;
import com.example.speproject.service.donatedetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin("*")
public class donatedetailsController {
    Logger logger= LoggerFactory.getLogger(donatedetailsController.class);
@Autowired
    private donatedetailsService donatedetailsservice;

    @PostMapping("/savedonatedetails")
    public DonateDetails saveDonateDetails(@RequestBody DonateDetails donatedetails) {
       logger.info("Saving Donation Details");
        return donatedetailsservice.saveDonateDetails(donatedetails);
    }
    @GetMapping("/getdonatedngo/{id}")
    public DonateDetails getDonateDetailsById(@PathVariable("id") Long id){
        logger.info("Getting Donation Details by id "+id);
        return donatedetailsservice.getdonatedetailsbyid(id);
    }
}
