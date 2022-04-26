package com.example.speproject.service;

import com.example.speproject.bean.DonateDetails;
import com.example.speproject.dao.donatedetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class donatedetailsServiceImpl implements donatedetailsService {
    @Autowired
    private donatedetailsDao donatedetailsdao;


    @Override
    public DonateDetails saveDonateDetails(DonateDetails donatedetails) {
        return donatedetailsdao.save(donatedetails);
    }
}
