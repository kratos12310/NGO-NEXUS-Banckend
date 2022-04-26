package com.example.speproject.controller;

import com.example.speproject.bean.DonateDetails;
import com.example.speproject.bean.Ngo;
import com.example.speproject.service.donatedetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@CrossOrigin("*")
public class donatedetailsController {
@Autowired
    private donatedetailsService donatedetailsservice;

    @PostMapping("/savedonatedetails")
    public DonateDetails saveDonateDetails(@RequestBody DonateDetails donatedetails) {
        return donatedetailsservice.saveDonateDetails(donatedetails);
    }
}
