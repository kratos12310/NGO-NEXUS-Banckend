package com.example.speproject.controller;


import com.example.speproject.bean.Donor;
import com.example.speproject.bean.Ngo;
import com.example.speproject.service.donorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@CrossOrigin("*")
public class donorController {
   @Autowired
    private donorService donorservice;

    @PostMapping("/savedonor")
    public Donor saveDonor(@RequestBody Donor donor) {
        return donorservice.saveDonor(donor);
    }


    @PostMapping("/donorlogin")
    public Donor dlogin(@RequestBody Donor credentials) {
        Donor d = donorservice.dlogin(credentials.getEmail(),credentials.getPassword());
        System.out.println(d.getName());
        return d;
    }

    @GetMapping("/donor/{id}")
    public Donor FetchDonorById(@PathVariable("id") Long id) {

        return donorservice.FetchDonorById(id);
    }

}
